#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "construction_spending.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out annual)
    (struct-out time)
    (struct-out public)
    (struct-out spending)
    (struct-out private)
    (struct-out public)
    (struct-out current)
    (struct-out combined)
    (struct-out combined)
    (struct-out private)
    get-spending
    main)

; Define the structs
(define-struct annual
    (combined private public))

(define-struct time
    (month-name month index period year))

(define-struct public
    (lodging educational total-construction transportation power office nonresidential amusement-and-recreation residential public-safety conservation-and-development commercial water-supply health-care sewage-and-waste-disposal communication manufacturing religious highway-and-street))

(define-struct spending
    (current annual time))

(define-struct private
    (lodging educational total-construction transportation power office nonresidential amusement-and-recreation residential public-safety conservation-and-development commercial water-supply health-care sewage-and-waste-disposal communication manufacturing religious highway-and-street))

(define-struct public
    (lodging educational total-construction transportation power office nonresidential amusement-and-recreation residential public-safety conservation-and-development commercial water-supply health-care sewage-and-waste-disposal communication manufacturing religious highway-and-street))

(define-struct current
    (combined private public))

(define-struct combined
    (lodging educational total-construction transportation power office nonresidential amusement-and-recreation residential public-safety conservation-and-development commercial water-supply health-care sewage-and-waste-disposal communication manufacturing religious highway-and-street))

(define-struct combined
    (lodging educational total-construction transportation power office nonresidential amusement-and-recreation residential public-safety conservation-and-development commercial water-supply health-care sewage-and-waste-disposal communication manufacturing religious highway-and-street))

(define-struct private
    (lodging educational total-construction transportation power office nonresidential amusement-and-recreation residential public-safety conservation-and-development commercial water-supply health-care sewage-and-waste-disposal communication manufacturing religious highway-and-street))



; Define the JSON->Struct mappers
(define (json->annual jdata)
    (make-annual
        (json->combined (hash-ref jdata (string->symbol "combined")))
                (json->private (hash-ref jdata (string->symbol "private")))
                (json->public (hash-ref jdata (string->symbol "public")))
                ))

(define (json->time jdata)
    (make-time
        (hash-ref jdata (string->symbol "month name"))
            (hash-ref jdata (string->symbol "month"))
            (hash-ref jdata (string->symbol "index"))
            (hash-ref jdata (string->symbol "period"))
            (hash-ref jdata (string->symbol "year"))
            ))

(define (json->public jdata)
    (make-public
        (hash-ref jdata (string->symbol "lodging"))
            (hash-ref jdata (string->symbol "educational"))
            (hash-ref jdata (string->symbol "total construction"))
            (hash-ref jdata (string->symbol "transportation"))
            (hash-ref jdata (string->symbol "power"))
            (hash-ref jdata (string->symbol "office"))
            (hash-ref jdata (string->symbol "nonresidential"))
            (hash-ref jdata (string->symbol "amusement and recreation"))
            (hash-ref jdata (string->symbol "residential"))
            (hash-ref jdata (string->symbol "public safety"))
            (hash-ref jdata (string->symbol "conservation and development"))
            (hash-ref jdata (string->symbol "commercial"))
            (hash-ref jdata (string->symbol "water supply"))
            (hash-ref jdata (string->symbol "health care"))
            (hash-ref jdata (string->symbol "sewage and waste disposal"))
            (hash-ref jdata (string->symbol "communication"))
            (hash-ref jdata (string->symbol "manufacturing"))
            (hash-ref jdata (string->symbol "religious"))
            (hash-ref jdata (string->symbol "highway and street"))
            ))

(define (json->spending jdata)
    (make-spending
        (json->current (hash-ref jdata (string->symbol "current")))
                (json->annual (hash-ref jdata (string->symbol "annual")))
                (json->time (hash-ref jdata (string->symbol "time")))
                ))

(define (json->private jdata)
    (make-private
        (hash-ref jdata (string->symbol "lodging"))
            (hash-ref jdata (string->symbol "educational"))
            (hash-ref jdata (string->symbol "total construction"))
            (hash-ref jdata (string->symbol "transportation"))
            (hash-ref jdata (string->symbol "power"))
            (hash-ref jdata (string->symbol "office"))
            (hash-ref jdata (string->symbol "nonresidential"))
            (hash-ref jdata (string->symbol "amusement and recreation"))
            (hash-ref jdata (string->symbol "residential"))
            (hash-ref jdata (string->symbol "public safety"))
            (hash-ref jdata (string->symbol "conservation and development"))
            (hash-ref jdata (string->symbol "commercial"))
            (hash-ref jdata (string->symbol "water supply"))
            (hash-ref jdata (string->symbol "health care"))
            (hash-ref jdata (string->symbol "sewage and waste disposal"))
            (hash-ref jdata (string->symbol "communication"))
            (hash-ref jdata (string->symbol "manufacturing"))
            (hash-ref jdata (string->symbol "religious"))
            (hash-ref jdata (string->symbol "highway and street"))
            ))

