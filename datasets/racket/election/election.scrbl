#lang scribble/manual
 
@title{ election }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': "Data about the results was collected from CNN's 2016 election center.  Each county has the breakdown of how many votes each candidate recieved in that county and what percentage of the total vote from that county that the candidate recieved.  The candidate's political party is also represented.  \n", 'short': 'A breakdown of how each county voted in the 2016 Presidential primaries.', 'citation': 'http://www.cnn.com/election/primaries/counties/va/Dem'}



@section{Functions}

@defproc[(disconnect-election ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-election ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

