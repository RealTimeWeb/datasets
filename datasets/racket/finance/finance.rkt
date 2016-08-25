#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "finance.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit 1000)
(define test-mode false)

; Provide the external structs
(provide
    (struct-out insurance-trust)
    (struct-out correction)
    (struct-out employment)
    (struct-out record)
    (struct-out agriculture)
    (struct-out fish-and-game)
    (struct-out intergovernmental)
    (struct-out details)
    (struct-out financial-aid)
    (struct-out highways)
    (struct-out education)
    (struct-out utilities)
    (struct-out waste)
    (struct-out totals)
    (struct-out welfare)
    (struct-out transportation)
    (struct-out parking)
    (struct-out natural-resources)
    (struct-out water-transport)
    (struct-out parks)
    (struct-out forestry)
    (struct-out public-welfare)
    (struct-out hospitals)
    (struct-out airports)
    (struct-out health)
    get-finances-by-state
    get-finances
    main)

; Define the structs
(define-struct insurance-trust
    (insurance-trust-other-securities insurance-trust-cash-and-deposits insurance-trust-state-and-local-securities-total insurance-trust-securities-total insurance-trust-federal-agency-securities insurance-trust-total-expenditure insurance-trust insurance-trust-cash-and-securities insurance-trust-federal-securities))

(define-struct correction
    (correction-intergovernmental correction-nec-intergovernmental correction-nec-total correction-total correction-institutions-total))

(define-struct employment
    (unemployment-comp-total-cash-and-securities employment-security-administration-expenditure-total employee-retirement-total-cash-and-securities employment-security-administration-intergovernmental employee-retirement-total-expenditure unemployment-comp-total-expenditure))

(define-struct record
    (state totals details year))

(define-struct agriculture
    (agriculture-intergovernmental agriculture-total-expenditure federal-agriculture-farm-income-intergovernmental federal-agriculture-farm-income-total federal-farm-credit-total federal-farm-credit-intergovernmental))

(define-struct fish-and-game
    (fish-and-game-intergovernmental fish-and-game-total-expenditure))

(define-struct intergovernmental
    (intergovernmental-to-combined-and-unallocable intergovernmental-to-federal intergovernmental-to-municipalities intergovernmental-to-counties intergovernmental-to-state intergovernmental-to-townships intergovernmental-to-special-districts intergovernmental-expenditure intergovernmental-to-local intergovernmental-to-school-districts))

(define-struct details
    (education transportation natural-resources correction utilities health public-welfare financial-aid welfare waste employment intergovernmental insurance-trust))

(define-struct financial-aid
    (federal-agency-securities-total beginning-long-term-debt-total-outstanding categorical-assistance-total-expenditure cash-assistance-total-expenditure categorical-assistance-intergovernmental cash-and-securities-total assistance-and-subsidies cash-assistance-intergovernmental borrowing-total sinking-fund-total securities-total bond-fund-total cash-and-deposits-total))

(define-struct highways
    (regular-highways-intergovernmental toll-highways-total-expenditure highways-direct highways-intergovernmental highways-total-expenditure highways-land-and-equipment highways-construction-total regular-highways-total-expenditure))

(define-struct education
    (education-nec-intergovernmental education-equipment edcation-assistance-and-subsidies education-nec-expenditure-total education-total elementary-secondary-total-expenditure education-equipment-and-land higher-education-nec-total-expenditure education-construction elementary-secondary-intergovernmental higher-education-nec-intergovernmental education-intergovernmental higher-education-auxilliary-total-expenditure education-other-current-operation))

(define-struct utilities
    (water-utility-total-expenditure gas-utility-total-expenditure utilities-current-operation utilities-total-expenditure utilities-equipment-and-land utilities-construction utilities-interest-total transit-utility-total-expenditure electric-utility-total-expenditure))

(define-struct waste
    (sewerage-total-expenditure solid-waste-management-intergovernmental sewerage-intergovernmental solid-waste-management-total-expenditure))

