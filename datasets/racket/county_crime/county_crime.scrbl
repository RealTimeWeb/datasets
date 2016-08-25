#lang scribble/manual
 
@title{ county-crime }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': 'From the Unified Crime Reporting Statistics and  under the collaboration of the U.S. Department of Justice and the Federal Bureau of Investigation information crime statistics are available for public review.  The following data set has information on the crime rates and totals for counties across the United States for a wide range of years.  The crime reports are divided into two main categories: property and violent crime.  Property crime refers to burglary, larceny, and motor related crime while violent crime refers to assault, murder, rape, and robbery.\n', 'short': 'Records about the crime rates and totals for US counties over time.', 'citation': 'http://www.ucrdatatool.gov/Search/Crime/Local/JurisbyJurisStepTwo.cfm'}



@section{Functions}

@defproc[(disconnect-county-crime ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-county-crime ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

