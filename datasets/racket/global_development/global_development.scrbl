#lang scribble/manual
 
@title{ global-development }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': 'The following data contains records collected on different countries and geographic locations from 1980 - 2013 from the World Bank.  Included is different data about urban development, agriculture and rural development, health, and infrastructure.       \n', 'short': "Reports of country's development over time", 'citation': 'https://ndb.nal.usda.gov/'}



@section{Functions}

@defproc[(disconnect-global-development ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-global-development ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

