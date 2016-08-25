#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "graduates.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out grad-major)
    (struct-out earnings-breakdown)
    (struct-out demographics)
    (struct-out major-information)
    (struct-out earnings)
    (struct-out employment)
    get-majors
    main)

; Define the structs
(define-struct grad-major
    (major-information demographics employment earnings))

(define-struct earnings-breakdown
    (median-earnings 75th-percentile-of-earnings 25th-percentile-of-earnings))

(define-struct demographics
    (men women-as-share-of-total women))

(define-struct major-information
    (major-code rank-by-median-earnings major total-number-in-major major-category))

(define-struct earnings
    (non-college-jobs college-jobs earnings-breakdown low-wage-jobs))

(define-struct employment
    (part-time unemployed unemployment-rate full-time employed full-time,-year-round))



; Define the JSON->Struct mappers
(define (json->grad-major jdata)
    (make-grad-major
        (json->major-information (hash-ref jdata (string->symbol "Major Information")))
                (json->demographics (hash-ref jdata (string->symbol "Demographics")))
                (json->employment (hash-ref jdata (string->symbol "Employment")))
                (json->earnings (hash-ref jdata (string->symbol "Earnings")))
                ))

(define (json->earnings-breakdown jdata)
    (make-earnings-breakdown
        (hash-ref jdata (string->symbol "Median Earnings"))
            (hash-ref jdata (string->symbol "75th Percentile of Earnings"))
            (hash-ref jdata (string->symbol "25th Percentile of Earnings"))
            ))

(define (json->demographics jdata)
    (make-demographics
        (hash-ref jdata (string->symbol "Men"))
            (hash-ref jdata (string->symbol "Women as Share of Total"))
            (hash-ref jdata (string->symbol "Women"))
            ))

(define (json->major-information jdata)
    (make-major-information
        (hash-ref jdata (string->symbol "Major Code"))
            (hash-ref jdata (string->symbol "Rank by Median Earnings"))
            (hash-ref jdata (string->symbol "Major"))
            (hash-ref jdata (string->symbol "Total Number in Major"))
            (hash-ref jdata (string->symbol "Major Category"))
            ))

(define (json->earnings jdata)
    (make-earnings
        (hash-ref jdata (string->symbol "Non-College Jobs"))
            (hash-ref jdata (string->symbol "College Jobs"))
            (json->earnings-breakdown (hash-ref jdata (string->symbol "Earnings Breakdown")))
                (hash-ref jdata (string->symbol "Low Wage Jobs"))
            ))

(define (json->employment jdata)
    (make-employment
        (hash-ref jdata (string->symbol "Part Time"))
            (hash-ref jdata (string->symbol "Unemployed"))
            (hash-ref jdata (string->symbol "Unemployment Rate"))
            (hash-ref jdata (string->symbol "Full Time"))
            (hash-ref jdata (string->symbol "Employed"))
            (hash-ref jdata (string->symbol "Full Time, Year-Round"))
            ))



; Define the services, and their helpers

(define (get-majors ) 
(let* [(result (query-list database 
                                   "SELECT data FROM graduates"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->grad-major result)
           )
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-majors")
    (displayln (length (time (get-majors ))))
    
    

    )