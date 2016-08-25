#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "airlines.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 100)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out #-of-delays)
    (struct-out carrier)
    (struct-out minutes-delayed)
    (struct-out flights)
    (struct-out airport)
    (struct-out airline)
    (struct-out statistics)
    (struct-out time)
    get-reports
    main)

; Define the structs
(define-struct #-of-delays
    (late-aircraft weather security national-aviation-system carrier))

(define-struct carrier
    (code name))

(define-struct minutes-delayed
    (late-aircraft weather carrier security total national-aviation-system))

(define-struct flights
    (cancelled on-time total delayed diverted))

(define-struct airport
    (code name))

(define-struct airline
    (airport statistics time carrier))

(define-struct statistics
    (flights #-of-delays minutes-delayed))

(define-struct time
    (label year month))



; Define the JSON->Struct mappers
(define (json->#-of-delays jdata)
    (make-#-of-delays
        (hash-ref jdata (string->symbol "late aircraft"))
            (hash-ref jdata (string->symbol "weather"))
            (hash-ref jdata (string->symbol "security"))
            (hash-ref jdata (string->symbol "national aviation system"))
            (hash-ref jdata (string->symbol "carrier"))
            ))

(define (json->carrier jdata)
    (make-carrier
        (hash-ref jdata (string->symbol "code"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->minutes-delayed jdata)
    (make-minutes-delayed
        (hash-ref jdata (string->symbol "late aircraft"))
            (hash-ref jdata (string->symbol "weather"))
            (hash-ref jdata (string->symbol "carrier"))
            (hash-ref jdata (string->symbol "security"))
            (hash-ref jdata (string->symbol "total"))
            (hash-ref jdata (string->symbol "national aviation system"))
            ))

(define (json->flights jdata)
    (make-flights
        (hash-ref jdata (string->symbol "cancelled"))
            (hash-ref jdata (string->symbol "on time"))
            (hash-ref jdata (string->symbol "total"))
            (hash-ref jdata (string->symbol "delayed"))
            (hash-ref jdata (string->symbol "diverted"))
            ))

(define (json->airport jdata)
    (make-airport
        (hash-ref jdata (string->symbol "code"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->airline jdata)
    (make-airline
        (json->airport (hash-ref jdata (string->symbol "airport")))
                (json->statistics (hash-ref jdata (string->symbol "statistics")))
                (json->time (hash-ref jdata (string->symbol "time")))
                (json->carrier (hash-ref jdata (string->symbol "carrier")))
                ))

(define (json->statistics jdata)
    (make-statistics
        (json->flights (hash-ref jdata (string->symbol "flights")))
                (json->#-of-delays (hash-ref jdata (string->symbol "# of delays")))
                (json->minutes-delayed (hash-ref jdata (string->symbol "minutes delayed")))
                ))

(define (json->time jdata)
    (make-time
        (hash-ref jdata (string->symbol "label"))
            (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "month"))
            ))



; Define the services, and their helpers

(define (get-reports [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM airlines LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->airline result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM airlines"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->airline result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-reports")
    (displayln (length (time (get-reports false))))
    (displayln "Test get-reports")
    (displayln (length (time (get-reports true))))
    
    

    )