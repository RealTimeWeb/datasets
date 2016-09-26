#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "supreme_court.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out voting)
    (struct-out issue)
    (struct-out area)
    (struct-out court-case)
    (struct-out admin-action)
    (struct-out natural-court)
    (struct-out respondent)
    (struct-out laws)
    (struct-out authority-1)
    (struct-out decision)
    (struct-out start)
    (struct-out arguments)
    (struct-out citation)
    (struct-out id)
    (struct-out source)
    (struct-out disposition)
    (struct-out date-reargued)
    (struct-out majority-assigner)
    (struct-out petitioner)
    (struct-out jurisdiction)
    (struct-out lower-court)
    (struct-out end)
    (struct-out disposition)
    (struct-out case-data)
    (struct-out majority-writer)
    (struct-out date)
    (struct-out reasons)
    (struct-out origin)
    (struct-out date-argued)
    get-cases
    main)

; Define the structs
(define-struct voting
    (unclear minority majority majority-assigner majority-writer split-on-second))

(define-struct issue
    (text id area))

(define-struct area
    (id area))

(define-struct court-case
    (origin lower-court name 3-judge-dc? docket decision citation natural-court source arguments voting issue id laws))

(define-struct admin-action
    (state agency id))

(define-struct natural-court
    (start chief end period id))

(define-struct respondent
    (state id entity))

(define-struct laws
    (type id))

(define-struct authority-1
    (id authority))

(define-struct decision
    (precedent-altered? direction jurisdiction authority-1 authority-2 admin-action unconstitutional term case-data date winning-party type dissent-agrees))

(define-struct start
    (full year day month))

(define-struct arguments
    (date-reargued date-argued respondent petitioner))

(define-struct citation
    (sct led lexis us))

(define-struct id
    (vote docket case-data case-issues))

(define-struct source
    (state id name))

(define-struct disposition
    (id disposition))

(define-struct date-reargued
    (full year day month))

(define-struct majority-assigner
    (long-name id name))

(define-struct petitioner
    (state id entity))

(define-struct jurisdiction
    (id manner))

(define-struct lower-court
    (reasons disagreement? direction disposition))

(define-struct end
    (full year day month))

(define-struct disposition
    (id disposition))

(define-struct case-data
    (unusual disposition))

(define-struct majority-writer
    (long-name id name))

(define-struct date
    (full year day month))

(define-struct reasons
    (reason id))

(define-struct origin
    (state id name))

(define-struct date-argued
    (full year day month))



; Define the JSON->Struct mappers
(define (json->voting jdata)
    (make-voting
        (hash-ref jdata (string->symbol "unclear"))
            (hash-ref jdata (string->symbol "minority"))
            (hash-ref jdata (string->symbol "majority"))
            (json->majority-assigner (hash-ref jdata (string->symbol "majority assigner")))
                (json->majority-writer (hash-ref jdata (string->symbol "majority writer")))
                (hash-ref jdata (string->symbol "split on second"))
            ))

(define (json->issue jdata)
    (make-issue
        (hash-ref jdata (string->symbol "text"))
            (hash-ref jdata (string->symbol "id"))
            (json->area (hash-ref jdata (string->symbol "area")))
                ))

(define (json->area jdata)
    (make-area
        (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "area"))
            ))

(define (json->court-case jdata)
    (make-court-case
        (json->origin (hash-ref jdata (string->symbol "origin")))
                (json->lower-court (hash-ref jdata (string->symbol "lower court")))
                (hash-ref jdata (string->symbol "name"))
            (hash-ref jdata (string->symbol "3 judge dc?"))
            (hash-ref jdata (string->symbol "docket"))
            (json->decision (hash-ref jdata (string->symbol "decision")))
                (json->citation (hash-ref jdata (string->symbol "citation")))
                (json->natural-court (hash-ref jdata (string->symbol "natural court")))
                (json->source (hash-ref jdata (string->symbol "source")))
                (json->arguments (hash-ref jdata (string->symbol "arguments")))
                (json->voting (hash-ref jdata (string->symbol "voting")))
                (json->issue (hash-ref jdata (string->symbol "issue")))
                (json->id (hash-ref jdata (string->symbol "id")))
                (json->laws (hash-ref jdata (string->symbol "laws")))
                ))

(define (json->admin-action jdata)
    (make-admin-action
        (hash-ref jdata (string->symbol "state"))
            (hash-ref jdata (string->symbol "agency"))
            (hash-ref jdata (string->symbol "id"))
            ))

(define (json->natural-court jdata)
    (make-natural-court
        (json->start (hash-ref jdata (string->symbol "start")))
                (hash-ref jdata (string->symbol "chief"))
            (json->end (hash-ref jdata (string->symbol "end")))
                (hash-ref jdata (string->symbol "period"))
            (hash-ref jdata (string->symbol "id"))
            ))

(define (json->respondent jdata)
    (make-respondent
        (hash-ref jdata (string->symbol "state"))
            (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "entity"))
            ))