(define-struct totals
    (insurance-trust--revenue capital-outlay state-intergovernmental miscellaneous charges construction expenditure general-revenue miscellaneous-commercial-activity other-insurance-trust-revenue worker's-comp-revenue equipment-and-land unemployment-comp-revenue selective-sales-tax sales-tax license-tax federal-intergovernmental general-expenditure utility-revenue revenue tax local-intergovernmental intergovernmental employee-retirement-revenue))

(define-struct welfare
    (welfare-institution-total-expenditure welfare-vendor-payments-total welfare-nec-total-expenditure welfare-nec-intergovernmental))

(define-struct transportation
    (transit-subsidy-intergovernmental airports transit-subsidy-total-expenditure highways water-transport parking))

(define-struct parking
    (parking-total parking-intergovernmental))

(define-struct natural-resources
    (fish-and-game natural-resources-total natural-resources-intergovernmental natural-resources-nec-total-expenditure natural-resources-construction parks forestry natural-resources-direct natural-resources-equipment-and-land agriculture))

(define-struct water-transport
    (water-transport-intergovernmental water-transport-total-expenditure))

(define-struct parks
    (parks-total-expenditure parks-intergovernmental))

(define-struct forestry
    (forestry-intergovernmental forestry-total-expenditure))

(define-struct public-welfare
    (public-welfare-equipment-and-land public-welfare-intergovernmental public-welfare-other-current-operation public-welfare-direct-expenditure public-welfare-construction public-welfare-total-expenditure public-welfare-assistance-and-subsidies))

(define-struct hospitals
    (own-hospitals-total-expenditure hospital-other-total-expenditure hospitals-total-expenditure hospitals-total-intergovernmental hospitals-total-equipment-and-land hospitals-total-construction hospitals-total-current hospital-other-intergovernmental))

(define-struct airports
    (airports-intergovernmental airports-total-expenditure))

(define-struct health
    (health-total-expenditure hospitals health-intergovernmental))



; Define the JSON->Struct mappers
(define (json->insurance-trust jdata)
    (make-insurance-trust
        (hash-ref jdata (string->symbol "Insurance Trust Other Securities"))
            (hash-ref jdata (string->symbol "Insurance Trust Cash and Deposits"))
            (hash-ref jdata (string->symbol "Insurance Trust State and Local Securities Total"))
            (hash-ref jdata (string->symbol "Insurance Trust Securities Total"))
            (hash-ref jdata (string->symbol "Insurance Trust Federal Agency Securities"))
            (hash-ref jdata (string->symbol "Insurance Trust Total Expenditure"))
            (hash-ref jdata (string->symbol "Insurance Trust"))
            (hash-ref jdata (string->symbol "Insurance Trust Cash and Securities"))
            (hash-ref jdata (string->symbol "Insurance Trust Federal Securities"))
            ))

(define (json->correction jdata)
    (make-correction
        (hash-ref jdata (string->symbol "Correction Intergovernmental"))
            (hash-ref jdata (string->symbol "Correction NEC Intergovernmental"))
            (hash-ref jdata (string->symbol "Correction NEC Total"))
            (hash-ref jdata (string->symbol "Correction Total"))
            (hash-ref jdata (string->symbol "Correction Institutions Total"))
            ))

(define (json->employment jdata)
    (make-employment
        (hash-ref jdata (string->symbol "Unemployment Comp Total Cash and Securities"))
            (hash-ref jdata (string->symbol "Employment Security Administration Expenditure Total"))
            (hash-ref jdata (string->symbol "Employee Retirement Total Cash and Securities"))
            (hash-ref jdata (string->symbol "Employment Security Administration Intergovernmental"))
            (hash-ref jdata (string->symbol "Employee Retirement Total Expenditure"))
            (hash-ref jdata (string->symbol "Unemployment Comp Total Expenditure"))
            ))

(define (json->record jdata)
    (make-record
        (hash-ref jdata (string->symbol "State"))
            (json->totals (hash-ref jdata (string->symbol "Totals")))
                (json->details (hash-ref jdata (string->symbol "Details")))
                (hash-ref jdata (string->symbol "Year"))
            ))

(define (json->agriculture jdata)
    (make-agriculture
        (hash-ref jdata (string->symbol "Agriculture Intergovernmental"))
            (hash-ref jdata (string->symbol "Agriculture Total Expenditure"))
            (hash-ref jdata (string->symbol "Federal Agriculture Farm Income Intergovernmental"))
            (hash-ref jdata (string->symbol "Federal Agriculture Farm Income Total"))
            (hash-ref jdata (string->symbol "Federal Farm Credit Total"))
            (hash-ref jdata (string->symbol "Federal Farm Credit Intergovernmental"))
            ))

(define (json->fish-and-game jdata)
    (make-fish-and-game
        (hash-ref jdata (string->symbol "Fish and Game Intergovernmental"))
            (hash-ref jdata (string->symbol "Fish and Game Total Expenditure"))
            ))

(define (json->intergovernmental jdata)
    (make-intergovernmental
        (hash-ref jdata (string->symbol "Intergovernmental to Combined and Unallocable"))
            (hash-ref jdata (string->symbol "Intergovernmental to Federal"))
            (hash-ref jdata (string->symbol "Intergovernmental to Municipalities"))
            (hash-ref jdata (string->symbol "Intergovernmental to Counties"))
            (hash-ref jdata (string->symbol "Intergovernmental to State"))
            (hash-ref jdata (string->symbol "Intergovernmental to Townships"))
            (hash-ref jdata (string->symbol "Intergovernmental to Special Districts"))
            (hash-ref jdata (string->symbol "Intergovernmental Expenditure"))
            (hash-ref jdata (string->symbol "Intergovernmental to Local"))
            (hash-ref jdata (string->symbol "Intergovernmental to School Districts"))
            ))

(define (json->details jdata)
    (make-details
        (json->education (hash-ref jdata (string->symbol "Education")))
                (json->transportation (hash-ref jdata (string->symbol "Transportation")))
                (json->natural-resources (hash-ref jdata (string->symbol "Natural Resources")))
                (json->correction (hash-ref jdata (string->symbol "Correction")))
                (json->utilities (hash-ref jdata (string->symbol "Utilities")))
                (json->health (hash-ref jdata (string->symbol "Health")))
                (json->public-welfare (hash-ref jdata (string->symbol "Public Welfare")))
                (json->financial-aid (hash-ref jdata (string->symbol "Financial Aid")))
                (json->welfare (hash-ref jdata (string->symbol "Welfare")))
                (json->waste (hash-ref jdata (string->symbol "Waste")))
                (json->employment (hash-ref jdata (string->symbol "Employment")))
                (json->intergovernmental (hash-ref jdata (string->symbol "Intergovernmental")))
                (json->insurance-trust (hash-ref jdata (string->symbol "Insurance Trust")))
                ))

(define (json->financial-aid jdata)
    (make-financial-aid
        (hash-ref jdata (string->symbol "Federal Agency Securities Total"))
            (hash-ref jdata (string->symbol "Beginning Long Term Debt Total Outstanding"))
            (hash-ref jdata (string->symbol "Categorical Assistance Total Expenditure"))
            (hash-ref jdata (string->symbol "Cash Assistance Total Expenditure"))
            (hash-ref jdata (string->symbol "Categorical Assistance Intergovernmental"))
            (hash-ref jdata (string->symbol "Cash and Securities Total"))
            (hash-ref jdata (string->symbol "Assistance and Subsidies"))
            (hash-ref jdata (string->symbol "Cash Assistance Intergovernmental"))
            (hash-ref jdata (string->symbol "Borrowing Total"))
            (hash-ref jdata (string->symbol "Sinking Fund Total"))
            (hash-ref jdata (string->symbol "Securities Total"))
            (hash-ref jdata (string->symbol "Bond Fund Total"))
            (hash-ref jdata (string->symbol "Cash and Deposits Total"))
            ))

(define (json->highways jdata)
    (make-highways
        (hash-ref jdata (string->symbol "Regular Highways Intergovernmental"))
            (hash-ref jdata (string->symbol "Toll Highways Total Expenditure"))
            (hash-ref jdata (string->symbol "Highways Direct"))
            (hash-ref jdata (string->symbol "Highways Intergovernmental"))
            (hash-ref jdata (string->symbol "Highways Total Expenditure"))
            (hash-ref jdata (string->symbol "Highways Land and Equipment"))
            (hash-ref jdata (string->symbol "Highways Construction Total"))
            (hash-ref jdata (string->symbol "Regular Highways Total Expenditure"))
            ))

(define (json->education jdata)
    (make-education
        (hash-ref jdata (string->symbol "Education-NEC Intergovernmental"))
            (hash-ref jdata (string->symbol "Education Equipment"))
            (hash-ref jdata (string->symbol "Edcation Assistance and Subsidies"))
            (hash-ref jdata (string->symbol "Education-NEC Expenditure Total"))
            (hash-ref jdata (string->symbol "Education Total"))
            (hash-ref jdata (string->symbol "Elementary Secondary Total Expenditure"))
            (hash-ref jdata (string->symbol "Education Equipment and Land"))
            (hash-ref jdata (string->symbol "Higher Education-NEC Total Expenditure"))
            (hash-ref jdata (string->symbol "Education Construction"))
            (hash-ref jdata (string->symbol "Elementary Secondary Intergovernmental"))
            (hash-ref jdata (string->symbol "Higher Education-NEC Intergovernmental"))
            (hash-ref jdata (string->symbol "Education Intergovernmental"))
            (hash-ref jdata (string->symbol "Higher Education-Auxilliary Total Expenditure"))
            (hash-ref jdata (string->symbol "Education Other Current Operation"))
            ))

(define (json->utilities jdata)
    (make-utilities
        (hash-ref jdata (string->symbol "Water Utility Total Expenditure"))
            (hash-ref jdata (string->symbol "Gas Utility Total Expenditure"))
            (hash-ref jdata (string->symbol "Utilities Current Operation"))
            (hash-ref jdata (string->symbol "Utilities Total Expenditure"))
            (hash-ref jdata (string->symbol "Utilities Equipment and Land"))
            (hash-ref jdata (string->symbol "Utilities Construction"))
            (hash-ref jdata (string->symbol "Utilities Interest Total"))
            (hash-ref jdata (string->symbol "Transit Utility Total Expenditure"))
            (hash-ref jdata (string->symbol "Electric Utility Total Expenditure"))
            ))

(define (json->waste jdata)
    (make-waste
        (hash-ref jdata (string->symbol "Sewerage Total Expenditure"))
            (hash-ref jdata (string->symbol "Solid Waste Management Intergovernmental"))
            (hash-ref jdata (string->symbol "Sewerage Intergovernmental"))
            (hash-ref jdata (string->symbol "Solid Waste Management Total Expenditure"))
            ))

(define (json->totals jdata)
    (make-totals
        (hash-ref jdata (string->symbol "Insurance trust  revenue"))
            (hash-ref jdata (string->symbol "Capital outlay"))
            (hash-ref jdata (string->symbol "State intergovernmental"))
            (hash-ref jdata (string->symbol "Miscellaneous"))
            (hash-ref jdata (string->symbol "Charges"))
            (hash-ref jdata (string->symbol "Construction"))
            (hash-ref jdata (string->symbol "Expenditure"))
            (hash-ref jdata (string->symbol "General revenue"))
            (hash-ref jdata (string->symbol "Miscellaneous commercial activity"))
            (hash-ref jdata (string->symbol "Other insurance trust revenue"))
            (hash-ref jdata (string->symbol "Worker's comp revenue"))
            (hash-ref jdata (string->symbol "Equipment and land"))
            (hash-ref jdata (string->symbol "Unemployment comp revenue"))
            (hash-ref jdata (string->symbol "Selective sales tax"))
            (hash-ref jdata (string->symbol "Sales tax"))
            (hash-ref jdata (string->symbol "License tax"))
            (hash-ref jdata (string->symbol "Federal intergovernmental"))
            (hash-ref jdata (string->symbol "General expenditure"))
            (hash-ref jdata (string->symbol "Utility revenue"))
            (hash-ref jdata (string->symbol "Revenue"))
            (hash-ref jdata (string->symbol "Tax"))
            (hash-ref jdata (string->symbol "Local intergovernmental"))
            (hash-ref jdata (string->symbol "Intergovernmental"))
            (hash-ref jdata (string->symbol "Employee retirement revenue"))
            ))

(define (json->welfare jdata)
    (make-welfare
        (hash-ref jdata (string->symbol "Welfare Institution Total Expenditure"))
            (hash-ref jdata (string->symbol "Welfare Vendor Payments Total"))
            (hash-ref jdata (string->symbol "Welfare NEC Total Expenditure"))
            (hash-ref jdata (string->symbol "Welfare NEC Intergovernmental"))
            ))

(define (json->transportation jdata)
    (make-transportation
        (hash-ref jdata (string->symbol "Transit Subsidy Intergovernmental"))
            (json->airports (hash-ref jdata (string->symbol "Airports")))
                (hash-ref jdata (string->symbol "Transit Subsidy Total Expenditure"))
            (json->highways (hash-ref jdata (string->symbol "Highways")))
                (json->water-transport (hash-ref jdata (string->symbol "Water Transport")))
                (json->parking (hash-ref jdata (string->symbol "Parking")))
                ))

(define (json->parking jdata)
    (make-parking
        (hash-ref jdata (string->symbol "Parking Total"))
            (hash-ref jdata (string->symbol "Parking Intergovernmental"))
            ))

(define (json->natural-resources jdata)
    (make-natural-resources
        (json->fish-and-game (hash-ref jdata (string->symbol "Fish and Game")))
                (hash-ref jdata (string->symbol "Natural Resources Total"))
            (hash-ref jdata (string->symbol "Natural Resources Intergovernmental"))
            (hash-ref jdata (string->symbol "Natural Resources NEC Total Expenditure"))
            (hash-ref jdata (string->symbol "Natural Resources Construction"))
            (json->parks (hash-ref jdata (string->symbol "Parks")))
                (json->forestry (hash-ref jdata (string->symbol "Forestry")))
                (hash-ref jdata (string->symbol "Natural Resources Direct"))
            (hash-ref jdata (string->symbol "Natural Resources Equipment and Land"))
            (json->agriculture (hash-ref jdata (string->symbol "Agriculture")))
                ))

(define (json->water-transport jdata)
    (make-water-transport
        (hash-ref jdata (string->symbol "Water Transport Intergovernmental"))
            (hash-ref jdata (string->symbol "Water Transport Total Expenditure"))
            ))

(define (json->parks jdata)
    (make-parks
        (hash-ref jdata (string->symbol "Parks Total Expenditure"))
            (hash-ref jdata (string->symbol "Parks Intergovernmental"))
            ))

(define (json->forestry jdata)
    (make-forestry
        (hash-ref jdata (string->symbol "Forestry Intergovernmental"))
            (hash-ref jdata (string->symbol "Forestry Total Expenditure"))
            ))

(define (json->public-welfare jdata)
    (make-public-welfare
        (hash-ref jdata (string->symbol "Public Welfare Equipment and Land"))
            (hash-ref jdata (string->symbol "Public Welfare Intergovernmental"))
            (hash-ref jdata (string->symbol "Public Welfare Other Current Operation"))
            (hash-ref jdata (string->symbol "Public Welfare Direct Expenditure"))
            (hash-ref jdata (string->symbol "Public Welfare Construction"))
            (hash-ref jdata (string->symbol "Public Welfare Total Expenditure"))
            (hash-ref jdata (string->symbol "Public Welfare Assistance and Subsidies"))
            ))

(define (json->hospitals jdata)
    (make-hospitals
        (hash-ref jdata (string->symbol "Own Hospitals Total Expenditure"))
            (hash-ref jdata (string->symbol "Hospital-Other Total Expenditure"))
            (hash-ref jdata (string->symbol "Hospitals Total Expenditure"))
            (hash-ref jdata (string->symbol "Hospitals Total Intergovernmental"))
            (hash-ref jdata (string->symbol "Hospitals Total Equipment and land"))
            (hash-ref jdata (string->symbol "Hospitals Total Construction"))
            (hash-ref jdata (string->symbol "Hospitals Total Current"))
            (hash-ref jdata (string->symbol "Hospital-Other Intergovernmental"))
            ))

(define (json->airports jdata)
    (make-airports
        (hash-ref jdata (string->symbol "Airports Intergovernmental"))
            (hash-ref jdata (string->symbol "Airports Total Expenditure"))
            ))

(define (json->health jdata)
    (make-health
        (hash-ref jdata (string->symbol "Health Total Expenditure"))
            (json->hospitals (hash-ref jdata (string->symbol "Hospitals")))
                (hash-ref jdata (string->symbol "Health Intergovernmental"))
            ))



; Define the services, and their helpers

(define (get-finances-by-state state) 
    (check-arg 'state (string? state) 'str 1 state)
    ; Ensure a match exists
    (let ([potentials (map string-downcase 
                           (query-list database "SELECT DISTINCT state FROM finance"))]
          [arg (string-downcase state)])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true)) 
(let* [(result (query-list database 
                                   "SELECT data FROM finance WHERE state=?"
                                state
                                ))
               (result (hash-ref jdata (string->symbol "data")))
               ]
           (first (map json->record result))
           )
)

(define (get-finances [test #t]) 

    (if (or test-mode test)
        (let* [(result (query-list database 
                                  (format "SELECT data FROM finance LIMIT ~a" hardware-limit)
                                ))
               (result (map string->jsexpr result))]
           (map json->record result)
           )(let* [(result (query-list database 
                                   "SELECT data FROM finance"
                                ))
               (result (map string->jsexpr result))
               ]
           (map json->record result)
           ))
)


(define (main)
    (displayln "Running tests")
    
    (displayln "Production get-finances-by-state")
    (displayln (time (get-finances-by-state "Alaska")))
    
    
    (displayln "Production get-finances")
    (displayln (length (time (get-finances false))))
    (displayln "Test get-finances")
    (displayln (length (time (get-finances true))))
    
    

    )