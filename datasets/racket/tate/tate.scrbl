#lang scribble/manual
 
@title{ tate }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'Tate holds the national collection of British art from 1500 to the present day and international modern and contemporary art. The collection embraces all media, from painting, drawing, sculpture and prints to photography, video and film, installation and performance.\nThis dataset has metadata about many pieces from their collection.\n', 'short': 'This dataset is about the Tate art collection, with metadata about paintings, drawings, sculptures, and more.', 'citation': 'http://www.tate.org.uk/about/our-work/collection/about-the-collection'}



@section{Functions}

@defproc[(disconnect-tate ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-tate ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

