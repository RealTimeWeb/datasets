#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "aids.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out aids-related-deaths)
    (struct-out new-hiv-infections)
    (struct-out people-living-with-hiv)
    (struct-out hiv-prevalence)
    (struct-out report)
    (struct-out data)
    get-reports
    get-reports-by-year
    get-reports-by-country
    main)

; Define the structs
(define-struct aids-related-deaths
    (male-adults all-ages aids-orphans children female-adults adults))

(define-struct new-hiv-infections
    (incidence-rate-among-adults male-adults all-ages children female-adults adults))

(define-struct people-living-with-hiv
    (male-adults total children female-adults adults))

(define-struct hiv-prevalence
    (young-men adults young-women))

(define-struct report
    (country data year))

(define-struct data
    (hiv-prevalence people-living-with-hiv new-hiv-infections aids-related-deaths))



; Define the JSON->Struct mappers
(define (json->aids-related-deaths jdata)
    (make-aids-related-deaths
        (hash-ref jdata (string->symbol "Male Adults"))
            (hash-ref jdata (string->symbol "All Ages"))
            (hash-ref jdata (string->symbol "AIDS Orphans"))
            (hash-ref jdata (string->symbol "Children"))
            (hash-ref jdata (string->symbol "Female Adults"))
            (hash-ref jdata (string->symbol "Adults"))
            ))

(define (json->new-hiv-infections jdata)
    (make-new-hiv-infections
        (hash-ref jdata (string->symbol "Incidence Rate Among Adults"))
            (hash-ref jdata (string->symbol "Male Adults"))
            (hash-ref jdata (string->symbol "All Ages"))
            (hash-ref jdata (string->symbol "Children"))
            (hash-ref jdata (string->symbol "Female Adults"))
            (hash-ref jdata (string->symbol "Adults"))
            ))

(define (json->people-living-with-hiv jdata)
    (make-people-living-with-hiv
        (hash-ref jdata (string->symbol "Male Adults"))
            (hash-ref jdata (string->symbol "Total"))
            (hash-ref jdata (string->symbol "Children"))
            (hash-ref jdata (string->symbol "Female Adults"))
            (hash-ref jdata (string->symbol "Adults"))
            ))

(define (json->hiv-prevalence jdata)
    (make-hiv-prevalence
        (hash-ref jdata (string->symbol "Young Men"))
            (hash-ref jdata (string->symbol "Adults"))
            (hash-ref jdata (string->symbol "Young Women"))
            ))

(define (json->report jdata)
    (make-report
        (hash-ref jdata (string->symbol "Country"))
            (json->data (hash-ref jdata (string->symbol "Data")))
                (hash-ref jdata (string->symbol "Year"))
            ))

(define (json->data jdata)
    (make-data
        (json->hiv-prevalence (hash-ref jdata (string->symbol "HIV Prevalence")))
                (json->people-living-with-hiv (hash-ref jdata (string->symbol "People Living with HIV")))
                (json->new-hiv-infections (hash-ref jdata (string->symbol "New HIV Infections")))
                (json->aids-related-deaths (hash-ref jdata (string->symbol "AIDS-Related Deaths")))
                ))



; Define the services, and their helpers

(define (get-reports [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM aids LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM aids"
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
                           (query-list database "SELECT DISTINCT year FROM aids"))]
          [arg (string-downcase year)])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true)) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM aids WHERE year=? LIMIT ~a" hardware-limit)
                                year))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM aids WHERE year=?"
                                year
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)

(define (get-reports-by-country country [test #t]) 
    (check-arg 'country (string? country) 'str 1 country)
    ; Ensure a match exists
    (let ([potentials (map string-downcase 
                           (query-list database "SELECT DISTINCT country FROM aids"))]
          [arg (string-downcase country)])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true)) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM aids WHERE country=? LIMIT ~a" hardware-limit)
                                country))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM aids WHERE country=?"
                                country
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
    (displayln (length (time (get-reports-by-year 1990 false))))
    (displayln "Test get-reports-by-year")
    (displayln (length (time (get-reports-by-year 1990 true))))
    
    
    (displayln "Production get-reports-by-country")
    (displayln (length (time (get-reports-by-country "Afghanistan" false))))
    (displayln "Test get-reports-by-country")
    (displayln (length (time (get-reports-by-country "Afghanistan" true))))
    
    

    )