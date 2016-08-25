#lang scribble/manual
 
@title{ airlines }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'This dataset is all about flights in the united states, including information about the number, length, and type of delays. The data is reported for individual months at every major airport for every carrier.\nAdditional information is available: <a href="http://www.rita.dot.gov/bts/help/aviation/html/understanding.html">http://www.rita.dot.gov/bts/help/aviation/html/understanding.html</a>\n', 'short': 'Information about flight delays in major aiports since 2003.'}



@section{Functions}

@defproc[(disconnect-airlines ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-airlines ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