(define (json->public jdata)
    (make-public
        (hash-ref jdata (string->symbol "lodging"))
            (hash-ref jdata (string->symbol "educational"))
            (hash-ref jdata (string->symbol "total construction"))
            (hash-ref jdata (string->symbol "transportation"))
            (hash-ref jdata (string->symbol "power"))
            (hash-ref jdata (string->symbol "office"))
            (hash-ref jdata (string->symbol "nonresidential"))
            (hash-ref jdata (string->symbol "amusement and recreation"))
            (hash-ref jdata (string->symbol "residential"))
            (hash-ref jdata (string->symbol "public safety"))
            (hash-ref jdata (string->symbol "conservation and development"))
            (hash-ref jdata (string->symbol "commercial"))
            (hash-ref jdata (string->symbol "water supply"))
            (hash-ref jdata (string->symbol "health care"))
            (hash-ref jdata (string->symbol "sewage and waste disposal"))
            (hash-ref jdata (string->symbol "communication"))
            (hash-ref jdata (string->symbol "manufacturing"))
            (hash-ref jdata (string->symbol "religious"))
            (hash-ref jdata (string->symbol "highway and street"))
            ))

(define (json->current jdata)
    (make-current
        (json->combined (hash-ref jdata (string->symbol "combined")))
                (json->private (hash-ref jdata (string->symbol "private")))
                (json->public (hash-ref jdata (string->symbol "public")))
                ))

(define (json->combined jdata)
    (make-combined
        (hash-ref jdata (string->symbol "lodging"))
            (hash-ref jdata (string->symbol "educational"))
            (hash-ref jdata (string->symbol "total construction"))
            (hash-ref jdata (string->symbol "transportation"))
            (hash-ref jdata (string->symbol "power"))
            (hash-ref jdata (string->symbol "office"))
            (hash-ref jdata (string->symbol "nonresidential"))
            (hash-ref jdata (string->symbol "amusement and recreation"))
            (hash-ref jdata (string->symbol "residential"))
            (hash-ref jdata (string->symbol "public safety"))
            (hash-ref jdata (string->symbol "conservation and development"))
            (hash-ref jdata (string->symbol "commercial"))
            (hash-ref jdata (string->symbol "water supply"))
            (hash-ref jdata (string->symbol "health care"))
            (hash-ref jdata (string->symbol "sewage and waste disposal"))
            (hash-ref jdata (string->symbol "communication"))
            (hash-ref jdata (string->symbol "manufacturing"))
            (hash-ref jdata (string->symbol "religious"))
            (hash-ref jdata (string->symbol "highway and street"))
            ))

(define (json->combined jdata)
    (make-combined
        (hash-ref jdata (string->symbol "lodging"))
            (hash-ref jdata (string->symbol "educational"))
            (hash-ref jdata (string->symbol "total construction"))
            (hash-ref jdata (string->symbol "transportation"))
            (hash-ref jdata (string->symbol "power"))
            (hash-ref jdata (string->symbol "office"))
            (hash-ref jdata (string->symbol "nonresidential"))
            (hash-ref jdata (string->symbol "amusement and recreation"))
            (hash-ref jdata (string->symbol "residential"))
            (hash-ref jdata (string->symbol "public safety"))
            (hash-ref jdata (string->symbol "conservation and development"))
            (hash-ref jdata (string->symbol "commercial"))
            (hash-ref jdata (string->symbol "water supply"))
            (hash-ref jdata (string->symbol "health care"))
            (hash-ref jdata (string->symbol "sewage and waste disposal"))
            (hash-ref jdata (string->symbol "communication"))
            (hash-ref jdata (string->symbol "manufacturing"))
            (hash-ref jdata (string->symbol "religious"))
            (hash-ref jdata (string->symbol "highway and street"))
            ))

(define (json->private jdata)
    (make-private
        (hash-ref jdata (string->symbol "lodging"))
            (hash-ref jdata (string->symbol "educational"))
            (hash-ref jdata (string->symbol "total construction"))
            (hash-ref jdata (string->symbol "transportation"))
            (hash-ref jdata (string->symbol "power"))
            (hash-ref jdata (string->symbol "office"))
            (hash-ref jdata (string->symbol "nonresidential"))
            (hash-ref jdata (string->symbol "amusement and recreation"))
            (hash-ref jdata (string->symbol "residential"))
            (hash-ref jdata (string->symbol "public safety"))
            (hash-ref jdata (string->symbol "conservation and development"))
            (hash-ref jdata (string->symbol "commercial"))
            (hash-ref jdata (string->symbol "water supply"))
            (hash-ref jdata (string->symbol "health care"))
            (hash-ref jdata (string->symbol "sewage and waste disposal"))
            (hash-ref jdata (string->symbol "communication"))
            (hash-ref jdata (string->symbol "manufacturing"))
            (hash-ref jdata (string->symbol "religious"))
            (hash-ref jdata (string->symbol "highway and street"))
            ))



; Define the services, and their helpers

(define (get-spending [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM construction_spending LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->spending result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM construction_spending"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->spending result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-spending")
    (displayln (length (time (get-spending false))))
    (displayln "Test get-spending")
    (displayln (length (time (get-spending true))))
    
    

    )