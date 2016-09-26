#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "labor.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out all)
    (struct-out all)
    (struct-out employment-population-ratio)
    (struct-out white)
    (struct-out white)
    (struct-out men)
    (struct-out all)
    (struct-out civilian-noninstitutional-population)
    (struct-out civilian-labor-force-participation-rate)
    (struct-out women)
    (struct-out men)
    (struct-out asian)
    (struct-out all)
    (struct-out women)
    (struct-out women)
    (struct-out women)
    (struct-out black-or-african-american)
    (struct-out all)
    (struct-out unemployment-rate)
    (struct-out black-or-african-american)
    (struct-out white)
    (struct-out men)
    (struct-out result)
    (struct-out not-in-labor-force)
    (struct-out women)
    (struct-out men)
    (struct-out all)
    (struct-out employed)
    (struct-out men)
    (struct-out asian)
    (struct-out asian)
    (struct-out asian)
    (struct-out asian)
    (struct-out men)
    (struct-out all)
    (struct-out all)
    (struct-out men)
    (struct-out black-or-african-american)
    (struct-out women)
    (struct-out all)
    (struct-out white)
    (struct-out all)
    (struct-out women)
    (struct-out all)
    (struct-out women)
    (struct-out asian)
    (struct-out women)
    (struct-out data)
    (struct-out civilian-labor-force)
    (struct-out women)
    (struct-out unemployed)
    (struct-out men)
    (struct-out all)
    (struct-out all)
    (struct-out black-or-african-american)
    (struct-out asian)
    (struct-out black-or-african-american)
    (struct-out black-or-african-american)
    (struct-out women)
    (struct-out all)
    (struct-out men)
    (struct-out men)
    (struct-out white)
    (struct-out white)
    (struct-out black-or-african-american)
    (struct-out white)
    (struct-out all)
    (struct-out black-or-african-american)
    (struct-out asian)
    (struct-out men)
    (struct-out white)
    (struct-out men)
    (struct-out women)
    get-results
    main)

; Define the structs
(define-struct all
    (units value))

(define-struct all
    (units value))

(define-struct employment-population-ratio
    (white black-or-african-american asian))

(define-struct white
    (all men women))

(define-struct white
    (all men women))

(define-struct men
    (units value))

(define-struct all
    (units value))

(define-struct civilian-noninstitutional-population
    (white black-or-african-american asian))

(define-struct civilian-labor-force-participation-rate
    (white black-or-african-american asian))

(define-struct women
    (units value))

(define-struct men
    (units value))

(define-struct asian
    (all))

(define-struct all
    (units value))

(define-struct women
    (units value))

(define-struct women
    (units value))

(define-struct women
    (units value))

(define-struct black-or-african-american
    (all men women))

(define-struct all
    (units value))

(define-struct unemployment-rate
    (white black-or-african-american asian))

(define-struct black-or-african-american
    (all men women))

(define-struct white
    (all))

(define-struct men
    (units value))

(define-struct result
    (year data month))

(define-struct not-in-labor-force
    (white black-or-african-american asian))

(define-struct women
    (units value))

(define-struct men
    (units value))

(define-struct all
    (units value))

(define-struct employed
    (white black-or-african-american asian))

(define-struct men
    (units value))

(define-struct asian
    (all))

(define-struct asian
    (all))

(define-struct asian
    (all))

(define-struct asian
    (all))

(define-struct men
    (units value))

(define-struct all
    (units value))

(define-struct all
    (units value))

(define-struct men
    (units value))

(define-struct black-or-african-american
    (all men women))

(define-struct women
    (units value))

(define-struct all
    (units value))

(define-struct white
    (all men women))

(define-struct all
    (units value))

(define-struct women
    (units value))

(define-struct all
    (units value))

(define-struct women
    (units value))

(define-struct asian
    (all))

(define-struct women
    (units value))

(define-struct data
    (civilian-labor-force not-in-labor-force unemployed civilian-labor-force-participation-rate unemployment-rate civilian-noninstitutional-population employed employment-population-ratio))

(define-struct civilian-labor-force
    (white black-or-african-american asian))

(define-struct women
    (units value))

(define-struct unemployed
    (white black-or-african-american asian))

(define-struct men
    (units value))

(define-struct all
    (units value))

(define-struct all
    (units value))

(define-struct black-or-african-american
    (all men women))

(define-struct asian
    (all))

(define-struct black-or-african-american
    (all))

(define-struct black-or-african-american
    (all men women))

(define-struct women
    (units value))

(define-struct all
    (units value))

(define-struct men
    (units value))

(define-struct men
    (units value))

(define-struct white
    (all men women))

(define-struct white
    (all men women))

(define-struct black-or-african-american
    (all men women))

(define-struct white
    (all men women))

(define-struct all
    (units value))

(define-struct black-or-african-american
    (all))

(define-struct asian
    (all))

(define-struct men
    (units value))

(define-struct white
    (all))

(define-struct men
    (units value))

(define-struct women
    (units value))



; Define the JSON->Struct mappers
(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->employment-population-ratio jdata)
    (make-employment-population-ratio
        (json->white (hash-ref jdata (string->symbol "White")))
                (json->black-or-african-american (hash-ref jdata (string->symbol "Black or African American")))
                (json->asian (hash-ref jdata (string->symbol "Asian")))
                ))

