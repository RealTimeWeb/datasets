#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "medal_of_honor.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out awardee)
    (struct-out birth)
    (struct-out metadata)
    (struct-out date)
    (struct-out awarded)
    (struct-out location)
    (struct-out military-record)
    (struct-out date)
    get-awardees
    main)

; Define the structs
(define-struct awardee
    (death name awarded birth military-record metadata))

(define-struct birth
    (date location))

(define-struct metadata
    (link))

(define-struct date
    (year day month))

(define-struct awarded
    (issued citation g.o.-number accredited-to location date))

(define-struct location
    (latitude name longitude))

(define-struct military-record
    (entered-service-at company organization rank division))

(define-struct date
    (year day month))



; Define the JSON->Struct mappers
(define (json->awardee jdata)
    (make-awardee
        (hash-ref jdata (string->symbol "death"))
            (hash-ref jdata (string->symbol "name"))
            (json->awarded (hash-ref jdata (string->symbol "awarded")))
                (json->birth (hash-ref jdata (string->symbol "birth")))
                (json->military-record (hash-ref jdata (string->symbol "military record")))
                (json->metadata (hash-ref jdata (string->symbol "metadata")))
                ))

(define (json->birth jdata)
    (make-birth
        (json->date (hash-ref jdata (string->symbol "date")))
                (hash-ref jdata (string->symbol "location"))
            ))

(define (json->metadata jdata)
    (make-metadata
        (hash-ref jdata (string->symbol "link"))
            ))

(define (json->date jdata)
    (make-date
        (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "day"))
            (hash-ref jdata (string->symbol "month"))
            ))

(define (json->awarded jdata)
    (make-awarded
        (hash-ref jdata (string->symbol "issued"))
            (hash-ref jdata (string->symbol "citation"))
            (hash-ref (hash-ref (hash-ref jdata (string->symbol "g")) (string->symbol "o")) (string->symbol " number"))
            (hash-ref jdata (string->symbol "accredited to"))
            (json->location (hash-ref jdata (string->symbol "location")))
                (json->date (hash-ref jdata (string->symbol "date")))
                ))

(define (json->location jdata)
    (make-location
        (hash-ref jdata (string->symbol "latitude"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "longitude"))
            ))

(define (json->military-record jdata)
    (make-military-record
        (hash-ref jdata (string->symbol "entered service at"))
            (hash-ref jdata (string->symbol "company"))
            (hash-ref jdata (string->symbol "organization"))
            (hash-ref jdata (string->symbol "rank"))
            (hash-ref jdata (string->symbol "division"))
            ))

(define (json->date jdata)
    (make-date
        (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "day"))
            (hash-ref jdata (string->symbol "month"))
            ))



; Define the services, and their helpers

(define (get-awardees [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM medal_of_honor LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->awardee result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM medal_of_honor"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->awardee result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-awardees")
    (displayln (length (time (get-awardees false))))
    (displayln "Test get-awardees")
    (displayln (length (time (get-awardees true))))
    
    

    )