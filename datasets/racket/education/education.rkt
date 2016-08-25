#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "education.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out math)
    (struct-out state-record)
    (struct-out science)
    (struct-out gender)
    (struct-out data)
    (struct-out attendance)
    (struct-out students)
    (struct-out enrollment)
    (struct-out score)
    (struct-out funding)
    (struct-out reading)
    (struct-out other)
    (struct-out location)
    (struct-out writing)
    (struct-out race)
    get-state
    get-all-states
    main)

; Define the structs
(define-struct math
    (grade scale-score))

(define-struct state-record
    (state data))

(define-struct science
    (grade scale-score))

(define-struct gender
    (male female))

(define-struct data
    (enrollment attendance funding score location))

(define-struct attendance
    (average-student-rate average-teacher-rate average-minutes))

(define-struct students
    (gender all race other year))

(define-struct enrollment
    (schools students student-teacher-ratio teachers staff))

(define-struct score
    (science reading math writing))

(define-struct funding
    (expenditures revenue))

(define-struct reading
    (grade scale-score))

(define-struct other
    (individualized-education-program free-lunch-eligible ungraded-students lep/ell-students reduced-price-lunch-eligible))

(define-struct location
    (latitude longitude))

(define-struct writing
    (grade scale-score))

(define-struct race
    (biracial hispanic black asian white native-american))



; Define the JSON->Struct mappers
(define (json->math jdata)
    (make-math
        (hash-ref jdata (string->symbol "grade"))
            (hash-ref jdata (string->symbol "scale score"))
            ))

(define (json->state-record jdata)
    (make-state-record
        (hash-ref jdata (string->symbol "state"))
            (json->data (hash-ref jdata (string->symbol "data")))
                ))

(define (json->science jdata)
    (make-science
        (hash-ref jdata (string->symbol "grade"))
            (hash-ref jdata (string->symbol "scale score"))
            ))

(define (json->gender jdata)
    (make-gender
        (hash-ref jdata (string->symbol "male"))
            (hash-ref jdata (string->symbol "female"))
            ))

(define (json->data jdata)
    (make-data
        (json->enrollment (hash-ref jdata (string->symbol "enrollment")))
                (json->attendance (hash-ref jdata (string->symbol "attendance")))
                (json->funding (hash-ref jdata (string->symbol "funding")))
                (json->score (hash-ref jdata (string->symbol "score")))
                (json->location (hash-ref jdata (string->symbol "location")))
                ))

(define (json->attendance jdata)
    (make-attendance
        (hash-ref jdata (string->symbol "average student rate"))
            (hash-ref jdata (string->symbol "average teacher rate"))
            (hash-ref jdata (string->symbol "average minutes"))
            ))

(define (json->students jdata)
    (make-students
        (json->gender (hash-ref jdata (string->symbol "gender")))
                (hash-ref jdata (string->symbol "all"))
            (json->race (hash-ref jdata (string->symbol "race")))
                (json->other (hash-ref jdata (string->symbol "other")))
                (hash-ref jdata (string->symbol "year"))
                    ))

(define (json->enrollment jdata)
    (make-enrollment
        (hash-ref jdata (string->symbol "schools"))
            (json->students (hash-ref jdata (string->symbol "students")))
                (hash-ref jdata (string->symbol "student teacher ratio"))
            (hash-ref jdata (string->symbol "teachers"))
            (hash-ref jdata (string->symbol "staff"))
            ))

(define (json->score jdata)
    (make-score
        (map json->science (hash-ref jdata (string->symbol "science")))
                    (map json->reading (hash-ref jdata (string->symbol "reading")))
                    (map json->math (hash-ref jdata (string->symbol "math")))
                    (map json->writing (hash-ref jdata (string->symbol "writing")))
                    ))

(define (json->funding jdata)
    (make-funding
        (hash-ref jdata (string->symbol "expenditures"))
            (hash-ref jdata (string->symbol "revenue"))
            ))

(define (json->reading jdata)
    (make-reading
        (hash-ref jdata (string->symbol "grade"))
            (hash-ref jdata (string->symbol "scale score"))
            ))

(define (json->other jdata)
    (make-other
        (hash-ref jdata (string->symbol "individualized education program"))
            (hash-ref jdata (string->symbol "free lunch eligible"))
            (hash-ref jdata (string->symbol "ungraded students"))
            (hash-ref jdata (string->symbol "lep/ell students"))
            (hash-ref jdata (string->symbol "reduced-price lunch eligible"))
            ))

(define (json->location jdata)
    (make-location
        (hash-ref jdata (string->symbol "latitude"))
            (hash-ref jdata (string->symbol "longitude"))
            ))

(define (json->writing jdata)
    (make-writing
        (hash-ref jdata (string->symbol "grade"))
            (hash-ref jdata (string->symbol "scale score"))
            ))

(define (json->race jdata)
    (make-race
        (hash-ref jdata (string->symbol "biracial"))
            (hash-ref jdata (string->symbol "hispanic"))
            (hash-ref jdata (string->symbol "black"))
            (hash-ref jdata (string->symbol "asian"))
            (hash-ref jdata (string->symbol "white"))
            (hash-ref jdata (string->symbol "native american"))
            ))



; Define the services, and their helpers

(define (get-state state) 
    (check-arg 'state (string? state) 'str 1 state)
    ; Ensure a match exists
    (let ([potentials (map string-downcase 
                           (query-list database "SELECT DISTINCT state FROM school"))]
          [arg (string-downcase state)])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true)) 
(let* [(result (query-list database 
                                   "SELECT data FROM school WHERE state=? COLLATE NOCASE"
                                state
                                ))
               (result (hash-ref jdata (string->symbol "data")))
               ]
           (first (map json->state-record result))
           )
)

(define (get-all-states ) 
(let* [(result (query-list database 
                                   "SELECT data FROM school"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->state-record result)
           )
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-state")
    (displayln (time (get-state "'Virginia'")))
    
    
    (displayln "Production get-all-states")
    (displayln (length (time (get-all-states ))))
    
    

    )