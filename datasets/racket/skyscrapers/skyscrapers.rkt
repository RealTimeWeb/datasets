#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "skyscrapers.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out purposes)
    (struct-out statistics)
    (struct-out location)
    (struct-out skyscraper)
    (struct-out started)
    (struct-out completed)
    (struct-out status)
    get-skyscrapers
    main)

; Define the structs
(define-struct purposes
    (bridge industrial office library education religious telecommunications belltower residential hospital other exhibition serviced-apartments multiple government hotel commercial abandoned observation air-traffic-control-tower casino retail museum))

(define-struct statistics
    (number-of-purposes floors-above rank height))

(define-struct location
    (city city-id country country-id longitude latitude))

(define-struct skyscraper
    (status statistics name material purposes location id))

(define-struct started
    (is-started year))

(define-struct completed
    (is-completed year))

(define-struct status
    (current started completed))



; Define the JSON->Struct mappers
(define (json->purposes jdata)
    (make-purposes
        (hash-ref jdata (string->symbol "bridge"))
            (hash-ref jdata (string->symbol "industrial"))
            (hash-ref jdata (string->symbol "office"))
            (hash-ref jdata (string->symbol "library"))
            (hash-ref jdata (string->symbol "education"))
            (hash-ref jdata (string->symbol "religious"))
            (hash-ref jdata (string->symbol "telecommunications"))
            (hash-ref jdata (string->symbol "belltower"))
            (hash-ref jdata (string->symbol "residential"))
            (hash-ref jdata (string->symbol "hospital"))
            (hash-ref jdata (string->symbol "other"))
            (hash-ref jdata (string->symbol "exhibition"))
            (hash-ref jdata (string->symbol "serviced apartments"))
            (hash-ref jdata (string->symbol "multiple"))
            (hash-ref jdata (string->symbol "government"))
            (hash-ref jdata (string->symbol "hotel"))
            (hash-ref jdata (string->symbol "commercial"))
            (hash-ref jdata (string->symbol "abandoned"))
            (hash-ref jdata (string->symbol "observation"))
            (hash-ref jdata (string->symbol "air traffic control tower"))
            (hash-ref jdata (string->symbol "casino"))
            (hash-ref jdata (string->symbol "retail"))
            (hash-ref jdata (string->symbol "museum"))
            ))

(define (json->statistics jdata)
    (make-statistics
        (hash-ref jdata (string->symbol "number of purposes"))
            (hash-ref jdata (string->symbol "floors above"))
            (hash-ref jdata (string->symbol "rank"))
            (hash-ref jdata (string->symbol "height"))
            ))

(define (json->location jdata)
    (make-location
        (hash-ref jdata (string->symbol "city"))
            (hash-ref jdata (string->symbol "city_id"))
            (hash-ref jdata (string->symbol "country"))
            (hash-ref jdata (string->symbol "country id"))
            (hash-ref jdata (string->symbol "longitude"))
            (hash-ref jdata (string->symbol "latitude"))
            ))

(define (json->skyscraper jdata)
    (make-skyscraper
        (json->status (hash-ref jdata (string->symbol "status")))
                (json->statistics (hash-ref jdata (string->symbol "statistics")))
                (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "material"))
            (json->purposes (hash-ref jdata (string->symbol "purposes")))
                (json->location (hash-ref jdata (string->symbol "location")))
                (hash-ref jdata (string->symbol "id"))
            ))

(define (json->started jdata)
    (make-started
        (hash-ref jdata (string->symbol "is started"))
            (hash-ref jdata (string->symbol "year"))
            ))

(define (json->completed jdata)
    (make-completed
        (hash-ref jdata (string->symbol "is completed"))
            (hash-ref jdata (string->symbol "year"))
            ))

(define (json->status jdata)
    (make-status
        (hash-ref jdata (string->symbol "current"))
            (json->started (hash-ref jdata (string->symbol "started")))
                (json->completed (hash-ref jdata (string->symbol "completed")))
                ))



; Define the services, and their helpers

(define (get-skyscrapers [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM skyscrapers LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->skyscraper result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM skyscrapers"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->skyscraper result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-skyscrapers")
    (displayln (length (time (get-skyscrapers false))))
    (displayln "Test get-skyscrapers")
    (displayln (length (time (get-skyscrapers true))))
    
    

    )