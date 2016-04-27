#lang scribble/manual
 
@title{ classics }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': "Project Gutenberg (PG) is a volunteer effort to digitize and archive cultural works, to 'encourage the creation and distribution of eBooks'. It was founded in 1971 by Michael S. Hart and is the oldest digital library. This dataset is a collection of the top 1000 most popular books on Project Gutenberg, as determined by downloads. Each book has information about its authorship, publication date, congressional classication, and a few other fields. It also has some simple, computed statistics based on common metrics such as sentiment analysis, Flesch Kincaid Reading level, and average sentence length. \n", 'short': 'Records and computed statistics about the top 1000 books on Project Gutenberg.', 'citation': 'https://www.gutenberg.org/ebooks/search/?sort_order=downloads'}



@section{Functions}

@defproc[(disconnect-classics ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-classics ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

