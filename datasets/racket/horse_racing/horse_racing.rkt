#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "horse_racing.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out trifecta)
    (struct-out pick-3)
    (struct-out also-rans)
    (struct-out superfecta)
    (struct-out exacta)
    (struct-out exacta)
    (struct-out third)
    (struct-out daily-double)
    (struct-out third)
    (struct-out exacta)
    (struct-out exacta)
    (struct-out also-rans)
    (struct-out pick-4)
    (struct-out superfecta)
    (struct-out pick-3)
    (struct-out second)
    (struct-out trifecta)
    (struct-out trifecta)
    (struct-out daily-double)
    (struct-out pick-3)
    (struct-out race)
    (struct-out pick-4)
    (struct-out exacta)
    (struct-out first)
    (struct-out trifecta)
    (struct-out second)
    (struct-out first)
    (struct-out third)
    (struct-out also-rans)
    (struct-out daily-double)
    (struct-out first)
    (struct-out data)
    (struct-out pick-3)
    (struct-out exacta)
    (struct-out pick-4)
    (struct-out pick-5)
    (struct-out superfecta)
    (struct-out second)
    (struct-out also-rans)
    (struct-out superfecta)
    (struct-out trifecta)
    (struct-out daily-double)
    (struct-out daily-double)
    (struct-out exacta)
    (struct-out second)
    (struct-out pick-5)
    (struct-out pick-4)
    (struct-out pick-3)
    (struct-out trifecta)
    (struct-out pick-3)
    (struct-out 10)
    (struct-out 11)
    (struct-out pick-4)
    (struct-out pick-5)
    (struct-out superfecta)
    (struct-out first)
    (struct-out exacta)
    (struct-out pick-3)
    (struct-out third)
    (struct-out exacta)
    (struct-out third)
    (struct-out second)
    (struct-out first)
    (struct-out also-rans)
    (struct-out daily-double)
    (struct-out exacta)
    (struct-out also-rans)
    (struct-out daily-double)
    (struct-out superfecta)
    (struct-out second)
    (struct-out trifecta)
    (struct-out superfecta)
    (struct-out daily-double)
    (struct-out third)
    (struct-out trifecta)
    (struct-out third)
    (struct-out first)
    (struct-out also-rans)
    (struct-out also-rans)
    (struct-out first)
    (struct-out third)
    (struct-out exacta)
    (struct-out also-rans)
    (struct-out first)
    (struct-out daily-double)
    (struct-out pick-3)
    (struct-out 2)
    (struct-out 3)
    (struct-out 1)
    (struct-out 6)
    (struct-out 7)
    (struct-out superfecta)
    (struct-out 5)
    (struct-out 8)
    (struct-out 9)
    (struct-out daily-double)
    (struct-out daily-double)
    (struct-out 4)
    (struct-out second)
    (struct-out first)
    (struct-out first)
    (struct-out trifecta)
    (struct-out also-rans)
    (struct-out pick-3)
    (struct-out second)
    (struct-out superfecta)
    (struct-out third)
    (struct-out third)
    (struct-out second)
    (struct-out second)
    (struct-out second)
    (struct-out superfecta)
    (struct-out third)
    (struct-out also-rans)
    (struct-out first)
    (struct-out superfecta)
    get-races
    main)

; Define the structs
(define-struct trifecta
    (numbers paid))

(define-struct pick-3
    (numbers paid))

(define-struct also-rans
    (gate name))

(define-struct superfecta
    (numbers paid))

(define-struct exacta
    (numbers paid))

(define-struct exacta
    (numbers paid))

(define-struct third
    (gate name show))

(define-struct daily-double
    (numbers paid))

(define-struct third
    (gate name show))

(define-struct exacta
    (numbers paid))

(define-struct exacta
    (numbers paid))

(define-struct also-rans
    (gate name))

(define-struct pick-4
    (numbers paid))

(define-struct superfecta
    (numbers paid))

(define-struct pick-3
    (numbers paid))

(define-struct second
    (gate place name show))

(define-struct trifecta
    (numbers paid))

(define-struct trifecta
    (numbers paid))

(define-struct daily-double
    (numbers paid))

(define-struct pick-3
    (numbers paid))

(define-struct race
    (data year))

(define-struct pick-4
    (numbers paid))

(define-struct exacta
    (numbers paid))

(define-struct first
    (gate show place name win))

(define-struct trifecta
    (numbers paid))

(define-struct second
    (gate place name show))

(define-struct first
    (gate show place name win))

(define-struct third
    (gate name show))

(define-struct also-rans
    (gate name))

(define-struct daily-double
    (numbers paid))

(define-struct first
    (gate show place name win))

(define-struct data
    (10 1 3 2 5 4 7 6 9 8))

(define-struct pick-3
    (numbers paid))

(define-struct exacta
    (numbers paid))

(define-struct pick-4
    (numbers paid))

(define-struct pick-5
    (numbers paid))

(define-struct superfecta
    (numbers paid))

(define-struct second
    (gate place name show))

(define-struct also-rans
    (gate name))

