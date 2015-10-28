#lang racket

;; this module provides functions and structures for extracting links from http://reddit.com

;; ---------------------------------------------------------------------------------------------------
;; interface

(provide
 
 image/raw
 disconnect
 connect
 post->string
 get->string
 )

;; ---------------------------------------------------------------------------------------------------
;; implementation: public 


; Load the internal libraries
(require net/url)
(require srfi/19)
(require srfi/6)
(require racket/port)
(require json)
(require net/uri-codec)
(require htdp/error)
(require racket/file)
(require 2htdp/image)

; Handle connections
(define CONNECTION false)
(define CLIENT_STORE false)
(define URL_PATTERN (make-hash))
(define URL_COUNTER (make-hash))
(define URL_COUNT (make-hash))
(define (process-cache-entry entry)
  (begin
    (hash-set! URL_COUNTER (car entry) 1)
    (hash-set! URL_COUNT (car entry) (length (cdr entry)))
    (hash-set! URL_PATTERN (car entry) (first (cdr entry)))))
(define (preprocess-cache)
  (for-each process-cache-entry
            (hash->list (hash-ref CLIENT_STORE 'data))))
(define (disconnect [filename "cache.json"])
  (begin
    (set! CONNECTION false)
    (set! CLIENT_STORE (read-json (open-input-file filename)))
    (preprocess-cache)))
(define (connect)
  (set! CONNECTION true))

; Converts a raw binary string into a racket image
(define (image/raw raw)
  (letrec ((temp-image-file (make-temporary-file))
           (temp-image-output (open-output-file temp-image-file
                                                #:mode 'binary
                                                #:exists 'truncate)))
    (write-bytes (string->bytes/latin-1 raw) temp-image-output)
    (close-output-port temp-image-output)
    (let ((return-image (bitmap/file temp-image-file)))
      (delete-file temp-image-file)
      return-image)))

; Converting booleans to/from strings
(define (boolean->string a-boolean)
  (if a-boolean "true" "false"))

(define (string->boolean a-string)
  (string=? a-string "true"))

; Convert a pair into "data=value"
(define (key-value pair)
  (string-append (symbol->string (car pair)) "=" (cdr pair)))
; 
(define (convert-post-args data)
  (string->bytes/utf-8 (alist->form-urlencoded data)))
; 
(define (convert-get-args url data)
  (string-append url "?" (string-join (map key-value data) "&")))

(define (hash-request url data)
  (string->symbol (if (empty? data)
                      url
                      (string-append url "?" (string-join (map key-value data) "&")))))

(define (client-store-ref key)
  (hash-ref (hash-ref CLIENT_STORE 'data) key))

(define (cache-lookup key)
  (if (hash-has-key? (hash-ref CLIENT_STORE 'data) key)
      (letrec ((result-list (client-store-ref key))
               (current (hash-ref URL_COUNTER key))
               (max (hash-ref URL_COUNT key))
               (pattern (hash-ref URL_PATTERN key)))
        (if (>= (+ 1 current) max)
            (cond [(string=? pattern "loop")
                   (hash-set! URL_COUNTER key 1)]
                  [(string=? pattern "empty")
                   (hash-set! URL_COUNTER key max)])
            (hash-set! URL_COUNTER key (+ 1 current)))
        (cond [(and (string=? pattern "empty") 
                    (= current max))
               ""]
              [(= max 1) ""]
              [else (list-ref result-list current)]))
      #f))

(define (post->string url full-data index-data)
  (if CONNECTION
      (port->string (post-pure-port (string->url url) (convert-post-args full-data)))
      (cache-lookup (hash-request url index-data))))

(define (get->string url full-data index-data)
  (if CONNECTION
      (port->string (get-pure-port (string->url (convert-get-args url full-data))))
      (cache-lookup (hash-request url index-data))))

; Convert an individual image to a url
(define (bitmap/cache-url url)
  (if CONNECTION
      (bitmap/url url)
      (image/raw (cache-lookup (string->symbol url)))))
