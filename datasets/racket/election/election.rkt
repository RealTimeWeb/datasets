#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "election.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out location)
    (struct-out ted-cruz)
    (struct-out hillary-clinton)
    (struct-out result)
    (struct-out donald-trump)
    (struct-out rick-santorum)
    (struct-out uncommitted)
    (struct-out mike-huckabee)
    (struct-out no-preference)
    (struct-out marco-rubio)
    (struct-out chris-christie)
    (struct-out vote-data)
    (struct-out carly-fiorina)
    (struct-out jeb-bush)
    (struct-out bernie-sanders)
    (struct-out martin-o'malley)
    (struct-out john-kasich)
    (struct-out rand-paul)
    (struct-out ben-carson)
    get-results
    main)

; Define the structs
(define-struct location
    (county state state-abbreviation))

(define-struct ted-cruz
    (party number-of-votes percent-of-votes))

(define-struct hillary-clinton
    (party number-of-votes percent-of-votes))

(define-struct result
    (location vote-data))

(define-struct donald-trump
    (party number-of-votes percent-of-votes))

(define-struct rick-santorum
    (party number-of-votes percent-of-votes))

(define-struct uncommitted
    (party number-of-votes percent-of-votes))

(define-struct mike-huckabee
    (party number-of-votes percent-of-votes))

(define-struct no-preference
    (party number-of-votes percent-of-votes))

(define-struct marco-rubio
    (party number-of-votes percent-of-votes))

(define-struct chris-christie
    (party number-of-votes percent-of-votes))

(define-struct vote-data
    (rand-paul rick-santorum martin-o'malley no-preference chris-christie jeb-bush hillary-clinton john-kasich donald-trump uncommitted mike-huckabee marco-rubio bernie-sanders carly-fiorina ben-carson ted-cruz))

(define-struct carly-fiorina
    (party number-of-votes percent-of-votes))

(define-struct jeb-bush
    (party number-of-votes percent-of-votes))

(define-struct bernie-sanders
    (party number-of-votes percent-of-votes))

(define-struct martin-o'malley
    (party number-of-votes percent-of-votes))

(define-struct john-kasich
    (party number-of-votes percent-of-votes))

(define-struct rand-paul
    (party number-of-votes percent-of-votes))

(define-struct ben-carson
    (party number-of-votes percent-of-votes))



; Define the JSON->Struct mappers
(define (json->location jdata)
    (make-location
        (hash-ref jdata (string->symbol "County"))
            (hash-ref jdata (string->symbol "State"))
            (hash-ref jdata (string->symbol "State Abbreviation"))
            ))

(define (json->ted-cruz jdata)
    (make-ted-cruz
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->hillary-clinton jdata)
    (make-hillary-clinton
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->result jdata)
    (make-result
        (json->location (hash-ref jdata (string->symbol "Location")))
                (json->vote-data (hash-ref jdata (string->symbol "Vote Data")))
                ))

(define (json->donald-trump jdata)
    (make-donald-trump
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->rick-santorum jdata)
    (make-rick-santorum
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->uncommitted jdata)
    (make-uncommitted
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->mike-huckabee jdata)
    (make-mike-huckabee
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->no-preference jdata)
    (make-no-preference
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->marco-rubio jdata)
    (make-marco-rubio
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->chris-christie jdata)
    (make-chris-christie
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->vote-data jdata)
    (make-vote-data
        (json->rand-paul (hash-ref jdata (string->symbol "Rand Paul")))
                (json->rick-santorum (hash-ref jdata (string->symbol "Rick Santorum")))
                (json->martin-o'malley (hash-ref jdata (string->symbol "Martin O'Malley")))
                (json->no-preference (hash-ref jdata (string->symbol "No Preference")))
                (json->chris-christie (hash-ref jdata (string->symbol "Chris Christie")))
                (json->jeb-bush (hash-ref jdata (string->symbol "Jeb Bush")))
                (json->hillary-clinton (hash-ref jdata (string->symbol "Hillary Clinton")))
                (json->john-kasich (hash-ref jdata (string->symbol "John Kasich")))
                (json->donald-trump (hash-ref jdata (string->symbol "Donald Trump")))
                (json->uncommitted (hash-ref jdata (string->symbol "Uncommitted")))
                (json->mike-huckabee (hash-ref jdata (string->symbol "Mike Huckabee")))
                (json->marco-rubio (hash-ref jdata (string->symbol "Marco Rubio")))
                (json->bernie-sanders (hash-ref jdata (string->symbol "Bernie Sanders")))
                (json->carly-fiorina (hash-ref jdata (string->symbol "Carly Fiorina")))
                (json->ben-carson (hash-ref jdata (string->symbol "Ben Carson")))
                (json->ted-cruz (hash-ref jdata (string->symbol "Ted Cruz")))
                ))

(define (json->carly-fiorina jdata)
    (make-carly-fiorina
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->jeb-bush jdata)
    (make-jeb-bush
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->bernie-sanders jdata)
    (make-bernie-sanders
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->martin-o'malley jdata)
    (make-martin-o'malley
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->john-kasich jdata)
    (make-john-kasich
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->rand-paul jdata)
    (make-rand-paul
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))

(define (json->ben-carson jdata)
    (make-ben-carson
        (hash-ref jdata (string->symbol "Party"))
            (hash-ref jdata (string->symbol "Number of Votes"))
            (hash-ref jdata (string->symbol "Percent of Votes"))
            ))



; Define the services, and their helpers

(define (get-results [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM election LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->result result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM election"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->result result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-results")
    (displayln (length (time (get-results false))))
    (displayln "Test get-results")
    (displayln (length (time (get-results true))))
    
    

    )