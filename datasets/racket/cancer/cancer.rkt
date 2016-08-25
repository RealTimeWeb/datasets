#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "cancer.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out age)
    (struct-out report)
    (struct-out data)
    get-reports
    get-reports-by-year
    get-reports-by-area
    main)

; Define the structs
(define-struct age
    (age-adjusted-rate age-adjusted-ci-lower age-adjusted-ci-upper))

(define-struct report
    (age area data year))

(define-struct data
    (count crude-rate crude-ci-upper crude-ci-lower sex race event-type population))



; Define the JSON->Struct mappers
(define (json->age jdata)
    (make-age
        (hash-ref jdata (string->symbol "Age Adjusted Rate"))
            (hash-ref jdata (string->symbol "Age Adjusted CI Lower"))
            (hash-ref jdata (string->symbol "Age Adjusted CI Upper"))
            ))

(define (json->report jdata)
    (make-report
        (json->age (hash-ref jdata (string->symbol "Age")))
                (hash-ref jdata (string->symbol "Area"))
            (json->data (hash-ref jdata (string->symbol "Data")))
                (hash-ref jdata (string->symbol "Year"))
            ))

(define (json->data jdata)
    (make-data
        (hash-ref jdata (string->symbol "Count"))
            (hash-ref jdata (string->symbol "Crude Rate"))
            (hash-ref jdata (string->symbol "Crude CI Upper"))
            (hash-ref jdata (string->symbol "Crude CI Lower"))
            (hash-ref jdata (string->symbol "Sex"))
            (hash-ref jdata (string->symbol "Race"))
            (hash-ref jdata (string->symbol "Event Type"))
            (hash-ref jdata (string->symbol "Population"))
            ))



; Define the services, and their helpers

(define (get-reports [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM cancer LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM cancer"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)

(define (get-reports-by-year year [test #t]) 
    (check-arg 'year (number? year) 'int 1 year)
    ; Ensure a match exists
    (let ([potentials (map string-downcase 
                           (query-list database "SELECT DISTINCT report FROM cancer"))]
          [arg (string-downcase year)])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true)) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM cancer WHERE year=? LIMIT ~a" hardware-limit)
                                year))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM cancer WHERE year=?"
                                year
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)

(define (get-reports-by-area area [test #t]) 
    (check-arg 'area (string? area) 'str 1 area)
    ; Ensure a match exists
    (let ([potentials (map string-downcase 
                           (query-list database "SELECT DISTINCT report FROM cancer"))]
          [arg (string-downcase area)])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true)) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM cancer WHERE year=? LIMIT ~a" hardware-limit)
                                area))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM cancer WHERE year=?"
                                area
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-reports")
    (displayln (length (time (get-reports false))))
    (displayln "Test get-reports")
    (displayln (length (time (get-reports true))))
    
    
    (displayln "Production get-reports-by-year")
    (displayln (length (time (get-reports-by-year "1999" false))))
    (displayln "Test get-reports-by-year")
    (displayln (length (time (get-reports-by-year "1999" true))))
    
    
    (displayln "Production get-reports-by-area")
    (displayln (length (time (get-reports-by-area "Alabama" false))))
    (displayln "Test get-reports-by-area")
    (displayln (length (time (get-reports-by-area "Alabama" true))))
    
    

    )