#lang scribble/manual
 
@title{ music }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'The Music library has data about a multitude of songs and artists.\n', 'short': 'The Music library has data about a multitude of songs and artists.'}



@section{Functions}

@defproc[(disconnect-music ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-music ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

