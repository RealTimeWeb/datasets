#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "suicide_attacks.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out attacker)
    (struct-out birth)
    (struct-out statistics)
    (struct-out target)
    (struct-out demographics)
    (struct-out date)
    (struct-out attack)
    (struct-out campaign)
    get-attacks
    main)

; Define the structs
(define-struct attacker
    (age demographics birth name))

(define-struct birth
    (location year))

(define-struct statistics
    (#-wounded #-killed))

(define-struct target
    (assassination? name country weapon location type))

(define-struct demographics
    (occupation gender education marital religion))

(define-struct date
    (year day month))

(define-struct attack
    (statistics target campaign attacker groups date))

(define-struct campaign
    (name sides))



; Define the JSON->Struct mappers
(define (json->attacker jdata)
    (make-attacker
        (hash-ref jdata (string->symbol "age"))
            (json->demographics (hash-ref jdata (string->symbol "demographics")))
                (json->birth (hash-ref jdata (string->symbol "birth")))
                (hash-ref jdata (string->symbol "name"))
            ))

(define (json->birth jdata)
    (make-birth
        (hash-ref jdata (string->symbol "location"))
            (hash-ref jdata (string->symbol "year"))
            ))

(define (json->statistics jdata)
    (make-statistics
        (hash-ref jdata (string->symbol "# wounded"))
            (hash-ref jdata (string->symbol "# killed"))
            ))

(define (json->target jdata)
    (make-target
        (hash-ref jdata (string->symbol "assassination?"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "country"))
            (hash-ref jdata (string->symbol "weapon"))
            (hash-ref jdata (string->symbol "location"))
            (hash-ref jdata (string->symbol "type"))
            ))

(define (json->demographics jdata)
    (make-demographics
        (hash-ref jdata (string->symbol "occupation"))
            (hash-ref jdata (string->symbol "gender"))
            (hash-ref jdata (string->symbol "education"))
            (hash-ref jdata (string->symbol "marital"))
            (hash-ref jdata (string->symbol "religion"))
            ))

(define (json->date jdata)
    (make-date
        (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "day"))
            (hash-ref jdata (string->symbol "month"))
            ))

(define (json->attack jdata)
    (make-attack
        (json->statistics (hash-ref jdata (string->symbol "statistics")))
                (json->target (hash-ref jdata (string->symbol "target")))
                (json->campaign (hash-ref jdata (string->symbol "campaign")))
                (json->attacker (hash-ref jdata (string->symbol "attacker")))
                (hash-ref jdata (string->symbol "groups"))
                    (json->date (hash-ref jdata (string->symbol "date")))
                ))

(define (json->campaign jdata)
    (make-campaign
        (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "sides"))
                    ))



; Define the services, and their helpers

(define (get-attacks [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM suicide_attacks LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->attack result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM suicide_attacks"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->attack result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-attacks")
    (displayln (length (time (get-attacks false))))
    (displayln "Test get-attacks")
    (displayln (length (time (get-attacks true))))
    
    

    )