(define (json->laws jdata)
    (make-laws
        (hash-ref jdata (string->symbol "type"))
            (hash-ref jdata (string->symbol "id"))
            ))

(define (json->authority-1 jdata)
    (make-authority-1
        (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "authority"))
            ))

(define (json->decision jdata)
    (make-decision
        (hash-ref jdata (string->symbol "precedent altered?"))
            (hash-ref jdata (string->symbol "direction"))
            (json->jurisdiction (hash-ref jdata (string->symbol "jurisdiction")))
                (json->authority-1 (hash-ref jdata (string->symbol "authority 1")))
                (hash-ref jdata (string->symbol "authority 2"))
            (json->admin-action (hash-ref jdata (string->symbol "admin action")))
                (hash-ref jdata (string->symbol "unconstitutional"))
            (hash-ref jdata (string->symbol "term"))
            (json->case-data (hash-ref jdata (string->symbol "case data")))
                (json->date (hash-ref jdata (string->symbol "date")))
                (hash-ref jdata (string->symbol "winning party"))
            (hash-ref jdata (string->symbol "type"))
            (hash-ref jdata (string->symbol "dissent agrees"))
            ))

(define (json->start jdata)
    (make-start
        (hash-ref jdata (string->symbol "full"))
            (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "day"))
            (hash-ref jdata (string->symbol "month"))
            ))

(define (json->arguments jdata)
    (make-arguments
        (json->date-reargued (hash-ref jdata (string->symbol "date reargued")))
                (json->date-argued (hash-ref jdata (string->symbol "date argued")))
                (json->respondent (hash-ref jdata (string->symbol "respondent")))
                (json->petitioner (hash-ref jdata (string->symbol "petitioner")))
                ))

(define (json->citation jdata)
    (make-citation
        (hash-ref jdata (string->symbol "sct"))
            (hash-ref jdata (string->symbol "led"))
            (hash-ref jdata (string->symbol "lexis"))
            (hash-ref jdata (string->symbol "us"))
            ))

(define (json->id jdata)
    (make-id
        (hash-ref jdata (string->symbol "vote"))
            (hash-ref jdata (string->symbol "docket"))
            (hash-ref jdata (string->symbol "case data"))
            (hash-ref jdata (string->symbol "case issues"))
            ))

(define (json->source jdata)
    (make-source
        (hash-ref jdata (string->symbol "state"))
            (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->disposition jdata)
    (make-disposition
        (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "disposition"))
            ))

(define (json->date-reargued jdata)
    (make-date-reargued
        (hash-ref jdata (string->symbol "full"))
            (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "day"))
            (hash-ref jdata (string->symbol "month"))
            ))

(define (json->majority-assigner jdata)
    (make-majority-assigner
        (hash-ref jdata (string->symbol "long name"))
            (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->petitioner jdata)
    (make-petitioner
        (hash-ref jdata (string->symbol "state"))
            (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "entity"))
            ))

(define (json->jurisdiction jdata)
    (make-jurisdiction
        (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "manner"))
            ))

(define (json->lower-court jdata)
    (make-lower-court
        (json->reasons (hash-ref jdata (string->symbol "reasons")))
                (hash-ref jdata (string->symbol "disagreement?"))
            (hash-ref jdata (string->symbol "direction"))
            (json->disposition (hash-ref jdata (string->symbol "disposition")))
                ))

(define (json->end jdata)
    (make-end
        (hash-ref jdata (string->symbol "full"))
            (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "day"))
            (hash-ref jdata (string->symbol "month"))
            ))

(define (json->disposition jdata)
    (make-disposition
        (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "disposition"))
            ))

(define (json->case-data jdata)
    (make-case-data
        (hash-ref jdata (string->symbol "unusual"))
            (json->disposition (hash-ref jdata (string->symbol "disposition")))
                ))

(define (json->majority-writer jdata)
    (make-majority-writer
        (hash-ref jdata (string->symbol "long name"))
            (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->date jdata)
    (make-date
        (hash-ref jdata (string->symbol "full"))
            (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "day"))
            (hash-ref jdata (string->symbol "month"))
            ))

(define (json->reasons jdata)
    (make-reasons
        (hash-ref jdata (string->symbol "reason"))
            (hash-ref jdata (string->symbol "id"))
            ))

(define (json->origin jdata)
    (make-origin
        (hash-ref jdata (string->symbol "state"))
            (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "name"))
            ))

(define (json->date-argued jdata)
    (make-date-argued
        (hash-ref jdata (string->symbol "full"))
            (hash-ref jdata (string->symbol "year"))
            (hash-ref jdata (string->symbol "day"))
            (hash-ref jdata (string->symbol "month"))
            ))



; Define the services, and their helpers

(define (get-cases [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM supreme_court LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->court-case result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM supreme_court"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->court-case result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-cases")
    (displayln (length (time (get-cases false))))
    (displayln "Test get-cases")
    (displayln (length (time (get-cases true))))
    
    

    )