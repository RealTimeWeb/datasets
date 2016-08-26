#lang scribble/manual
 
@title{ publishers }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': "From a newspaper article about analyzing amazon e-book sales by genre and publisher. Unfortunately, they do not have information on the book's title or author. This collection includes 54,000 titles spanning across several genres and types of publishing companies, practically every book on every Amazon bestseller list. Along with publisher information, it also includes the book's overall Amazon Kindle store sales ranking.\n", 'short': 'E-book sales on Amazon, including daily and total earnings for 54,000 titles.\n', 'citation': 'http://authorearnings.com/report/september-2015-author-earnings-report/'}



@section{Functions}

@defproc[(disconnect-publishers ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-publishers ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

