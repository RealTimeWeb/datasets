#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "cars.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out car)
    (struct-out fuel-information)
    (struct-out identification)
    (struct-out dimensions)
    (struct-out engine-information)
    (struct-out engine-statistics)
    get-cars
    get-cars-by-year
    get-cars-by-make
    main)

; Define the structs
(define-struct car
    (engine-information identification dimensions fuel-information))

(define-struct fuel-information
    (highway-mpg city-mph fuel-type))

(define-struct identification
    (make model-year id classification year))

(define-struct dimensions
    (width length height))

(define-struct engine-information
    (transmission engine-type engine-statistics hybrid number-of-forward-gears driveline))

(define-struct engine-statistics
    (horsepower torque))



; Define the JSON->Struct mappers
(define (json->car jdata)
    (make-car
        (json->engine-information (hash-ref jdata (string->symbol "Engine Information")))
                (json->identification (hash-ref jdata (string->symbol "Identification")))
                (json->dimensions (hash-ref jdata (string->symbol "Dimensions")))
                (json->fuel-information (hash-ref jdata (string->symbol "Fuel Information")))
                ))

(define (json->fuel-information jdata)
    (make-fuel-information
        (hash-ref jdata (string->symbol "Highway mpg"))
            (hash-ref jdata (string->symbol "City mph"))
            (hash-ref jdata (string->symbol "Fuel Type"))
            ))

(define (json->identification jdata)
    (make-identification
        (hash-ref jdata (string->symbol "Make"))
            (hash-ref jdata (string->symbol "Model Year"))
            (hash-ref jdata (string->symbol "ID"))
            (hash-ref jdata (string->symbol "Classification"))
            (hash-ref jdata (string->symbol "Year"))
            ))

(define (json->dimensions jdata)
    (make-dimensions
        (hash-ref jdata (string->symbol "Width"))
            (hash-ref jdata (string->symbol "Length"))
            (hash-ref jdata (string->symbol "Height"))
            ))

(define (json->engine-information jdata)
    (make-engine-information
        (hash-ref jdata (string->symbol "Transmission"))
            (hash-ref jdata (string->symbol "Engine Type"))
            (json->engine-statistics (hash-ref jdata (string->symbol "Engine Statistics")))
                (hash-ref jdata (string->symbol "Hybrid"))
            (hash-ref jdata (string->symbol "Number of Forward Gears"))
            (hash-ref jdata (string->symbol "Driveline"))
            ))

(define (json->engine-statistics jdata)
    (make-engine-statistics
        (hash-ref jdata (string->symbol "Horsepower"))
            (hash-ref jdata (string->symbol "Torque"))
            ))



; Define the services, and their helpers

(define (get-cars [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM cars LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->car result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM cars"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->car result)
           ))
)

(define (get-cars-by-year year [test #t]) 
    (check-arg 'year (integer? year) 'integer 1 year)
     

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM cars WHERE year=? LIMIT ~a" hardware-limit)
                                year))
               (result (map string->jsexpr result))]
           (map json->car result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM cars WHERE year=?"
                                year
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->car result)
           ))
)

(define (get-cars-by-make make [test #t]) 
    (check-arg 'make (string? make) 'str 1 make)
    ; Ensure a match exists
    (let ([potentials (map string-downcase 
                           (query-list database "SELECT DISTINCT make FROM cars"))]
          [arg (string-downcase make)])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true)) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM cars WHERE make=? COLLATE NOCASE LIMIT ~a" hardware-limit)
                                make))
               (result (map string->jsexpr result))]
           (map json->car result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM cars WHERE make=? COLLATE NOCASE"
                                make
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->car result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-cars")
    (displayln (length (time (get-cars false))))
    (displayln "Test get-cars")
    (displayln (length (time (get-cars true))))
    
    
    (displayln "Production get-cars-by-year")
    (displayln (length (time (get-cars-by-year "2001" false))))
    (displayln "Test get-cars-by-year")
    (displayln (length (time (get-cars-by-year "2001" true))))
    
    
    (displayln "Production get-cars-by-make")
    (displayln (length (time (get-cars-by-make "'Pontiac'" false))))
    (displayln "Test get-cars-by-make")
    (displayln (length (time (get-cars-by-make "'Pontiac'" true))))
    
    

    )