(define-struct superfecta
    (numbers paid))

(define-struct trifecta
    (numbers paid))

(define-struct daily-double
    (numbers paid))

(define-struct daily-double
    (numbers paid))

(define-struct exacta
    (numbers paid))

(define-struct second
    (gate place name show))

(define-struct pick-5
    (numbers paid))

(define-struct pick-4
    (numbers paid))

(define-struct pick-3
    (numbers paid))

(define-struct trifecta
    (numbers paid))

(define-struct pick-3
    (numbers paid))

(define-struct 10
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct 11
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct pick-4
    (numbers paid))

(define-struct pick-5
    (numbers paid))

(define-struct superfecta
    (numbers paid))

(define-struct first
    (gate show place name win))

(define-struct exacta
    (numbers paid))

(define-struct pick-3
    (numbers paid))

(define-struct third
    (gate name show))

(define-struct exacta
    (numbers paid))

(define-struct third
    (gate name show))

(define-struct second
    (gate place name show))

(define-struct first
    (gate show place name win))

(define-struct also-rans
    (gate name))

(define-struct daily-double
    (numbers paid))

(define-struct exacta
    (numbers paid))

(define-struct also-rans
    (gate name))

(define-struct daily-double
    (numbers paid))

(define-struct superfecta
    (numbers paid))

(define-struct second
    (gate place name show))

(define-struct trifecta
    (numbers paid))

(define-struct superfecta
    (numbers paid))

(define-struct daily-double
    (numbers paid))

(define-struct third
    (gate name show))

(define-struct trifecta
    (numbers paid))

(define-struct third
    (gate name show))

(define-struct first
    (gate show place name win))

(define-struct also-rans
    (gate name))

(define-struct also-rans
    (gate name))

(define-struct first
    (gate show place name win))

(define-struct third
    (gate name show))

(define-struct exacta
    (numbers paid))

(define-struct also-rans
    (gate name))

(define-struct first
    (gate show place name win))

(define-struct daily-double
    (numbers paid))

(define-struct pick-3
    (numbers paid))

(define-struct 2
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct 3
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct 1
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct 6
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct 7
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct superfecta
    (numbers paid))

(define-struct 5
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct 8
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct 9
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct daily-double
    (numbers paid))

(define-struct daily-double
    (numbers paid))

(define-struct 4
    (scratched also-rans trifecta third daily-double exacta second superfecta first))

(define-struct second
    (gate place name show))

(define-struct first
    (gate show place name win))

(define-struct first
    (gate show place name win))

(define-struct trifecta
    (numbers paid))

(define-struct also-rans
    (gate name))

(define-struct pick-3
    (numbers paid))

(define-struct second
    (gate place name show))

(define-struct superfecta
    (numbers paid))

(define-struct third
    (gate name show))

(define-struct third
    (gate name show))

(define-struct second
    (gate place name show))

(define-struct second
    (gate place name show))

(define-struct second
    (gate place name show))

(define-struct superfecta
    (numbers paid))

(define-struct third
    (gate name show))

(define-struct also-rans
    (gate name))

(define-struct first
    (gate show place name win))

(define-struct superfecta
    (numbers paid))



; Define the JSON->Struct mappers
(define (json->trifecta jdata)
    (make-trifecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-3 jdata)
    (make-pick-3
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->pick-4 jdata)
    (make-pick-4
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-3 jdata)
    (make-pick-3
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->trifecta jdata)
    (make-trifecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->trifecta jdata)
    (make-trifecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-3 jdata)
    (make-pick-3
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->race jdata)
    (make-race
        (json->data (hash-ref jdata (string->symbol "data")))
                (hash-ref jdata (string->symbol "year"))
            ))

(define (json->pick-4 jdata)
    (make-pick-4
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->trifecta jdata)
    (make-trifecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->data jdata)
    (make-data
        (json->10 (hash-ref jdata (string->symbol "10")))
                (json->1 (hash-ref jdata (string->symbol "1")))
                (json->3 (hash-ref jdata (string->symbol "3")))
                (json->2 (hash-ref jdata (string->symbol "2")))
                (json->5 (hash-ref jdata (string->symbol "5")))
                (json->4 (hash-ref jdata (string->symbol "4")))
                (json->7 (hash-ref jdata (string->symbol "7")))
                (json->6 (hash-ref jdata (string->symbol "6")))
                (json->9 (hash-ref jdata (string->symbol "9")))
                (json->8 (hash-ref jdata (string->symbol "8")))
                ))

