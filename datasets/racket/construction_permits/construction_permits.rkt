#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "construction_permits.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out permit)
    (struct-out valuations)
    (struct-out period)
    (struct-out locations)
    (struct-out #-of-permits)
    get-records
    main)

; Define the structs
(define-struct permit
    (period locations))

(define-struct valuations
    (2-units 5+-units 3-4-units 1-unit))

(define-struct period
    (month-name full year month))

(define-struct locations
    (#-of-permits name valuations level))

(define-struct #-of-permits
    (2-units 5+-units 3-4-units 1-unit))



; Define the JSON->Struct mappers
(define (json->permit jdata)
    (make-permit
        (json->period (hash-ref jdata (string->symbol "period")))
                (map json->locations (hash-ref jdata (string->symbol "locations")))
                    ))

(define (json->valuations jdata)
    (make-valuations
        (hash-ref jdata (string->symbol "2 units"))
            (hash-ref jdata (string->symbol "5+ units"))
            (hash-ref jdata (string->symbol "3-4 units"))
            (hash-ref jdata (string->symbol "1 unit"))
            ))

(define (json->period jdata)
    (make-period
        (hash-ref jdata (string->symbol "month name"))
            (hash-ref jdata (string->symbol "full"))
            (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "month"))
            ))

(define (json->locations jdata)
    (make-locations
        (json->#-of-permits (hash-ref jdata (string->symbol "# of permits")))
                (hash-ref jdata (string->symbol "name"))
            (json->valuations (hash-ref jdata (string->symbol "valuations")))
                (hash-ref jdata (string->symbol "level"))
            ))

(define (json->#-of-permits jdata)
    (make-#-of-permits
        (hash-ref jdata (string->symbol "2 units"))
            (hash-ref jdata (string->symbol "5+ units"))
            (hash-ref jdata (string->symbol "3-4 units"))
            (hash-ref jdata (string->symbol "1 unit"))
            ))



; Define the services, and their helpers

(define (get-records [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM constructionpermits LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->permit result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM constructionpermits"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->permit result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-records")
    (displayln (length (time (get-records false))))
    (displayln "Test get-records")
    (displayln (length (time (get-records true))))
    
    

    )