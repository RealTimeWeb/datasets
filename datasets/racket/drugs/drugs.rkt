#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "drugs.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 100)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out dependence-past-year)
    (struct-out new-users)
    (struct-out use-past-month)
    (struct-out all-except-marijuana-used-past-month)
    (struct-out used-past-month)
    (struct-out need-treatment-past-year)
    (struct-out abuse-past-year)
    (struct-out alcohol)
    (struct-out abuse-past-year)
    (struct-out binge-past-month)
    (struct-out pain-relievers-abuse-past-year)
    (struct-out dependence-past-year)
    (struct-out need-treatment-past-year)
    (struct-out abuse-past-month)
    (struct-out used-past-month)
    (struct-out tobacco)
    (struct-out population)
    (struct-out cigarette-past-month)
    (struct-out alcohol)
    (struct-out perceptions-of-risk)
    (struct-out cocaine-used-past-year)
    (struct-out used-past-year)
    (struct-out illicit-drugs)
    (struct-out marijuana)
    (struct-out dependence-past-year)
    (struct-out marijuana)
    (struct-out totals)
    (struct-out binge-past-month)
    (struct-out all-except-marijuana-used-past-month)
    (struct-out tobacco)
    (struct-out perceptions-of-risk)
    (struct-out used-past-year)
    (struct-out illicit-drugs)
    (struct-out report)
    (struct-out perceptions-of-risk)
    (struct-out used-past-month)
    (struct-out perceptions-of-risk)
    (struct-out in-minors)
    (struct-out use-past-month)
    (struct-out abuse-past-month)
    (struct-out cocaine-used-past-year)
    (struct-out use-past-month)
    (struct-out pain-relievers-abuse-past-year)
    (struct-out need-treatment-past-year)
    (struct-out perceptions-of-risk)
    (struct-out in-minors)
    (struct-out perceptions-of-risk)
    (struct-out used-past-month)
    (struct-out dependence-past-year)
    (struct-out use-past-month)
    (struct-out cigarette-past-month)
    (struct-out new-users)
    (struct-out need-treatment-past-year)
    (struct-out rates)
    get-reports
    main)

; Define the structs
(define-struct dependence-past-year
    (26+ 18-25 12-17))

(define-struct new-users
    (26+ 18-25 12-17))

(define-struct use-past-month
    (26+ 18-25 12-17))

(define-struct all-except-marijuana-used-past-month
    (26+ 18-25 12-17))

(define-struct used-past-month
    (26+ 18-25 12-17))

(define-struct need-treatment-past-year
    (26+ 18-25 12-17))

(define-struct abuse-past-year
    (26+ 18-25 12-17))

(define-struct alcohol
    (abuse-past-year binge-past-month perceptions-of-risk dependence-past-year in-minors use-past-month need-treatment-past-year))

(define-struct abuse-past-year
    (26+ 18-25 12-17))

(define-struct binge-past-month
    (26+ 18-25 12-17))

(define-struct pain-relievers-abuse-past-year
    (26+ 18-25 12-17))

(define-struct dependence-past-year
    (26+ 18-25 12-17))

(define-struct need-treatment-past-year
    (26+ 18-25 12-17))

(define-struct abuse-past-month
    (26+ 18-25 12-17))

(define-struct used-past-month
    (26+ 18-25 12-17))

(define-struct tobacco
    (cigarette-past-month use-past-month perceptions-of-risk))

(define-struct population
    (26+ 18-25 12-17 12-20))

(define-struct cigarette-past-month
    (26+ 18-25 12-17))

(define-struct alcohol
    (abuse-past-year binge-past-month perceptions-of-risk dependence-past-year in-minors use-past-month need-treatment-past-year))

(define-struct perceptions-of-risk
    (26+ 18-25 12-17))

(define-struct cocaine-used-past-year
    (26+ 18-25 12-17))

(define-struct used-past-year
    (26+ 18-25 12-17))

