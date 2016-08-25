#lang scribble/manual
 
@title{ earthquakes }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': "Earthquake records from around the world collected from the United States Geological Survey.  Important details about the earthquake such as distance, gap, magnitude, depth and significance are included to properly describe the earthquake.  Additionally, data about exact geological coordinates and a relative description of the earthquake's location is included.\n", 'short': 'Records from different earthquake occurences across the world.', 'citation': 'http://earthquake.usgs.gov/earthquakes/'}



@section{Functions}

@defproc[(disconnect-earthquakes ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-earthquakes ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

