#lang scribble/manual
 
@title{ horse-racing }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'Data about horse races at Churchill Downs.\n', 'short': 'Data about horse races at Churchill Downs.'}



@section{Functions}

@defproc[(disconnect-horse-racing ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-horse-racing ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