(define-struct illicit-drugs
    (abuse-past-month dependence-past-year all-except-marijuana-used-past-month cocaine-used-past-year used-past-month need-treatment-past-year))

(define-struct marijuana
    (new-users used-past-month used-past-year perceptions-of-risk))

(define-struct dependence-past-year
    (26+ 18-25 12-17))

(define-struct marijuana
    (new-users used-past-month used-past-year perceptions-of-risk))

(define-struct totals
    (pain-relievers-abuse-past-year illicit-drugs marijuana tobacco alcohol))

(define-struct binge-past-month
    (26+ 18-25 12-17))

(define-struct all-except-marijuana-used-past-month
    (26+ 18-25 12-17))

(define-struct tobacco
    (cigarette-past-month use-past-month perceptions-of-risk))

(define-struct perceptions-of-risk
    (26+ 18-25 12-17))

(define-struct used-past-year
    (26+ 18-25 12-17))

(define-struct illicit-drugs
    (abuse-past-month dependence-past-year all-except-marijuana-used-past-month cocaine-used-past-year used-past-month need-treatment-past-year))

(define-struct report
    (state year rates population totals))

(define-struct perceptions-of-risk
    (26+ 18-25 12-17))

(define-struct used-past-month
    (26+ 18-25 12-17))

(define-struct perceptions-of-risk
    (26+ 18-25 12-17))

(define-struct in-minors
    (use abuse))

(define-struct use-past-month
    (26+ 18-25 12-17))

(define-struct abuse-past-month
    (26+ 18-25 12-17))

(define-struct cocaine-used-past-year
    (26+ 18-25 12-17))

(define-struct use-past-month
    (26+ 18-25 12-17))

(define-struct pain-relievers-abuse-past-year
    (26+ 18-25 12-17))

(define-struct need-treatment-past-year
    (26+ 18-25 12-17))

(define-struct perceptions-of-risk
    (26+ 18-25 12-17))

(define-struct in-minors
    (use abuse))

(define-struct perceptions-of-risk
    (26+ 18-25 12-17))

(define-struct used-past-month
    (26+ 18-25 12-17))

(define-struct dependence-past-year
    (26+ 18-25 12-17))

(define-struct use-past-month
    (26+ 18-25 12-17))

(define-struct cigarette-past-month
    (26+ 18-25 12-17))

(define-struct new-users
    (26+ 18-25 12-17))

(define-struct need-treatment-past-year
    (26+ 18-25 12-17))

(define-struct rates
    (pain-relievers-abuse-past-year illicit-drugs marijuana tobacco alcohol))



; Define the JSON->Struct mappers
(define (json->dependence-past-year jdata)
    (make-dependence-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->new-users jdata)
    (make-new-users
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->use-past-month jdata)
    (make-use-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->all-except-marijuana-used-past-month jdata)
    (make-all-except-marijuana-used-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->used-past-month jdata)
    (make-used-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->need-treatment-past-year jdata)
    (make-need-treatment-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->abuse-past-year jdata)
    (make-abuse-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->alcohol jdata)
    (make-alcohol
        (json->abuse-past-year (hash-ref jdata (string->symbol "Abuse Past Year")))
                (json->binge-past-month (hash-ref jdata (string->symbol "Binge Past Month")))
                (json->perceptions-of-risk (hash-ref jdata (string->symbol "Perceptions of Risk")))
                (json->dependence-past-year (hash-ref jdata (string->symbol "Dependence Past Year")))
                (json->in-minors (hash-ref jdata (string->symbol "In Minors")))
                (json->use-past-month (hash-ref jdata (string->symbol "Use Past Month")))
                (json->need-treatment-past-year (hash-ref jdata (string->symbol "Need Treatment Past Year")))
                ))

