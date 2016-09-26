#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "tate.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out dimensions)
    (struct-out art)
    (struct-out data)
    (struct-out death)
    (struct-out artist)
    (struct-out birth)
    (struct-out metadata)
    get-artwork
    main)

; Define the structs
(define-struct dimensions
    (width depth height))

(define-struct art
    (artist data dimensions metadata))

(define-struct data
    (url medium thumbnail title))

(define-struct death
    (location year))

(define-struct artist
    (gender death role name birth))

(define-struct birth
    (location year))

(define-struct metadata
    (credit acquisition-date creation-decade creation-year))



; Define the JSON->Struct mappers
(define (json->dimensions jdata)
    (make-dimensions
        (hash-ref jdata (string->symbol "width"))
            (hash-ref jdata (string->symbol "depth"))
            (hash-ref jdata (string->symbol "height"))
            ))

(define (json->art jdata)
    (make-art
        (json->artist (hash-ref jdata (string->symbol "artist")))
                (json->data (hash-ref jdata (string->symbol "data")))
                (json->dimensions (hash-ref jdata (string->symbol "dimensions")))
                (json->metadata (hash-ref jdata (string->symbol "metadata")))
                ))

(define (json->data jdata)
    (make-data
        (hash-ref jdata (string->symbol "url"))
            (hash-ref jdata (string->symbol "medium"))
            (hash-ref jdata (string->symbol "thumbnail"))
            (hash-ref jdata (string->symbol "title"))
            ))

(define (json->death jdata)
    (make-death
        (hash-ref jdata (string->symbol "location"))
            (hash-ref jdata (string->symbol "year"))
            ))

(define (json->artist jdata)
    (make-artist
        (hash-ref jdata (string->symbol "gender"))
            (json->death (hash-ref jdata (string->symbol "death")))
                (hash-ref jdata (string->symbol "role"))
            (hash-ref jdata (string->symbol "name"))
            (json->birth (hash-ref jdata (string->symbol "birth")))
                ))

(define (json->birth jdata)
    (make-birth
        (hash-ref jdata (string->symbol "location"))
            (hash-ref jdata (string->symbol "year"))
            ))

(define (json->metadata jdata)
    (make-metadata
        (hash-ref jdata (string->symbol "credit"))
            (hash-ref jdata (string->symbol "acquisition date"))
            (hash-ref jdata (string->symbol "creation decade"))
            (hash-ref jdata (string->symbol "creation year"))
            ))



; Define the services, and their helpers

(define (get-artwork [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM tate LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->art result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM tate"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->art result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-artwork")
    (displayln (length (time (get-artwork false))))
    (displayln "Test get-artwork")
    (displayln (length (time (get-artwork true))))
    
    

    )