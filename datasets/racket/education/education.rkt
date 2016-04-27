#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require net/url)
(require db)


; Provide the external structs
(provide
    (struct-out math)
    (struct-out state-record)
    (struct-out science)
    (struct-out reading)
    (struct-out data)
    (struct-out students)
    (struct-out enrollment)
    (struct-out score)
    (struct-out funding)
    (struct-out gender)
    (struct-out other)
    (struct-out location)
    (struct-out attendance)
    (struct-out writing)
    (struct-out race)
    get-state
    get-all-states)

; Define the structs
(define-struct math
    (grade scale-score))

(define-struct state-record
    (state data))

(define-struct science
    (grade scale-score))

(define-struct reading
    (grade scale-score))

(define-struct data
    (enrollment attendance funding score location))

(define-struct students
    (gender all race other year))

(define-struct enrollment
    (schools students student-teacher-ratio teachers staff))

(define-struct score
    (science reading math writing))

(define-struct funding
    (expenditures revenue))

(define-struct gender
    (male female))

(define-struct other
    (individualized-education-program free-lunch-eligible ungraded-students lep/ell-students reduced-price-lunch-eligible))

(define-struct location
    (latitude longitude))

(define-struct attendance
    (average-student-rate average-teacher-rate average-minutes))

(define-struct writing
    (grade scale-score))

(define-struct race
    (biracial hispanic black asian white native-american))


(define (json->math jdata)
    (make-math
        (hash-ref jdata (string->symbol "grade"))
        (hash-ref jdata (string->symbol "scale score"))
        
(define (json->state-record jdata)
    (make-state-record
        (hash-ref jdata (string->symbol "state"))
        (json->data (hash-ref jdata (string->symbol "data")))
        
(define (json->science jdata)
    (make-science
        (hash-ref jdata (string->symbol "grade"))
        (hash-ref jdata (string->symbol "scale score"))
        
(define (json->reading jdata)
    (make-reading
        (hash-ref jdata (string->symbol "grade"))
        (hash-ref jdata (string->symbol "scale score"))
        
(define (json->data jdata)
    (make-data
        (json->enrollment (hash-ref jdata (string->symbol "enrollment")))
        (json->attendance (hash-ref jdata (string->symbol "attendance")))
        (json->funding (hash-ref jdata (string->symbol "funding")))
        (json->score (hash-ref jdata (string->symbol "score")))
        (json->location (hash-ref jdata (string->symbol "location")))
        
(define (json->students jdata)
    (make-students
        (json->gender (hash-ref jdata (string->symbol "gender")))
        (hash-ref jdata (string->symbol "all"))
        (json->race (hash-ref jdata (string->symbol "race")))
        (json->other (hash-ref jdata (string->symbol "other")))
        (hash-ref jdata (string->symbol "year"))
        
(define (json->enrollment jdata)
    (make-enrollment
        (hash-ref jdata (string->symbol "schools"))
        (json->students (hash-ref jdata (string->symbol "students")))
        (hash-ref jdata (string->symbol "student teacher ratio"))
        (hash-ref jdata (string->symbol "teachers"))
        (hash-ref jdata (string->symbol "staff"))
        
(define (json->score jdata)
    (make-score
        (map json->science (hash-ref jdata (string->symbol "science")))
        (map json->reading (hash-ref jdata (string->symbol "reading")))
        (map json->math (hash-ref jdata (string->symbol "math")))
        (map json->writing (hash-ref jdata (string->symbol "writing")))
        
(define (json->funding jdata)
    (make-funding
        (hash-ref jdata (string->symbol "expenditures"))
        (hash-ref jdata (string->symbol "revenue"))
        
(define (json->gender jdata)
    (make-gender
        (hash-ref jdata (string->symbol "male"))
        (hash-ref jdata (string->symbol "female"))
        
(define (json->other jdata)
    (make-other
        (hash-ref jdata (string->symbol "individualized education program"))
        (hash-ref jdata (string->symbol "free lunch eligible"))
        (hash-ref jdata (string->symbol "ungraded students"))
        (hash-ref jdata (string->symbol "lep/ell students"))
        (hash-ref jdata (string->symbol "reduced-price lunch eligible"))
        
(define (json->location jdata)
    (make-location
        (hash-ref jdata (string->symbol "latitude"))
        (hash-ref jdata (string->symbol "longitude"))
        
(define (json->attendance jdata)
    (make-attendance
        (hash-ref jdata (string->symbol "average student rate"))
        (hash-ref jdata (string->symbol "average teacher rate"))
        (hash-ref jdata (string->symbol "average minutes"))
        
(define (json->writing jdata)
    (make-writing
        (hash-ref jdata (string->symbol "grade"))
        (hash-ref jdata (string->symbol "scale score"))
        
(define (json->race jdata)
    (make-race
        (hash-ref jdata (string->symbol "biracial"))
        (hash-ref jdata (string->symbol "hispanic"))
        (hash-ref jdata (string->symbol "black"))
        (hash-ref jdata (string->symbol "asian"))
        (hash-ref jdata (string->symbol "white"))
        (hash-ref jdata (string->symbol "native american"))
        


; Define the services, and their helpers

(define get-state (state) 
    (check-arg 'state (str? state) 'str 1 state) 
    (json->state-record (get-state/json  state )))
    


(define get-all-states () 
    (json->list[state-record] (get-all-states/json )))
    