(define (json->abuse-past-year jdata)
    (make-abuse-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->binge-past-month jdata)
    (make-binge-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->pain-relievers-abuse-past-year jdata)
    (make-pain-relievers-abuse-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->dependence-past-year jdata)
    (make-dependence-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->need-treatment-past-year jdata)
    (make-need-treatment-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->abuse-past-month jdata)
    (make-abuse-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->used-past-month jdata)
    (make-used-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->tobacco jdata)
    (make-tobacco
        (json->cigarette-past-month (hash-ref jdata (string->symbol "Cigarette Past Month")))
                (json->use-past-month (hash-ref jdata (string->symbol "Use Past Month")))
                (json->perceptions-of-risk (hash-ref jdata (string->symbol "Perceptions of Risk")))
                ))

(define (json->population jdata)
    (make-population
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            (hash-ref jdata (string->symbol "12-20"))
            ))

(define (json->cigarette-past-month jdata)
    (make-cigarette-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->alcohol jdata)
    (make-alcohol
        (json->abuse-past-year (hash-ref jdata (string->symbol "Abuse Past Year")))
                (json->binge-past-month (hash-ref jdata (string->symbol "Binge Past Month")))
                (json->perceptions-of-risk (hash-ref jdata (string->symbol "Perceptions of Risk")))
                (json->dependence-past-year (hash-ref jdata (string->symbol "Dependence Past Year")))
                (json->in-minors (hash-ref jdata (string->symbol "In Minors")))
                (json->use-past-month (hash-ref jdata (string->symbol "Use Past Month")))
                (json->need-treatment-past-year (hash-ref jdata (string->symbol "Need Treatment Past Year")))
                ))

(define (json->perceptions-of-risk jdata)
    (make-perceptions-of-risk
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->cocaine-used-past-year jdata)
    (make-cocaine-used-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->used-past-year jdata)
    (make-used-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->illicit-drugs jdata)
    (make-illicit-drugs
        (json->abuse-past-month (hash-ref jdata (string->symbol "Abuse Past Month")))
                (json->dependence-past-year (hash-ref jdata (string->symbol "Dependence Past Year")))
                (json->all-except-marijuana-used-past-month (hash-ref jdata (string->symbol "All Except Marijuana Used Past Month")))
                (json->cocaine-used-past-year (hash-ref jdata (string->symbol "Cocaine Used Past Year")))
                (json->used-past-month (hash-ref jdata (string->symbol "Used Past Month")))
                (json->need-treatment-past-year (hash-ref jdata (string->symbol "Need Treatment Past Year")))
                ))

(define (json->marijuana jdata)
    (make-marijuana
        (json->new-users (hash-ref jdata (string->symbol "New Users")))
                (json->used-past-month (hash-ref jdata (string->symbol "Used Past Month")))
                (json->used-past-year (hash-ref jdata (string->symbol "Used Past Year")))
                (json->perceptions-of-risk (hash-ref jdata (string->symbol "Perceptions of Risk")))
                ))

(define (json->dependence-past-year jdata)
    (make-dependence-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->marijuana jdata)
    (make-marijuana
        (json->new-users (hash-ref jdata (string->symbol "New Users")))
                (json->used-past-month (hash-ref jdata (string->symbol "Used Past Month")))
                (json->used-past-year (hash-ref jdata (string->symbol "Used Past Year")))
                (json->perceptions-of-risk (hash-ref jdata (string->symbol "Perceptions of Risk")))
                ))

(define (json->totals jdata)
    (make-totals
        (json->pain-relievers-abuse-past-year (hash-ref jdata (string->symbol "Pain Relievers Abuse Past Year")))
                (json->illicit-drugs (hash-ref jdata (string->symbol "Illicit Drugs")))
                (json->marijuana (hash-ref jdata (string->symbol "Marijuana")))
                (json->tobacco (hash-ref jdata (string->symbol "Tobacco")))
                (json->alcohol (hash-ref jdata (string->symbol "Alcohol")))
                ))

