#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "hydropower.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out identity)
    (struct-out project)
    (struct-out dam)
    (struct-out location)
    (struct-out dimensions)
    get-dams
    main)

; Define the structs
(define-struct identity
    (project name watercourse))

(define-struct project
    (organization year))

(define-struct dam
    (location identity dimensions))

(define-struct location
    (latitude county state longitude))

(define-struct dimensions
    (crest-length crest-elevaion structural-height))



; Define the JSON->Struct mappers
(define (json->identity jdata)
    (make-identity
        (json->project (hash-ref jdata (string->symbol "Project")))
                (hash-ref jdata (string->symbol "Name"))
            (hash-ref jdata (string->symbol "Watercourse"))
            ))

(define (json->project jdata)
    (make-project
        (hash-ref jdata (string->symbol "Organization"))
            (hash-ref jdata (string->symbol "Year"))
            ))

(define (json->dam jdata)
    (make-dam
        (json->location (hash-ref jdata (string->symbol "Location")))
                (json->identity (hash-ref jdata (string->symbol "Identity")))
                (json->dimensions (hash-ref jdata (string->symbol "Dimensions")))
                ))

(define (json->location jdata)
    (make-location
        (hash-ref jdata (string->symbol "Latitude"))
            (hash-ref jdata (string->symbol "County"))
            (hash-ref jdata (string->symbol "State"))
            (hash-ref jdata (string->symbol "Longitude"))
            ))

(define (json->dimensions jdata)
    (make-dimensions
        (hash-ref jdata (string->symbol "Crest Length"))
            (hash-ref jdata (string->symbol "Crest Elevaion"))
            (hash-ref jdata (string->symbol "Structural Height"))
            ))



; Define the services, and their helpers

(define (get-dams ) 
(let* [(result (query-list database 
                                   "SELECT data FROM hydropower"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->dam result)
           )
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-dams")
    (displayln (length (time (get-dams ))))
    
    

    )