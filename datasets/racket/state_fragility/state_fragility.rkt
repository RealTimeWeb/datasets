#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "state_fragility.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out score)
    (struct-out metrics)
    (struct-out effectiveness)
    (struct-out legitimacy)
    get-scores
    main)

; Define the structs
(define-struct score
    (metrics country year))

(define-struct metrics
    (legitimacy effectiveness state-fragility-index))

(define-struct effectiveness
    (security-effectiveness social-effectiveness political-effectiveness economic-effectiveness effectiveness-score))

(define-struct legitimacy
    (legitimacy-score political-legitimacy security-legitimacy economic-legitimacy social-legitimacy))



; Define the JSON->Struct mappers
(define (json->score jdata)
    (make-score
        (json->metrics (hash-ref jdata (string->symbol "Metrics")))
                (hash-ref jdata (string->symbol "Country"))
            (hash-ref jdata (string->symbol "Year"))
            ))

(define (json->metrics jdata)
    (make-metrics
        (json->legitimacy (hash-ref jdata (string->symbol "Legitimacy")))
                (json->effectiveness (hash-ref jdata (string->symbol "Effectiveness")))
                (hash-ref jdata (string->symbol "State Fragility Index"))
            ))

(define (json->effectiveness jdata)
    (make-effectiveness
        (hash-ref jdata (string->symbol "Security Effectiveness"))
            (hash-ref jdata (string->symbol "Social Effectiveness"))
            (hash-ref jdata (string->symbol "Political Effectiveness"))
            (hash-ref jdata (string->symbol "Economic Effectiveness"))
            (hash-ref jdata (string->symbol "Effectiveness Score"))
            ))

(define (json->legitimacy jdata)
    (make-legitimacy
        (hash-ref jdata (string->symbol "Legitimacy Score"))
            (hash-ref jdata (string->symbol "Political Legitimacy"))
            (hash-ref jdata (string->symbol "Security Legitimacy"))
            (hash-ref jdata (string->symbol "Economic Legitimacy"))
            (hash-ref jdata (string->symbol "Social Legitimacy"))
            ))



; Define the services, and their helpers

(define (get-scores [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM fragility LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->score result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM fragility"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->score result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-scores")
    (displayln (length (time (get-scores false))))
    (displayln "Test get-scores")
    (displayln (length (time (get-scores true))))
    
    

    )