(define (json->white jdata)
    (make-white
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->white jdata)
    (make-white
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->civilian-noninstitutional-population jdata)
    (make-civilian-noninstitutional-population
        (json->white (hash-ref jdata (string->symbol "White")))
                (json->black-or-african-american (hash-ref jdata (string->symbol "Black or African American")))
                (json->asian (hash-ref jdata (string->symbol "Asian")))
                ))

(define (json->civilian-labor-force-participation-rate jdata)
    (make-civilian-labor-force-participation-rate
        (json->white (hash-ref jdata (string->symbol "White")))
                (json->black-or-african-american (hash-ref jdata (string->symbol "Black or African American")))
                (json->asian (hash-ref jdata (string->symbol "Asian")))
                ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->asian jdata)
    (make-asian
        (hash-ref jdata (string->symbol "All"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->black-or-african-american jdata)
    (make-black-or-african-american
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->unemployment-rate jdata)
    (make-unemployment-rate
        (json->white (hash-ref jdata (string->symbol "White")))
                (json->black-or-african-american (hash-ref jdata (string->symbol "Black or African American")))
                (json->asian (hash-ref jdata (string->symbol "Asian")))
                ))

(define (json->black-or-african-american jdata)
    (make-black-or-african-american
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->white jdata)
    (make-white
        (json->all (hash-ref jdata (string->symbol "All")))
                ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->result jdata)
    (make-result
        (hash-ref jdata (string->symbol "year"))
            (json->data (hash-ref jdata (string->symbol "data")))
                (hash-ref jdata (string->symbol "month"))
            ))

(define (json->not-in-labor-force jdata)
    (make-not-in-labor-force
        (json->white (hash-ref jdata (string->symbol "White")))
                (json->black-or-african-american (hash-ref jdata (string->symbol "Black or African American")))
                (json->asian (hash-ref jdata (string->symbol "Asian")))
                ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->employed jdata)
    (make-employed
        (json->white (hash-ref jdata (string->symbol "White")))
                (json->black-or-african-american (hash-ref jdata (string->symbol "Black or African American")))
                (json->asian (hash-ref jdata (string->symbol "Asian")))
                ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->asian jdata)
    (make-asian
        (hash-ref jdata (string->symbol "All"))
            ))

(define (json->asian jdata)
    (make-asian
        (hash-ref jdata (string->symbol "All"))
            ))

(define (json->asian jdata)
    (make-asian
        (hash-ref jdata (string->symbol "All"))
            ))

(define (json->asian jdata)
    (make-asian
        (hash-ref jdata (string->symbol "All"))
            ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->black-or-african-american jdata)
    (make-black-or-african-american
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->white jdata)
    (make-white
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->asian jdata)
    (make-asian
        (hash-ref jdata (string->symbol "All"))
            ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->data jdata)
    (make-data
        (json->civilian-labor-force (hash-ref jdata (string->symbol "Civilian labor force")))
                (json->not-in-labor-force (hash-ref jdata (string->symbol "Not in labor force")))
                (json->unemployed (hash-ref jdata (string->symbol "Unemployed")))
                (json->civilian-labor-force-participation-rate (hash-ref jdata (string->symbol "Civilian labor force participation rate")))
                (json->unemployment-rate (hash-ref jdata (string->symbol "Unemployment rate")))
                (json->civilian-noninstitutional-population (hash-ref jdata (string->symbol "Civilian noninstitutional population")))
                (json->employed (hash-ref jdata (string->symbol "Employed")))
                (json->employment-population-ratio (hash-ref jdata (string->symbol "Employment-population ratio")))
                ))

(define (json->civilian-labor-force jdata)
    (make-civilian-labor-force
        (json->white (hash-ref jdata (string->symbol "White")))
                (json->black-or-african-american (hash-ref jdata (string->symbol "Black or African American")))
                (json->asian (hash-ref jdata (string->symbol "Asian")))
                ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->unemployed jdata)
    (make-unemployed
        (json->white (hash-ref jdata (string->symbol "White")))
                (json->black-or-african-american (hash-ref jdata (string->symbol "Black or African American")))
                (json->asian (hash-ref jdata (string->symbol "Asian")))
                ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->black-or-african-american jdata)
    (make-black-or-african-american
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->asian jdata)
    (make-asian
        (hash-ref jdata (string->symbol "All"))
            ))

(define (json->black-or-african-american jdata)
    (make-black-or-african-american
        (json->all (hash-ref jdata (string->symbol "All")))
                ))

(define (json->black-or-african-american jdata)
    (make-black-or-african-american
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->white jdata)
    (make-white
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->white jdata)
    (make-white
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->black-or-african-american jdata)
    (make-black-or-african-american
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->white jdata)
    (make-white
        (json->all (hash-ref jdata (string->symbol "All")))
                (json->men (hash-ref jdata (string->symbol "Men")))
                (json->women (hash-ref jdata (string->symbol "Women")))
                ))

(define (json->all jdata)
    (make-all
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->black-or-african-american jdata)
    (make-black-or-african-american
        (json->all (hash-ref jdata (string->symbol "All")))
                ))

(define (json->asian jdata)
    (make-asian
        (hash-ref jdata (string->symbol "All"))
            ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->white jdata)
    (make-white
        (hash-ref jdata (string->symbol "All"))
            ))

(define (json->men jdata)
    (make-men
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))

(define (json->women jdata)
    (make-women
        (hash-ref jdata (string->symbol "units"))
            (hash-ref jdata (string->symbol "value"))
            ))



; Define the services, and their helpers

(define (get-results ) 
(let* [(result (query-list database 
                                   "SELECT data FROM labor"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->result result)
           )
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-results")
    (displayln (length (time (get-results ))))
    
    

    )