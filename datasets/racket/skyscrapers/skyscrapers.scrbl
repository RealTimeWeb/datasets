#lang scribble/manual
 
@title{ skyscrapers }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'Collected statistics about the tallest buildings all over the world, including the materials used to develop them, the purpose of the buildings, and more.\n', 'short': 'Information about tall buildings constructed all over the world.', 'citation': 'http://www.skyscrapercenter.com/'}



@section{Functions}

@defproc[(disconnect-skyscrapers ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-skyscrapers ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

