#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "business_dynamics.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out job-creation)
    (struct-out job-destruction)
    (struct-out record)
    (struct-out firm-exits)
    (struct-out data)
    (struct-out establishments)
    (struct-out calculated)
    get-businesses
    main)

; Define the structs
(define-struct job-creation
    (count continuers rate rate/births births))

(define-struct job-destruction
    (continuers count rate rate/deaths deaths))

(define-struct record
    (state data year))

(define-struct firm-exits
    (count establishment-exit job-destruction))

(define-struct data
    (job-destruction number-of-firms job-creation calculated firm-exits establishments dhs-denominator))

(define-struct establishments
    (exited-rate entered-rate entered exited physical-locations))

(define-struct calculated
    (reallocation-rate net-job-creation net-job-creation-rate))



; Define the JSON->Struct mappers
(define (json->job-creation jdata)
    (make-job-creation
        (hash-ref jdata (string->symbol "Count"))
            (hash-ref jdata (string->symbol "Continuers"))
            (hash-ref jdata (string->symbol "Rate"))
            (hash-ref jdata (string->symbol "Rate/Births"))
            (hash-ref jdata (string->symbol "Births"))
            ))

(define (json->job-destruction jdata)
    (make-job-destruction
        (hash-ref jdata (string->symbol "Continuers"))
            (hash-ref jdata (string->symbol "Count"))
            (hash-ref jdata (string->symbol "Rate"))
            (hash-ref jdata (string->symbol "Rate/Deaths"))
            (hash-ref jdata (string->symbol "Deaths"))
            ))

(define (json->record jdata)
    (make-record
        (hash-ref jdata (string->symbol "State"))
            (json->data (hash-ref jdata (string->symbol "Data")))
                (hash-ref jdata (string->symbol "Year"))
            ))

(define (json->firm-exits jdata)
    (make-firm-exits
        (hash-ref jdata (string->symbol "Count"))
            (hash-ref jdata (string->symbol "Establishment Exit"))
            (hash-ref jdata (string->symbol "Job Destruction"))
            ))

(define (json->data jdata)
    (make-data
        (json->job-destruction (hash-ref jdata (string->symbol "Job Destruction")))
                (hash-ref jdata (string->symbol "Number of Firms"))
            (json->job-creation (hash-ref jdata (string->symbol "Job Creation")))
                (json->calculated (hash-ref jdata (string->symbol "Calculated")))
                (json->firm-exits (hash-ref jdata (string->symbol "Firm Exits")))
                (json->establishments (hash-ref jdata (string->symbol "Establishments")))
                (hash-ref jdata (string->symbol "DHS Denominator"))
            ))

(define (json->establishments jdata)
    (make-establishments
        (hash-ref jdata (string->symbol "Exited Rate"))
            (hash-ref jdata (string->symbol "Entered Rate"))
            (hash-ref jdata (string->symbol "Entered"))
            (hash-ref jdata (string->symbol "Exited"))
            (hash-ref jdata (string->symbol "Physical Locations"))
            ))

(define (json->calculated jdata)
    (make-calculated
        (hash-ref jdata (string->symbol "Reallocation Rate"))
            (hash-ref jdata (string->symbol "Net Job Creation"))
            (hash-ref jdata (string->symbol "Net Job Creation Rate"))
            ))



; Define the services, and their helpers

(define (get-businesses [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM business_dynamics LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->record result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM business_dynamics"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->record result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-businesses")
    (displayln (length (time (get-businesses false))))
    (displayln "Test get-businesses")
    (displayln (length (time (get-businesses true))))
    
    

    )