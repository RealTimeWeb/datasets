#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "injuries.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out report)
    (struct-out business)
    (struct-out address)
    (struct-out industry)
    (struct-out statistics)
    get-reports
    main)

; Define the structs
(define-struct report
    (address industry statistics business year))

(define-struct business
    (name second-name))

(define-struct address
    (city state street zip))

(define-struct industry
    (major-group division id label))

(define-struct statistics
    (total-case-rate days-away days-away/restricted/transfer))



; Define the JSON->Struct mappers
(define (json->report jdata)
    (make-report
        (json->address (hash-ref jdata (string->symbol "address")))
                (json->industry (hash-ref jdata (string->symbol "industry")))
                (json->statistics (hash-ref jdata (string->symbol "statistics")))
                (json->business (hash-ref jdata (string->symbol "business")))
                (hash-ref jdata (string->symbol "year"))
            ))

(define (json->business jdata)
    (make-business
        (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "second name"))
            ))

(define (json->address jdata)
    (make-address
        (hash-ref jdata (string->symbol "city"))
            (hash-ref jdata (string->symbol "state"))
            (hash-ref jdata (string->symbol "street"))
            (hash-ref jdata (string->symbol "zip"))
            ))

(define (json->industry jdata)
    (make-industry
        (hash-ref jdata (string->symbol "major_group"))
            (hash-ref jdata (string->symbol "division"))
            (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "label"))
            ))

(define (json->statistics jdata)
    (make-statistics
        (hash-ref jdata (string->symbol "total case rate"))
            (hash-ref jdata (string->symbol "days away"))
            (hash-ref jdata (string->symbol "days away/restricted/transfer"))
            ))



; Define the services, and their helpers

(define (get-reports [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM injuries LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM injuries"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-reports")
    (displayln (length (time (get-reports false))))
    (displayln "Test get-reports")
    (displayln (length (time (get-reports true))))
    
    

    )