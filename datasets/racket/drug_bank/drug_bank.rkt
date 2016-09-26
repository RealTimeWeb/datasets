#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "drug_bank.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out proteins)
    (struct-out properties)
    (struct-out drug)
    get-drugs
    main)

; Define the structs
(define-struct proteins
    (category entrez-gene-id pubmed-ids actions known-action organism uniprot-id))

(define-struct properties
    (water-solubility isoelectric-point logp caco2-permeability logs pka boiling-point hydrophobicity molecular-formula molecular-weight melting-point))

(define-struct drug
    (inchikey name proteins properties atc-codes groups inchi type id categories))



; Define the JSON->Struct mappers
(define (json->proteins jdata)
    (make-proteins
        (hash-ref jdata (string->symbol "category"))
            (hash-ref jdata (string->symbol "entrez gene id"))
            (hash-ref jdata (string->symbol "pubmed ids"))
                    (hash-ref jdata (string->symbol "actions"))
                    (hash-ref jdata (string->symbol "known action"))
            (hash-ref jdata (string->symbol "organism"))
            (hash-ref jdata (string->symbol "uniprot id"))
            ))

(define (json->properties jdata)
    (make-properties
        (hash-ref jdata (string->symbol "water solubility"))
            (hash-ref jdata (string->symbol "isoelectric point"))
            (hash-ref jdata (string->symbol "logp"))
            (hash-ref jdata (string->symbol "caco2 permeability"))
            (hash-ref jdata (string->symbol "logs"))
            (hash-ref jdata (string->symbol "pka"))
            (hash-ref jdata (string->symbol "boiling point"))
            (hash-ref jdata (string->symbol "hydrophobicity"))
            (hash-ref jdata (string->symbol "molecular formula"))
            (hash-ref jdata (string->symbol "molecular weight"))
            (hash-ref jdata (string->symbol "melting point"))
            ))

(define (json->drug jdata)
    (make-drug
        (hash-ref jdata (string->symbol "inchikey"))
            (hash-ref jdata (string->symbol "name"))
            (map json->proteins (hash-ref jdata (string->symbol "proteins")))
                    (json->properties (hash-ref jdata (string->symbol "properties")))
                (hash-ref jdata (string->symbol "atc codes"))
                    (hash-ref jdata (string->symbol "groups"))
                    (hash-ref jdata (string->symbol "inchi"))
            (hash-ref jdata (string->symbol "type"))
            (hash-ref jdata (string->symbol "id"))
            (hash-ref jdata (string->symbol "categories"))
                    ))



; Define the services, and their helpers

(define (get-drugs [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM drug_bank LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->drug result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM drug_bank"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->drug result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-drugs")
    (displayln (length (time (get-drugs false))))
    (displayln "Test get-drugs")
    (displayln (length (time (get-drugs true))))
    
    

    )