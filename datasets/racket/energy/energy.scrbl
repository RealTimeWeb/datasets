#lang scribble/manual
 
@title{ energy }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'United States Government reports on consumption, production, import, and export of various fuel sources.\nThis data comes from the US Energy Information Administration, which has historical data from 1949 to 2014. All numbers are given in Quadrillion BTUs. \n', 'short': 'United States Government reports on consumption, production, import, and export of various fuel sources.', 'citation': 'http://www.eia.gov/tools/faqs/'}



@section{Functions}

@defproc[(disconnect-energy ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-energy ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

