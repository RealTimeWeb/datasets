#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "food.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out report)
    (struct-out fat)
    (struct-out data)
    (struct-out vitamins)
    (struct-out major-minerals)
    (struct-out household-weights)
    get-reports
    main)

; Define the structs
(define-struct report
    (category data description nutrient-data-bank-number))

(define-struct fat
    (saturated-fat monosaturated-fat total-lipid polysaturated-fat))

(define-struct data
    (niacin major-minerals vitamins carboydrate selenium thiamin choline beta-carotene fiber refuse-percentage fat water lycopene pantothenic-acid ash alpha-carotene retinol manganese beta-cryptoxanthin riboflavin cholesterol lutein-and-zeaxanthin kilocalories household-weights sugar-total protein))

(define-struct vitamins
    (vitamin-a---iu vitamin-c vitamin-b12 vitamin-b6 vitamin-a---rae vitamin-e vitamin-k))

(define-struct major-minerals
    (copper iron sodium potassium calcium magnesium zinc phosphorus))

(define-struct household-weights
    (1st-household-weight-description 1st-household-weight 2nd-household-weight 2nd-household-weight-description))



; Define the JSON->Struct mappers
(define (json->report jdata)
    (make-report
        (hash-ref jdata (string->symbol "Category"))
            (json->data (hash-ref jdata (string->symbol "Data")))
                (hash-ref jdata (string->symbol "Description"))
            (hash-ref jdata (string->symbol "Nutrient Data Bank Number"))
            ))

(define (json->fat jdata)
    (make-fat
        (hash-ref jdata (string->symbol "Saturated Fat"))
            (hash-ref jdata (string->symbol "Monosaturated Fat"))
            (hash-ref jdata (string->symbol "Total Lipid"))
            (hash-ref jdata (string->symbol "Polysaturated Fat"))
            ))

(define (json->data jdata)
    (make-data
        (hash-ref jdata (string->symbol "Niacin"))
            (json->major-minerals (hash-ref jdata (string->symbol "Major Minerals")))
                (json->vitamins (hash-ref jdata (string->symbol "Vitamins")))
                (hash-ref jdata (string->symbol "Carboydrate"))
            (hash-ref jdata (string->symbol "Selenium"))
            (hash-ref jdata (string->symbol "Thiamin"))
            (hash-ref jdata (string->symbol "Choline"))
            (hash-ref jdata (string->symbol "Beta Carotene"))
            (hash-ref jdata (string->symbol "Fiber"))
            (hash-ref jdata (string->symbol "Refuse Percentage"))
            (json->fat (hash-ref jdata (string->symbol "Fat")))
                (hash-ref jdata (string->symbol "Water"))
            (hash-ref jdata (string->symbol "Lycopene"))
            (hash-ref jdata (string->symbol "Pantothenic Acid"))
            (hash-ref jdata (string->symbol "Ash"))
            (hash-ref jdata (string->symbol "Alpha Carotene"))
            (hash-ref jdata (string->symbol "Retinol"))
            (hash-ref jdata (string->symbol "Manganese"))
            (hash-ref jdata (string->symbol "Beta Cryptoxanthin"))
            (hash-ref jdata (string->symbol "Riboflavin"))
            (hash-ref jdata (string->symbol "Cholesterol"))
            (hash-ref jdata (string->symbol "Lutein and Zeaxanthin"))
            (hash-ref jdata (string->symbol "Kilocalories"))
            (json->household-weights (hash-ref jdata (string->symbol "Household Weights")))
                (hash-ref jdata (string->symbol "Sugar Total"))
            (hash-ref jdata (string->symbol "Protein"))
            ))

(define (json->vitamins jdata)
    (make-vitamins
        (hash-ref jdata (string->symbol "Vitamin A - IU"))
            (hash-ref jdata (string->symbol "Vitamin C"))
            (hash-ref jdata (string->symbol "Vitamin B12"))
            (hash-ref jdata (string->symbol "Vitamin B6"))
            (hash-ref jdata (string->symbol "Vitamin A - RAE"))
            (hash-ref jdata (string->symbol "Vitamin E"))
            (hash-ref jdata (string->symbol "Vitamin K"))
            ))

(define (json->major-minerals jdata)
    (make-major-minerals
        (hash-ref jdata (string->symbol "Copper"))
            (hash-ref jdata (string->symbol "Iron"))
            (hash-ref jdata (string->symbol "Sodium"))
            (hash-ref jdata (string->symbol "Potassium"))
            (hash-ref jdata (string->symbol "Calcium"))
            (hash-ref jdata (string->symbol "Magnesium"))
            (hash-ref jdata (string->symbol "Zinc"))
            (hash-ref jdata (string->symbol "Phosphorus"))
            ))

(define (json->household-weights jdata)
    (make-household-weights
        (hash-ref jdata (string->symbol "1st Household Weight Description"))
            (hash-ref jdata (string->symbol "1st Household Weight"))
            (hash-ref jdata (string->symbol "2nd Household Weight"))
            (hash-ref jdata (string->symbol "2nd Household Weight Description"))
            ))



; Define the services, and their helpers

(define (get-reports [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM food LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM food"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-reports")
    (displayln (length (time (get-reports false))))
    (displayln "Test get-reports")
    (displayln (length (time (get-reports true))))
    
    

    )