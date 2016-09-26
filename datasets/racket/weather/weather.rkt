#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "weather.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out date)
    (struct-out data)
    (struct-out wind)
    (struct-out report)
    (struct-out temperature)
    (struct-out station)
    get-weather
    main)

; Define the structs
(define-struct date
    (full day month year))

(define-struct data
    (precipitation temperature wind))

(define-struct wind
    (high-gust avg-wind high-wind))

(define-struct report
    (weather-conditions date station data))

(define-struct temperature
    (max-temp avg-temp min-temp))

(define-struct station
    (city state code location))



; Define the JSON->Struct mappers
(define (json->date jdata)
    (make-date
        (hash-ref jdata (string->symbol "Full"))
            (hash-ref jdata (string->symbol "Day"))
            (hash-ref jdata (string->symbol "Month"))
            (hash-ref jdata (string->symbol "Year"))
            ))

(define (json->data jdata)
    (make-data
        (hash-ref jdata (string->symbol "Precipitation"))
            (json->temperature (hash-ref jdata (string->symbol "Temperature")))
                (json->wind (hash-ref jdata (string->symbol "Wind")))
                ))

(define (json->wind jdata)
    (make-wind
        (hash-ref jdata (string->symbol "High Gust"))
            (hash-ref jdata (string->symbol "Avg Wind"))
            (hash-ref jdata (string->symbol "High Wind"))
            ))

(define (json->report jdata)
    (make-report
        (hash-ref jdata (string->symbol "Weather Conditions"))
                    (json->date (hash-ref jdata (string->symbol "Date")))
                (json->station (hash-ref jdata (string->symbol "Station")))
                (json->data (hash-ref jdata (string->symbol "Data")))
                ))

(define (json->temperature jdata)
    (make-temperature
        (hash-ref jdata (string->symbol "Max Temp"))
            (hash-ref jdata (string->symbol "Avg Temp"))
            (hash-ref jdata (string->symbol "Min Temp"))
            ))

(define (json->station jdata)
    (make-station
        (hash-ref jdata (string->symbol "City"))
            (hash-ref jdata (string->symbol "State"))
            (hash-ref jdata (string->symbol "Code"))
            (hash-ref jdata (string->symbol "Location"))
            ))



; Define the services, and their helpers

(define (get-weather [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM weather LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->report result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM weather"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->report result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-weather")
    (displayln (length (time (get-weather false))))
    (displayln "Test get-weather")
    (displayln (length (time (get-weather true))))
    
    

    )