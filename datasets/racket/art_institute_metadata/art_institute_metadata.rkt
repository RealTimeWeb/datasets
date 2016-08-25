#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "art_institute_metadata.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out record)
    (struct-out artist-info)
    (struct-out institute-info)
    (struct-out description)
    get-records
    main)

; Define the structs
(define-struct record
    (artist-info title institute-info description))

(define-struct artist-info
    (country continent years-living artist nationality))

(define-struct institute-info
    (rights-type inscription credit-line room text provenance department))

(define-struct description
    (style medium classification short-description signed dated dimension))



; Define the JSON->Struct mappers
(define (json->record jdata)
    (make-record
        (json->artist-info (hash-ref jdata (string->symbol "Artist Info")))
                (hash-ref jdata (string->symbol "Title"))
            (json->institute-info (hash-ref jdata (string->symbol "Institute Info")))
                (json->description (hash-ref jdata (string->symbol "Description")))
                ))

(define (json->artist-info jdata)
    (make-artist-info
        (hash-ref jdata (string->symbol "Country"))
            (hash-ref jdata (string->symbol "Continent"))
            (hash-ref jdata (string->symbol "Years Living"))
            (hash-ref jdata (string->symbol "Artist"))
            (hash-ref jdata (string->symbol "Nationality"))
            ))

(define (json->institute-info jdata)
    (make-institute-info
        (hash-ref jdata (string->symbol "Rights Type"))
            (hash-ref jdata (string->symbol "Inscription"))
            (hash-ref jdata (string->symbol "Credit Line"))
            (hash-ref jdata (string->symbol "Room"))
            (hash-ref jdata (string->symbol "Text"))
            (hash-ref jdata (string->symbol "Provenance"))
            (hash-ref jdata (string->symbol "Department"))
            ))

(define (json->description jdata)
    (make-description
        (hash-ref jdata (string->symbol "Style"))
            (hash-ref jdata (string->symbol "Medium"))
            (hash-ref jdata (string->symbol "Classification"))
            (hash-ref jdata (string->symbol "Short Description"))
            (hash-ref jdata (string->symbol "Signed"))
            (hash-ref jdata (string->symbol "Dated"))
            (hash-ref jdata (string->symbol "Dimension"))
            ))



; Define the services, and their helpers

(define (get-records [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM artdata LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->record result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM artdata"
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