#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "classics.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out metadata)
    (struct-out statistics)
    (struct-out book)
    (struct-out author)
    (struct-out metrics)
    (struct-out formats)
    (struct-out sentiments)
    (struct-out bibliography)
    (struct-out difficulty)
    (struct-out publication)
    get-books
    main)

; Define the structs
(define-struct metadata
    (url downloads id rank formats))

(define-struct statistics
    (polysyllables characters average-sentence-length words sentences syllables average-sentence-per-word average-letter-per-word))

(define-struct book
    (metrics bibliography metadata))

(define-struct author
    (death name birth))

(define-struct metrics
    (difficulty statistics sentiments))

(define-struct formats
    (total types))

(define-struct sentiments
    (polarity subjectivity))

(define-struct bibliography
    (publication title author languages subjects congress-classifications type))

(define-struct difficulty
    (flesch-reading-ease automated-readability-index coleman-liau-index gunning-fog linsear-write-formula dale-chall-readability-score flesch-kincaid-grade smog-index difficult-words))

(define-struct publication
    (month-name full year day month))



; Define the JSON->Struct mappers
(define (json->metadata jdata)
    (make-metadata
        (hash-ref jdata (string->symbol "url"))
            (hash-ref jdata (string->symbol "downloads"))
            (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "rank"))
            (json->formats (hash-ref jdata (string->symbol "formats")))
                ))

(define (json->statistics jdata)
    (make-statistics
        (hash-ref jdata (string->symbol "polysyllables"))
            (hash-ref jdata (string->symbol "characters"))
            (hash-ref jdata (string->symbol "average sentence length"))
            (hash-ref jdata (string->symbol "words"))
            (hash-ref jdata (string->symbol "sentences"))
            (hash-ref jdata (string->symbol "syllables"))
            (hash-ref jdata (string->symbol "average sentence per word"))
            (hash-ref jdata (string->symbol "average letter per word"))
            ))

(define (json->book jdata)
    (make-book
        (json->metrics (hash-ref jdata (string->symbol "metrics")))
                (json->bibliography (hash-ref jdata (string->symbol "bibliography")))
                (json->metadata (hash-ref jdata (string->symbol "metadata")))
                ))

(define (json->author jdata)
    (make-author
        (hash-ref jdata (string->symbol "death"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "birth"))
            ))

(define (json->metrics jdata)
    (make-metrics
        (json->difficulty (hash-ref jdata (string->symbol "difficulty")))
                (json->statistics (hash-ref jdata (string->symbol "statistics")))
                (json->sentiments (hash-ref jdata (string->symbol "sentiments")))
                ))

(define (json->formats jdata)
    (make-formats
        (hash-ref jdata (string->symbol "total"))
            (hash-ref jdata (string->symbol "types"))
                    ))

(define (json->sentiments jdata)
    (make-sentiments
        (hash-ref jdata (string->symbol "polarity"))
            (hash-ref jdata (string->symbol "subjectivity"))
            ))

(define (json->bibliography jdata)
    (make-bibliography
        (json->publication (hash-ref jdata (string->symbol "publication")))
                (hash-ref jdata (string->symbol "title"))
            (json->author (hash-ref jdata (string->symbol "author")))
                (hash-ref jdata (string->symbol "languages"))
                    (hash-ref jdata (string->symbol "subjects"))
                    (hash-ref jdata (string->symbol "congress classifications"))
                    (hash-ref jdata (string->symbol "type"))
            ))

(define (json->difficulty jdata)
    (make-difficulty
        (hash-ref jdata (string->symbol "flesch reading ease"))
            (hash-ref jdata (string->symbol "automated readability index"))
            (hash-ref jdata (string->symbol "coleman liau index"))
            (hash-ref jdata (string->symbol "gunning fog"))
            (hash-ref jdata (string->symbol "linsear write formula"))
            (hash-ref jdata (string->symbol "dale chall readability score"))
            (hash-ref jdata (string->symbol "flesch kincaid grade"))
            (hash-ref jdata (string->symbol "smog index"))
            (hash-ref jdata (string->symbol "difficult words"))
            ))

(define (json->publication jdata)
    (make-publication
        (hash-ref jdata (string->symbol "month name"))
            (hash-ref jdata (string->symbol "full"))
            (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "day"))
            (hash-ref jdata (string->symbol "month"))
            ))



; Define the services, and their helpers

(define (get-books [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM classics LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->book result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM classics"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->book result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-books")
    (displayln (length (time (get-books false))))
    (displayln "Test get-books")
    (displayln (length (time (get-books true))))
    
    

    )