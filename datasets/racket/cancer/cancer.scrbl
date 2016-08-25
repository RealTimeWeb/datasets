#lang scribble/manual
 
@title{ cancer }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': 'From the United States Cancer Statistics as part of the U.S. Center for Disease Control, the following data set focuses on the crude rate for all types of cancer reported for different demograpic groups.  Significant groupings include age, gender, race and geographical area.\n', 'short': 'Cancer crude rate totals for different ages, races, genders, and geographical areas across the United States.', 'citation': 'http://www.cdc.gov/cancer/npcr/uscs/download_data.htm'}



@section{Functions}

@defproc[(disconnect-cancer ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-cancer ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

