#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "energy.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out report)
    (struct-out data)
    (struct-out imports)
    (struct-out production)
    (struct-out consumption)
    (struct-out exports)
    get-reports
    main)

; Define the structs
(define-struct report
    (data year))

(define-struct data
    (imports exports production consumption))

(define-struct imports
    (crude-oil petroleum-products natural-gas electricity coal-coke coal total total-petroleum biofuels))

(define-struct production
    (crude-oil fossil-fuels natural-gas nuclear total-renewable biomass hydroelectric natural-gas-plant-liquids geothermal coal solar total wind))

(define-struct consumption
    (fossil-fuels natural-gas nuclear total-renewable petroleum biomass hydroelectric coal geothermal solar total wind))

(define-struct exports
    (crude-oil petroleum-products natural-gas electricity coal-coke coal total total-petroleum biofuels))



; Define the JSON->Struct mappers
(define (json->report jdata)
    (make-report
        (json->data (hash-ref jdata (string->symbol "data")))
                (hash-ref jdata (string->symbol "year"))
            ))

(define (json->data jdata)
    (make-data
        (json->imports (hash-ref jdata (string->symbol "imports")))
                (json->exports (hash-ref jdata (string->symbol "exports")))
                (json->production (hash-ref jdata (string->symbol "production")))
                (json->consumption (hash-ref jdata (string->symbol "consumption")))
                ))

(define (json->imports jdata)
    (make-imports
        (hash-ref jdata (string->symbol "crude oil"))
            (hash-ref jdata (string->symbol "petroleum products"))
            (hash-ref jdata (string->symbol "natural gas"))
            (hash-ref jdata (string->symbol "electricity"))
            (hash-ref jdata (string->symbol "coal coke"))
            (hash-ref jdata (string->symbol "coal"))
            (hash-ref jdata (string->symbol "total"))
            (hash-ref jdata (string->symbol "total petroleum"))
            (hash-ref jdata (string->symbol "biofuels"))
            ))

(define (json->production jdata)
    (make-production
        (hash-ref jdata (string->symbol "crude oil"))
            (hash-ref jdata (string->symbol "fossil fuels"))
            (hash-ref jdata (string->symbol "natural gas"))
            (hash-ref jdata (string->symbol "nuclear"))
            (hash-ref jdata (string->symbol "total renewable"))
            (hash-ref jdata (string->symbol "biomass"))
            (hash-ref jdata (string->symbol "hydroelectric"))
            (hash-ref jdata (string->symbol "natural gas plant liquids"))
            (hash-ref jdata (string->symbol "geothermal"))
            (hash-ref jdata (string->symbol "coal"))
            (hash-ref jdata (string->symbol "solar"))
            (hash-ref jdata (string->symbol "total"))
            (hash-ref jdata (string->symbol "wind"))
            ))

(define (json->consumption jdata)
    (make-consumption
        (hash-ref jdata (string->symbol "fossil fuels"))
            (hash-ref jdata (string->symbol "natural gas"))
            (hash-ref jdata (string->symbol "nuclear"))
            (hash-ref jdata (string->symbol "total renewable"))
            (hash-ref jdata (string->symbol "petroleum"))
            (hash-ref jdata (string->symbol "biomass"))
            (hash-ref jdata (string->symbol "hydroelectric"))
            (hash-ref jdata (string->symbol "coal"))
            (hash-ref jdata (string->symbol "geothermal"))
            (hash-ref jdata (string->symbol "solar"))
            (hash-ref jdata (string->symbol "total"))
            (hash-ref jdata (string->symbol "wind"))
            ))

(define (json->exports jdata)
    (make-exports
        (hash-ref jdata (string->symbol "crude oil"))
            (hash-ref jdata (string->symbol "petroleum products"))
            (hash-ref jdata (string->symbol "natural gas"))
            (hash-ref jdata (string->symbol "electricity"))
            (hash-ref jdata (string->symbol "coal coke"))
            (hash-ref jdata (string->symbol "coal"))
            (hash-ref jdata (string->symbol "total"))
            (hash-ref jdata (string->symbol "total petroleum"))
            (hash-ref jdata (string->symbol "biofuels"))
            ))



; Define the services, and their helpers

(define (get-reports ) 
(let* [(result (query-list database 
                                   "SELECT data FROM energy"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           )
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-reports")
    (displayln (length (time (get-reports ))))
    
    

    )