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
    get-cars
    get-cars-by-year
    get-cars-by-make
    main)

; Define the structs
(define-struct car
    (acceleration highway-mpg make hybrid base-curb-weight width year id engine fuel city-mpg transmission length top-speed classification engine-type torque height number-of-forward-gears horsepower driveline model-year size))


(define (json->car jdata)
    (make-car
        (hash-ref jdata (string->symbol "Acceleration"))
        (hash-ref jdata (string->symbol "highway_mpg"))
        (hash-ref jdata (string->symbol "Make"))
        (hash-ref jdata (string->symbol "Hybrid"))
        (hash-ref jdata (string->symbol "Base Curb Weight"))
        (hash-ref jdata (string->symbol "Width"))
        (hash-ref jdata (string->symbol "year"))
        (hash-ref jdata (string->symbol "id"))
        (hash-ref jdata (string->symbol "Engine"))
        (hash-ref jdata (string->symbol "fuel"))
        (hash-ref jdata (string->symbol "city_mpg"))
        (hash-ref jdata (string->symbol "Transmission"))
        (hash-ref jdata (string->symbol "Length"))
        (hash-ref jdata (string->symbol "Top Speed"))
        (hash-ref jdata (string->symbol "Classification"))
        (hash-ref jdata (string->symbol "Engine Type"))
        (hash-ref jdata (string->symbol "Torque"))
        (hash-ref jdata (string->symbol "Height"))
        (hash-ref jdata (string->symbol "Number Of Forward Gears"))
        (hash-ref jdata (string->symbol "Horsepower"))
        (hash-ref jdata (string->symbol "Driveline"))
        (hash-ref jdata (string->symbol "Model Year"))
        (hash-ref jdata (string->symbol "Size"))
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
    (check-arg 'make (str? make) 'str 1 make)
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