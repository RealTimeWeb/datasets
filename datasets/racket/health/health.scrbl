#lang scribble/manual
 
@title{ health }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'This library holds data about reports of diseases in America.\n', 'short': 'This library holds data about reports of diseases in America.\n'}



@section{Functions}

@defproc[(disconnect-health ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-health ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

