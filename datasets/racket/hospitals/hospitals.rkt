#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "hospitals.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out hospital)
    (struct-out location)
    (struct-out outpatient-volume)
    (struct-out information)
    get-hospitals
    main)

; Define the structs
(define-struct hospital
    (information outpatient-volume provider-id location))

(define-struct location
    (city zip-code longitude county state address latitude))

(define-struct outpatient-volume
    (genitourinary eye nervous-system musculoskeletal skin gastrointestinal cardiovascular))

(define-struct information
    (type phone-number emergency-services name ownership))



; Define the JSON->Struct mappers
(define (json->hospital jdata)
    (make-hospital
        (json->information (hash-ref jdata (string->symbol "Information")))
                (json->outpatient-volume (hash-ref jdata (string->symbol "Outpatient Volume")))
                (hash-ref jdata (string->symbol "Provider ID"))
            (json->location (hash-ref jdata (string->symbol "Location")))
                ))

(define (json->location jdata)
    (make-location
        (hash-ref jdata (string->symbol "City"))
            (hash-ref jdata (string->symbol "ZIP Code"))
            (hash-ref jdata (string->symbol "Longitude"))
            (hash-ref jdata (string->symbol "County"))
            (hash-ref jdata (string->symbol "State"))
            (hash-ref jdata (string->symbol "Address"))
            (hash-ref jdata (string->symbol "Latitude"))
            ))

(define (json->outpatient-volume jdata)
    (make-outpatient-volume
        (hash-ref jdata (string->symbol "Genitourinary"))
            (hash-ref jdata (string->symbol "Eye"))
            (hash-ref jdata (string->symbol "Nervous System"))
            (hash-ref jdata (string->symbol "Musculoskeletal"))
            (hash-ref jdata (string->symbol "Skin"))
            (hash-ref jdata (string->symbol "Gastrointestinal"))
            (hash-ref jdata (string->symbol "Cardiovascular"))
            ))

(define (json->information jdata)
    (make-information
        (hash-ref jdata (string->symbol "Type"))
            (hash-ref jdata (string->symbol "Phone Number"))
            (hash-ref jdata (string->symbol "Emergency Services"))
            (hash-ref jdata (string->symbol "Name"))
            (hash-ref jdata (string->symbol "Ownership"))
            ))



; Define the services, and their helpers

(define (get-hospitals [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM hospitals LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->hospital result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM hospitals"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->hospital result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-hospitals")
    (displayln (length (time (get-hospitals false))))
    (displayln "Test get-hospitals")
    (displayln (length (time (get-hospitals true))))
    
    

    )