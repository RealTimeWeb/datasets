#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "earthquakes.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out impact)
    (struct-out location)
    (struct-out earthquake)
    (struct-out time)
    get-earthquakes
    main)

; Define the structs
(define-struct impact
    (gap magnitude significance))

(define-struct location
    (distance full state longitude depth latitude))

(define-struct earthquake
    (impact id location time))

(define-struct time
    (full hour second month epoch year day minute))



; Define the JSON->Struct mappers
(define (json->impact jdata)
    (make-impact
        (hash-ref jdata (string->symbol "gap"))
            (hash-ref jdata (string->symbol "magnitude"))
            (hash-ref jdata (string->symbol "significance"))
            ))

(define (json->location jdata)
    (make-location
        (hash-ref jdata (string->symbol "distance"))
            (hash-ref jdata (string->symbol "full"))
            (hash-ref jdata (string->symbol "state"))
            (hash-ref jdata (string->symbol "longitude"))
            (hash-ref jdata (string->symbol "depth"))
            (hash-ref jdata (string->symbol "latitude"))
            ))

(define (json->earthquake jdata)
    (make-earthquake
        (json->impact (hash-ref jdata (string->symbol "impact")))
                (hash-ref jdata (string->symbol "id"))
            (json->location (hash-ref jdata (string->symbol "location")))
                (json->time (hash-ref jdata (string->symbol "time")))
                ))

(define (json->time jdata)
    (make-time
        (hash-ref jdata (string->symbol "full"))
            (hash-ref jdata (string->symbol "hour"))
            (hash-ref jdata (string->symbol "second"))
            (hash-ref jdata (string->symbol "month"))
            (hash-ref jdata (string->symbol "epoch"))
            (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "day"))
            (hash-ref jdata (string->symbol "minute"))
            ))



; Define the services, and their helpers

(define (get-earthquakes ) 
(let* [(result (query-list database 
                                   "SELECT data FROM earthquakes"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->earthquake result)
           )
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-earthquakes")
    (displayln (length (time (get-earthquakes ))))
    
    

    )