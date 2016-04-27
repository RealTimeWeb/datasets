#lang scribble/manual
 
@title{ cars }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'This is a dataset about cars and how much fuel they use.\n', 'short': 'This is a dataset about cars and how much fuel they use.\n'}



@section{Functions}

@defproc[(disconnect-cars ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-cars ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

