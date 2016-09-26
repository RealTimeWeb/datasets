#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "slavery.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out sale-details)
    (struct-out transaction-record)
    (struct-out seller)
    (struct-out slave)
    (struct-out buyer)
    (struct-out transaction)
    get-transaction
    main)

; Define the structs
(define-struct sale-details
    (prices-listed price payment-method discount-rate predicted-interest-rate))

(define-struct transaction-record
    (buyer transaction slave seller))

(define-struct seller
    (origin county-of-origin full-name state-of-origin))

(define-struct slave
    (gender age skin-color name))

(define-struct buyer
    (origin county-of-origin full-name state-of-origin))

(define-struct transaction
    (date number-of-total-slaves-purchased number-of-adult-slaves number-of-child-slaves sale-details))



; Define the JSON->Struct mappers
(define (json->sale-details jdata)
    (make-sale-details
        (hash-ref jdata (string->symbol "Prices Listed"))
            (hash-ref jdata (string->symbol "Price"))
            (hash-ref jdata (string->symbol "Payment Method"))
            (hash-ref jdata (string->symbol "Discount Rate"))
            (hash-ref jdata (string->symbol "Predicted Interest Rate"))
            ))

(define (json->transaction-record jdata)
    (make-transaction-record
        (json->buyer (hash-ref jdata (string->symbol "Buyer")))
                (json->transaction (hash-ref jdata (string->symbol "Transaction")))
                (json->slave (hash-ref jdata (string->symbol "Slave")))
                (json->seller (hash-ref jdata (string->symbol "Seller")))
                ))

(define (json->seller jdata)
    (make-seller
        (hash-ref jdata (string->symbol "Origin"))
            (hash-ref jdata (string->symbol "County of Origin"))
            (hash-ref jdata (string->symbol "Full Name"))
            (hash-ref jdata (string->symbol "State of Origin"))
            ))

(define (json->slave jdata)
    (make-slave
        (hash-ref jdata (string->symbol "Gender"))
            (hash-ref jdata (string->symbol "Age"))
            (hash-ref jdata (string->symbol "Skin Color"))
            (hash-ref jdata (string->symbol "Name"))
            ))

(define (json->buyer jdata)
    (make-buyer
        (hash-ref jdata (string->symbol "Origin"))
            (hash-ref jdata (string->symbol "County of Origin"))
            (hash-ref jdata (string->symbol "Full Name"))
            (hash-ref jdata (string->symbol "State of Origin"))
            ))

(define (json->transaction jdata)
    (make-transaction
        (hash-ref jdata (string->symbol "Date"))
            (hash-ref jdata (string->symbol "Number of Total Slaves Purchased"))
            (hash-ref jdata (string->symbol "Number of Adult Slaves"))
            (hash-ref jdata (string->symbol "Number of Child Slaves"))
            (json->sale-details (hash-ref jdata (string->symbol "Sale Details")))
                ))



; Define the services, and their helpers

(define (get-transaction [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM slavery LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->transaction-record result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM slavery"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->transaction-record result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-transaction")
    (displayln (length (time (get-transaction false))))
    (displayln "Test get-transaction")
    (displayln (length (time (get-transaction true))))
    
    

    )