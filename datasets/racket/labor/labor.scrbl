#lang scribble/manual
 
@title{ labor }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'The Current Population Survey (CPS) is a monthly survey of households conducted by the Bureau of Census for the Bureau of Labor Statistics. It provides a comprehensive body of data on the labor force, employment, unemployment, persons not in the labor force, hours of work, earnings, and other demographic and labor force characteristics.\n', 'short': 'Employment status of the civilian population by race, sex, and age.\n', 'citation': 'http://www.bls.gov/cps/home.htm'}



@section{Functions}

@defproc[(disconnect-labor ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-labor ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