(define (json->pick-3 jdata)
    (make-pick-3
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-4 jdata)
    (make-pick-4
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-5 jdata)
    (make-pick-5
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->trifecta jdata)
    (make-trifecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->pick-5 jdata)
    (make-pick-5
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-4 jdata)
    (make-pick-4
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-3 jdata)
    (make-pick-3
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->trifecta jdata)
    (make-trifecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-3 jdata)
    (make-pick-3
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->10 jdata)
    (make-10
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (hash-ref jdata (string->symbol "trifecta"))
            (json->third (hash-ref jdata (string->symbol "third")))
                (json->daily-double (hash-ref jdata (string->symbol "daily_double")))
                (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (json->superfecta (hash-ref jdata (string->symbol "superfecta")))
                (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->11 jdata)
    (make-11
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (hash-ref jdata (string->symbol "trifecta"))
            (json->third (hash-ref jdata (string->symbol "third")))
                (json->daily-double (hash-ref jdata (string->symbol "daily_double")))
                (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (json->superfecta (hash-ref jdata (string->symbol "superfecta")))
                (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->pick-4 jdata)
    (make-pick-4
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-5 jdata)
    (make-pick-5
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-3 jdata)
    (make-pick-3
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->trifecta jdata)
    (make-trifecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->trifecta jdata)
    (make-trifecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->exacta jdata)
    (make-exacta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->pick-3 jdata)
    (make-pick-3
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->2 jdata)
    (make-2
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (hash-ref jdata (string->symbol "trifecta"))
            (json->third (hash-ref jdata (string->symbol "third")))
                (json->daily-double (hash-ref jdata (string->symbol "daily_double")))
                (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (json->superfecta (hash-ref jdata (string->symbol "superfecta")))
                (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->3 jdata)
    (make-3
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (hash-ref jdata (string->symbol "trifecta"))
            (json->third (hash-ref jdata (string->symbol "third")))
                (json->daily-double (hash-ref jdata (string->symbol "daily_double")))
                (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (json->superfecta (hash-ref jdata (string->symbol "superfecta")))
                (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->1 jdata)
    (make-1
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (json->trifecta (hash-ref jdata (string->symbol "trifecta")))
                (json->third (hash-ref jdata (string->symbol "third")))
                (hash-ref jdata (string->symbol "daily_double"))
            (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (json->superfecta (hash-ref jdata (string->symbol "superfecta")))
                (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->6 jdata)
    (make-6
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (hash-ref jdata (string->symbol "trifecta"))
            (json->third (hash-ref jdata (string->symbol "third")))
                (json->daily-double (hash-ref jdata (string->symbol "daily_double")))
                (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (json->superfecta (hash-ref jdata (string->symbol "superfecta")))
                (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->7 jdata)
    (make-7
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (hash-ref jdata (string->symbol "trifecta"))
            (json->third (hash-ref jdata (string->symbol "third")))
                (json->daily-double (hash-ref jdata (string->symbol "daily_double")))
                (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (json->superfecta (hash-ref jdata (string->symbol "superfecta")))
                (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->5 jdata)
    (make-5
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (hash-ref jdata (string->symbol "trifecta"))
            (json->third (hash-ref jdata (string->symbol "third")))
                (json->daily-double (hash-ref jdata (string->symbol "daily_double")))
                (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (json->superfecta (hash-ref jdata (string->symbol "superfecta")))
                (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->8 jdata)
    (make-8
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (hash-ref jdata (string->symbol "trifecta"))
            (json->third (hash-ref jdata (string->symbol "third")))
                (json->daily-double (hash-ref jdata (string->symbol "daily_double")))
                (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (json->superfecta (hash-ref jdata (string->symbol "superfecta")))
                (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->9 jdata)
    (make-9
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (json->trifecta (hash-ref jdata (string->symbol "trifecta")))
                (json->third (hash-ref jdata (string->symbol "third")))
                (json->daily-double (hash-ref jdata (string->symbol "daily_double")))
                (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (hash-ref jdata (string->symbol "superfecta"))
            (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->daily-double jdata)
    (make-daily-double
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->4 jdata)
    (make-4
        (hash-ref jdata (string->symbol "scratched"))
                    (map json->also-rans (hash-ref jdata (string->symbol "also-rans")))
                    (hash-ref jdata (string->symbol "trifecta"))
            (json->third (hash-ref jdata (string->symbol "third")))
                (json->daily-double (hash-ref jdata (string->symbol "daily_double")))
                (json->exacta (hash-ref jdata (string->symbol "exacta")))
                (json->second (hash-ref jdata (string->symbol "second")))
                (json->superfecta (hash-ref jdata (string->symbol "superfecta")))
                (json->first (hash-ref jdata (string->symbol "first")))
                ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->trifecta jdata)
    (make-trifecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->pick-3 jdata)
    (make-pick-3
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->second jdata)
    (make-second
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))

(define (json->third jdata)
    (make-third
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "show"))
            ))

(define (json->also-rans jdata)
    (make-also-rans
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->first jdata)
    (make-first
        (hash-ref jdata (string->symbol "gate"))
            (hash-ref jdata (string->symbol "show"))
            (hash-ref jdata (string->symbol "place"))
            (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "win"))
            ))

(define (json->superfecta jdata)
    (make-superfecta
        (hash-ref jdata (string->symbol "numbers"))
            (hash-ref jdata (string->symbol "paid"))
            ))



; Define the services, and their helpers

(define (get-races ) 
(let* [(result (query-list database 
                                   "SELECT data FROM races"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->race result)
           )
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-races")
    (displayln (length (time (get-races ))))
    
    

    )