#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "real_estate.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out address)
    (struct-out building)
    (struct-out disabilities)
    (struct-out history)
    (struct-out data)
    (struct-out location)
    get-buildings
    get-buildings-by-state
    main)

; Define the structs
(define-struct address
    (city zip county state line-1 line-2))

(define-struct building
    (data location))

(define-struct disabilities
    (ansi-usable aba-accessible))

(define-struct history
    (status type))

(define-struct data
    (status disabilities parking-spaces owned-or-leased date type history))

(define-struct location
    (region-id congressional-district id address))



; Define the JSON->Struct mappers
(define (json->address jdata)
    (make-address
        (hash-ref jdata (string->symbol "city"))
            (hash-ref jdata (string->symbol "zip"))
            (hash-ref jdata (string->symbol "county"))
            (hash-ref jdata (string->symbol "state"))
            (hash-ref jdata (string->symbol "line 1"))
            (hash-ref jdata (string->symbol "line 2"))
            ))

(define (json->building jdata)
    (make-building
        (json->data (hash-ref jdata (string->symbol "data")))
                (json->location (hash-ref jdata (string->symbol "location")))
                ))

(define (json->disabilities jdata)
    (make-disabilities
        (hash-ref jdata (string->symbol "ansi usable"))
            (hash-ref jdata (string->symbol "aba accessible"))
            ))

(define (json->history jdata)
    (make-history
        (hash-ref jdata (string->symbol "status"))
            (hash-ref jdata (string->symbol "type"))
            ))

(define (json->data jdata)
    (make-data
        (hash-ref jdata (string->symbol "status"))
            (json->disabilities (hash-ref jdata (string->symbol "disabilities")))
                (hash-ref jdata (string->symbol "parking spaces"))
            (hash-ref jdata (string->symbol "owned or leased"))
            (hash-ref jdata (string->symbol "date"))
            (hash-ref jdata (string->symbol "type"))
            (json->history (hash-ref jdata (string->symbol "history")))
                ))

(define (json->location jdata)
    (make-location
        (hash-ref jdata (string->symbol "region id"))
            (hash-ref jdata (string->symbol "congressional district"))
            (hash-ref jdata (string->symbol "id"))
            (json->address (hash-ref jdata (string->symbol "address")))
                ))



; Define the services, and their helpers

(define (get-buildings [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM real_estate LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->building result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM real_estate"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->building result)
           ))
)

(define (get-buildings-by-state state) 
    (check-arg 'state (string? state) 'str 1 state)
    ; Ensure a match exists
    (let ([potentials (map string-downcase 
                           (query-list database "SELECT DISTINCT state FROM real_estate"))]
          [arg (string-downcase state)])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true)) 
(let* [(result (query-list database 
                                   "SELECT data FROM real_estate WHERE state=?"
                                state
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->building result)
           )
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-buildings")
    (displayln (length (time (get-buildings false))))
    (displayln "Test get-buildings")
    (displayln (length (time (get-buildings true))))
    
    
    (displayln "Production get-buildings-by-state")
    (displayln (length (time (get-buildings-by-state "'VA'"))))
    
    

    )