(define (json->binge-past-month jdata)
    (make-binge-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->all-except-marijuana-used-past-month jdata)
    (make-all-except-marijuana-used-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->tobacco jdata)
    (make-tobacco
        (json->cigarette-past-month (hash-ref jdata (string->symbol "Cigarette Past Month")))
                (json->use-past-month (hash-ref jdata (string->symbol "Use Past Month")))
                (json->perceptions-of-risk (hash-ref jdata (string->symbol "Perceptions of Risk")))
                ))

(define (json->perceptions-of-risk jdata)
    (make-perceptions-of-risk
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->used-past-year jdata)
    (make-used-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->illicit-drugs jdata)
    (make-illicit-drugs
        (json->abuse-past-month (hash-ref jdata (string->symbol "Abuse Past Month")))
                (json->dependence-past-year (hash-ref jdata (string->symbol "Dependence Past Year")))
                (json->all-except-marijuana-used-past-month (hash-ref jdata (string->symbol "All Except Marijuana Used Past Month")))
                (json->cocaine-used-past-year (hash-ref jdata (string->symbol "Cocaine Used Past Year")))
                (json->used-past-month (hash-ref jdata (string->symbol "Used Past Month")))
                (json->need-treatment-past-year (hash-ref jdata (string->symbol "Need Treatment Past Year")))
                ))

(define (json->report jdata)
    (make-report
        (hash-ref jdata (string->symbol "State"))
            (hash-ref jdata (string->symbol "Year"))
            (json->rates (hash-ref jdata (string->symbol "Rates")))
                (json->population (hash-ref jdata (string->symbol "Population")))
                (json->totals (hash-ref jdata (string->symbol "Totals")))
                ))

(define (json->perceptions-of-risk jdata)
    (make-perceptions-of-risk
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->used-past-month jdata)
    (make-used-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->perceptions-of-risk jdata)
    (make-perceptions-of-risk
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->in-minors jdata)
    (make-in-minors
        (hash-ref jdata (string->symbol "Use"))
            (hash-ref jdata (string->symbol "Abuse"))
            ))

(define (json->use-past-month jdata)
    (make-use-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->abuse-past-month jdata)
    (make-abuse-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->cocaine-used-past-year jdata)
    (make-cocaine-used-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->use-past-month jdata)
    (make-use-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->pain-relievers-abuse-past-year jdata)
    (make-pain-relievers-abuse-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->need-treatment-past-year jdata)
    (make-need-treatment-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->perceptions-of-risk jdata)
    (make-perceptions-of-risk
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->in-minors jdata)
    (make-in-minors
        (hash-ref jdata (string->symbol "Use"))
            (hash-ref jdata (string->symbol "Abuse"))
            ))

(define (json->perceptions-of-risk jdata)
    (make-perceptions-of-risk
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->used-past-month jdata)
    (make-used-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->dependence-past-year jdata)
    (make-dependence-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->use-past-month jdata)
    (make-use-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->cigarette-past-month jdata)
    (make-cigarette-past-month
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->new-users jdata)
    (make-new-users
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->need-treatment-past-year jdata)
    (make-need-treatment-past-year
        (hash-ref jdata (string->symbol "26+"))
            (hash-ref jdata (string->symbol "18-25"))
            (hash-ref jdata (string->symbol "12-17"))
            ))

(define (json->rates jdata)
    (make-rates
        (json->pain-relievers-abuse-past-year (hash-ref jdata (string->symbol "Pain Relievers Abuse Past Year")))
                (json->illicit-drugs (hash-ref jdata (string->symbol "Illicit Drugs")))
                (json->marijuana (hash-ref jdata (string->symbol "Marijuana")))
                (json->tobacco (hash-ref jdata (string->symbol "Tobacco")))
                (json->alcohol (hash-ref jdata (string->symbol "Alcohol")))
                ))



; Define the services, and their helpers

(define (get-reports ) 
(let* [(result (query-list database 
                                   "SELECT data FROM drugs"
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