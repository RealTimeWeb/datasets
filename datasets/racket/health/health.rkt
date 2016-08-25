#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "health.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out report)
    get-reports-by-year
    get-reports-by-disease
    get-reports-by-location
    get-all-reports
    main)

; Define the structs
(define-struct report
    (loc number disease increase year population))



; Define the JSON->Struct mappers
(define (json->report jdata)
    (make-report
        (hash-ref jdata (string->symbol "loc"))
            (hash-ref jdata (string->symbol "number"))
            (hash-ref jdata (string->symbol "disease"))
            (hash-ref jdata (string->symbol "increase"))
            (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "population"))
            ))



; Define the services, and their helpers

(define (get-reports-by-year year [test #t]) 
    (check-arg 'year (number? year) 'int 1 year)
     

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM health WHERE year=? ORDER BY year, location, disease ASC LIMIT ~a" hardware-limit)
                                year))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM health WHERE year=? ORDER BY year, location, disease ASC"
                                year
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)

(define (get-reports-by-disease disease [test #t]) 
    (check-arg 'disease (string? disease) 'str 1 disease)
    ; Ensure a match exists
    (let ([potentials (map string-downcase 
                           (query-list database "SELECT DISTINCT disease FROM health"))]
          [arg (string-downcase disease)])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true)) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM health WHERE disease=? COLLATE NOCASE ORDER BY year, location, disease ASC LIMIT ~a" hardware-limit)
                                disease))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM health WHERE disease=? COLLATE NOCASE ORDER BY year, location, disease ASC"
                                disease
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)

(define (get-reports-by-location location [test #t]) 
    (check-arg 'location (string? location) 'str 1 location)
    ; Ensure a match exists
    (let ([potentials (map string-downcase 
                           (query-list database "SELECT DISTINCT location FROM health"))]
          [arg (string-downcase location)])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true)) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM health WHERE location=? COLLATE NOCASE ORDER BY year, location, disease ASC LIMIT ~a" hardware-limit)
                                location))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM health WHERE location=? COLLATE NOCASE ORDER BY year, location, disease ASC"
                                location
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)

(define (get-all-reports [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM health ORDER BY year, location, disease ASC LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM health ORDER BY year, location, disease ASC"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-reports-by-year")
    (displayln (length (time (get-reports-by-year "1990" false))))
    (displayln "Test get-reports-by-year")
    (displayln (length (time (get-reports-by-year "1990" true))))
    
    
    (displayln "Production get-reports-by-disease")
    (displayln (length (time (get-reports-by-disease "'MUMPS'" false))))
    (displayln "Test get-reports-by-disease")
    (displayln (length (time (get-reports-by-disease "'MUMPS'" true))))
    
    
    (displayln "Production get-reports-by-location")
    (displayln (length (time (get-reports-by-location "'Delaware'" false))))
    (displayln "Test get-reports-by-location")
    (displayln (length (time (get-reports-by-location "'Delaware'" true))))
    
    
    (displayln "Production get-all-reports")
    (displayln (length (time (get-all-reports false))))
    (displayln "Test get-all-reports")
    (displayln (length (time (get-all-reports true))))
    
    

    )