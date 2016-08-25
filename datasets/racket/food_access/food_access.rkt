#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "food_access.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out low-access-only)
    (struct-out housing-data)
    (struct-out seniors)
    (struct-out children)
    (struct-out low-income-people)
    (struct-out low-access-numbers)
    (struct-out low-income-and-low-access)
    (struct-out people)
    (struct-out vehicle-access)
    (struct-out record)
    (struct-out low-access-percents)
    get-records
    main)

; Define the structs
(define-struct low-access-only
    (1/2-and-10-miles 1-and-20-miles))

(define-struct housing-data
    (total-housing-units urban-housing-percentage residing-in-group-quarters rural-housing-percentage))

(define-struct seniors
    (20-miles 1/2-mile 1-mile 10-miles))

(define-struct children
    (20-miles 1/2-mile 1-mile 10-miles))

(define-struct low-income-people
    (20-miles 1/2-mile 1-mile 10-miles))

(define-struct low-access-numbers
    (seniors low-income-people children people))

(define-struct low-income-and-low-access
    (1/2-and-10-miles 1-and-20-miles))

(define-struct people
    (20-miles 1/2-mile 1-mile 10-miles))

(define-struct vehicle-access
    (20-miles 1/2-mile 1-mile 10-miles))

(define-struct record
    (low-access-numbers vehicle-access housing-data county low-access-percents state population))

(define-struct low-access-percents
    (low-income-and-low-access low-access-only))



; Define the JSON->Struct mappers
(define (json->low-access-only jdata)
    (make-low-access-only
        (hash-ref jdata (string->symbol "1/2 and 10 Miles"))
            (hash-ref jdata (string->symbol "1 and 20 Miles"))
            ))

(define (json->housing-data jdata)
    (make-housing-data
        (hash-ref jdata (string->symbol "Total Housing Units"))
            (hash-ref jdata (string->symbol "Urban Housing Percentage"))
            (hash-ref jdata (string->symbol "Residing in Group Quarters"))
            (hash-ref jdata (string->symbol "Rural Housing Percentage"))
            ))

(define (json->seniors jdata)
    (make-seniors
        (hash-ref jdata (string->symbol "20 Miles"))
            (hash-ref jdata (string->symbol "1/2 Mile"))
            (hash-ref jdata (string->symbol "1 Mile"))
            (hash-ref jdata (string->symbol "10 Miles"))
            ))

(define (json->children jdata)
    (make-children
        (hash-ref jdata (string->symbol "20 Miles"))
            (hash-ref jdata (string->symbol "1/2 Mile"))
            (hash-ref jdata (string->symbol "1 Mile"))
            (hash-ref jdata (string->symbol "10 Miles"))
            ))

(define (json->low-income-people jdata)
    (make-low-income-people
        (hash-ref jdata (string->symbol "20 Miles"))
            (hash-ref jdata (string->symbol "1/2 Mile"))
            (hash-ref jdata (string->symbol "1 Mile"))
            (hash-ref jdata (string->symbol "10 Miles"))
            ))

(define (json->low-access-numbers jdata)
    (make-low-access-numbers
        (json->seniors (hash-ref jdata (string->symbol "Seniors")))
                (json->low-income-people (hash-ref jdata (string->symbol "Low Income People")))
                (json->children (hash-ref jdata (string->symbol "Children")))
                (json->people (hash-ref jdata (string->symbol "People")))
                ))

(define (json->low-income-and-low-access jdata)
    (make-low-income-and-low-access
        (hash-ref jdata (string->symbol "1/2 and 10 Miles"))
            (hash-ref jdata (string->symbol "1 and 20 Miles"))
            ))

(define (json->people jdata)
    (make-people
        (hash-ref jdata (string->symbol "20 Miles"))
            (hash-ref jdata (string->symbol "1/2 Mile"))
            (hash-ref jdata (string->symbol "1 Mile"))
            (hash-ref jdata (string->symbol "10 Miles"))
            ))

(define (json->vehicle-access jdata)
    (make-vehicle-access
        (hash-ref jdata (string->symbol "20 Miles"))
            (hash-ref jdata (string->symbol "1/2 Mile"))
            (hash-ref jdata (string->symbol "1 Mile"))
            (hash-ref jdata (string->symbol "10 Miles"))
            ))

(define (json->record jdata)
    (make-record
        (json->low-access-numbers (hash-ref jdata (string->symbol "Low Access Numbers")))
                (json->vehicle-access (hash-ref jdata (string->symbol "Vehicle Access")))
                (json->housing-data (hash-ref jdata (string->symbol "Housing Data")))
                (hash-ref jdata (string->symbol "County"))
            (json->low-access-percents (hash-ref jdata (string->symbol "Low Access Percents")))
                (hash-ref jdata (string->symbol "State"))
            (hash-ref jdata (string->symbol "Population"))
            ))

(define (json->low-access-percents jdata)
    (make-low-access-percents
        (json->low-income-and-low-access (hash-ref jdata (string->symbol "Low Income and Low Access")))
                (json->low-access-only (hash-ref jdata (string->symbol "Low Access Only")))
                ))



; Define the services, and their helpers

(define (get-records [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM food_access LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->record result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM food_access"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->record result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-records")
    (displayln (length (time (get-records false))))
    (displayln "Test get-records")
    (displayln (length (time (get-records true))))
    
    

    )