#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "state_demographics.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out housing)
    (struct-out age)
    (struct-out miscellaneous)
    (struct-out ethnicities)
    (struct-out firms)
    (struct-out sales)
    (struct-out income)
    (struct-out education)
    (struct-out report)
    (struct-out employment)
    (struct-out population)
    get-all-states
    main)

; Define the structs
(define-struct housing
    (housing-units units-in-multi-unit-structures median-value-of-owner-occupied-units households persons-per-household homeownership-rate))

(define-struct age
    (percent-under-18-years percent-65-and-older percent-under-5-years))

(define-struct miscellaneous
    (manufacturers-shipments foreign-born percent-female language-other-than-english-at-home living-in-same-house-+1-years mean-travel-time-to-work building-permits veterans land-area))

(define-struct ethnicities
    (white-alone,-not-hispanic-or-latino two-or-more-races asian-alone native-hawaiian-and-other-pacific-islander-alone white-alone hispanic-or-latino black-alone american-indian-and-alaska-native-alone))

(define-struct firms
    (total hispanic-owned native-hawaiian-and-other-pacific-islander-owned american-indian-owned black-owned asian-owned women-owned))

(define-struct sales
    (retail-sales merchant-wholesaler-sales accommodation-and-food-services-sales retail-sales-per-capita))

(define-struct income
    (median-houseold-income per-capita-income persons-below-poverty-level))

(define-struct education
    (bachelor's-degree-or-higher high-school-or-higher))

(define-struct report
    (ethnicities age miscellaneous sales state income education employment housing population))

(define-struct employment
    (private-non-farm-establishments private-non-farm-employment-percent-change firms nonemployer-establishments private-non-farm-employment))

(define-struct population
    (2014-population 2010-population population-per-square-mile population-percent-change))



; Define the JSON->Struct mappers
(define (json->housing jdata)
    (make-housing
        (hash-ref jdata (string->symbol "Housing Units"))
            (hash-ref jdata (string->symbol "Units in Multi-Unit Structures"))
            (hash-ref jdata (string->symbol "Median Value of Owner-Occupied Units"))
            (hash-ref jdata (string->symbol "Households"))
            (hash-ref jdata (string->symbol "Persons per Household"))
            (hash-ref jdata (string->symbol "Homeownership Rate"))
            ))

(define (json->age jdata)
    (make-age
        (hash-ref jdata (string->symbol "Percent Under 18 Years"))
            (hash-ref jdata (string->symbol "Percent 65 and Older"))
            (hash-ref jdata (string->symbol "Percent Under 5 Years"))
            ))

(define (json->miscellaneous jdata)
    (make-miscellaneous
        (hash-ref jdata (string->symbol "Manufacturers Shipments"))
            (hash-ref jdata (string->symbol "Foreign Born"))
            (hash-ref jdata (string->symbol "Percent Female"))
            (hash-ref jdata (string->symbol "Language Other than English at Home"))
            (hash-ref jdata (string->symbol "Living in Same House +1 Years"))
            (hash-ref jdata (string->symbol "Mean Travel Time to Work"))
            (hash-ref jdata (string->symbol "Building Permits"))
            (hash-ref jdata (string->symbol "Veterans"))
            (hash-ref jdata (string->symbol "Land Area"))
            ))

(define (json->ethnicities jdata)
    (make-ethnicities
        (hash-ref jdata (string->symbol "White Alone, not Hispanic or Latino"))
            (hash-ref jdata (string->symbol "Two or More Races"))
            (hash-ref jdata (string->symbol "Asian Alone"))
            (hash-ref jdata (string->symbol "Native Hawaiian and Other Pacific Islander Alone"))
            (hash-ref jdata (string->symbol "White Alone"))
            (hash-ref jdata (string->symbol "Hispanic or Latino"))
            (hash-ref jdata (string->symbol "Black Alone"))
            (hash-ref jdata (string->symbol "American Indian and Alaska Native Alone"))
            ))

(define (json->firms jdata)
    (make-firms
        (hash-ref jdata (string->symbol "Total"))
            (hash-ref jdata (string->symbol "Hispanic-Owned"))
            (hash-ref jdata (string->symbol "Native Hawaiian and Other Pacific Islander-Owned"))
            (hash-ref jdata (string->symbol "American Indian-Owned"))
            (hash-ref jdata (string->symbol "Black-Owned"))
            (hash-ref jdata (string->symbol "Asian-Owned"))
            (hash-ref jdata (string->symbol "Women-Owned"))
            ))

(define (json->sales jdata)
    (make-sales
        (hash-ref jdata (string->symbol "Retail Sales"))
            (hash-ref jdata (string->symbol "Merchant Wholesaler Sales"))
            (hash-ref jdata (string->symbol "Accommodation and Food Services Sales"))
            (hash-ref jdata (string->symbol "Retail Sales per Capita"))
            ))

(define (json->income jdata)
    (make-income
        (hash-ref jdata (string->symbol "Median Houseold Income"))
            (hash-ref jdata (string->symbol "Per Capita Income"))
            (hash-ref jdata (string->symbol "Persons Below Poverty Level"))
            ))

(define (json->education jdata)
    (make-education
        (hash-ref jdata (string->symbol "Bachelor's Degree or Higher"))
            (hash-ref jdata (string->symbol "High School or Higher"))
            ))

(define (json->report jdata)
    (make-report
        (json->ethnicities (hash-ref jdata (string->symbol "Ethnicities")))
                (json->age (hash-ref jdata (string->symbol "Age")))
                (json->miscellaneous (hash-ref jdata (string->symbol "Miscellaneous")))
                (json->sales (hash-ref jdata (string->symbol "Sales")))
                (hash-ref jdata (string->symbol "State"))
            (json->income (hash-ref jdata (string->symbol "Income")))
                (json->education (hash-ref jdata (string->symbol "Education")))
                (json->employment (hash-ref jdata (string->symbol "Employment")))
                (json->housing (hash-ref jdata (string->symbol "Housing")))
                (json->population (hash-ref jdata (string->symbol "Population")))
                ))

(define (json->employment jdata)
    (make-employment
        (hash-ref jdata (string->symbol "Private Non-farm Establishments"))
            (hash-ref jdata (string->symbol "Private Non-farm Employment Percent Change"))
            (json->firms (hash-ref jdata (string->symbol "Firms")))
                (hash-ref jdata (string->symbol "Nonemployer Establishments"))
            (hash-ref jdata (string->symbol "Private Non-farm Employment"))
            ))

(define (json->population jdata)
    (make-population
        (hash-ref jdata (string->symbol "2014 Population"))
            (hash-ref jdata (string->symbol "2010 Population"))
            (hash-ref jdata (string->symbol "Population per Square Mile"))
            (hash-ref jdata (string->symbol "Population Percent Change"))
            ))



; Define the services, and their helpers

(define (get-all-states [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM demographics LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM demographics"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-all-states")
    (displayln (length (time (get-all-states false))))
    (displayln "Test get-all-states")
    (displayln (length (time (get-all-states true))))
    
    

    )