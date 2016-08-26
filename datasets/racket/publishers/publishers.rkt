#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "publishers.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out publisher)
    (struct-out book)
    (struct-out daily)
    (struct-out statistics)
    get-books
    main)

; Define the structs
(define-struct publisher
    (type name))

(define-struct book
    (genre publisher sold-by statistics daily))

(define-struct daily
    (publisher-revenue amazon-revenue author-revenue units-sold gross-sales))

(define-struct statistics
    (sales-rank sale-price total-reviews average-rating))



; Define the JSON->Struct mappers
(define (json->publisher jdata)
    (make-publisher
        (hash-ref jdata (string->symbol "type"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->book jdata)
    (make-book
        (hash-ref jdata (string->symbol "genre"))
            (json->publisher (hash-ref jdata (string->symbol "publisher")))
                (hash-ref jdata (string->symbol "sold by"))
            (json->statistics (hash-ref jdata (string->symbol "statistics")))
                (json->daily (hash-ref jdata (string->symbol "daily")))
                ))

(define (json->daily jdata)
    (make-daily
        (hash-ref jdata (string->symbol "publisher revenue"))
            (hash-ref jdata (string->symbol "amazon revenue"))
            (hash-ref jdata (string->symbol "author revenue"))
            (hash-ref jdata (string->symbol "units sold"))
            (hash-ref jdata (string->symbol "gross sales"))
            ))

(define (json->statistics jdata)
    (make-statistics
        (hash-ref jdata (string->symbol "sales rank"))
            (hash-ref jdata (string->symbol "sale price"))
            (hash-ref jdata (string->symbol "total reviews"))
            (hash-ref jdata (string->symbol "average rating"))
            ))



; Define the services, and their helpers

(define (get-books [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM publishers LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->book result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM publishers"
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