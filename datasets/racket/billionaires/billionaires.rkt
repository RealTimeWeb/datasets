#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "billionaires.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out how)
    (struct-out demographics)
    (struct-out billionaire)
    (struct-out company)
    (struct-out wealth)
    (struct-out location)
    get-billionaires
    main)

; Define the structs
(define-struct how
    (category from-emerging industry was-political inherited was-founder))

(define-struct demographics
    (gender age))

(define-struct billionaire
    (wealth company rank location year demographics name))

(define-struct company
    (sector founded type name relationship))

(define-struct wealth
    (worth-in-billions how type))

(define-struct location
    (gdp region citizenship country-code))



; Define the JSON->Struct mappers
(define (json->how jdata)
    (make-how
        (hash-ref jdata (string->symbol "category"))
            (hash-ref jdata (string->symbol "from emerging"))
            (hash-ref jdata (string->symbol "industry"))
            (hash-ref jdata (string->symbol "was political"))
            (hash-ref jdata (string->symbol "inherited"))
            (hash-ref jdata (string->symbol "was founder"))
            ))

(define (json->demographics jdata)
    (make-demographics
        (hash-ref jdata (string->symbol "gender"))
            (hash-ref jdata (string->symbol "age"))
            ))

(define (json->billionaire jdata)
    (make-billionaire
        (json->wealth (hash-ref jdata (string->symbol "wealth")))
                (json->company (hash-ref jdata (string->symbol "company")))
                (hash-ref jdata (string->symbol "rank"))
            (json->location (hash-ref jdata (string->symbol "location")))
                (hash-ref jdata (string->symbol "year"))
            (json->demographics (hash-ref jdata (string->symbol "demographics")))
                (hash-ref jdata (string->symbol "name"))
            ))

(define (json->company jdata)
    (make-company
        (hash-ref jdata (string->symbol "sector"))
            (hash-ref jdata (string->symbol "founded"))
            (hash-ref jdata (string->symbol "type"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "relationship"))
            ))

(define (json->wealth jdata)
    (make-wealth
        (hash-ref jdata (string->symbol "worth in billions"))
            (json->how (hash-ref jdata (string->symbol "how")))
                (hash-ref jdata (string->symbol "type"))
            ))

(define (json->location jdata)
    (make-location
        (hash-ref jdata (string->symbol "gdp"))
            (hash-ref jdata (string->symbol "region"))
            (hash-ref jdata (string->symbol "citizenship"))
            (hash-ref jdata (string->symbol "country code"))
            ))



; Define the services, and their helpers

(define (get-billionaires ) 
(let* [(result (query-list database 
                                   "SELECT data FROM billionaires"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->billionaire result)
           )
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-billionaires")
    (displayln (length (time (get-billionaires ))))
    
    

    )