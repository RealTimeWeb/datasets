#lang scribble/manual
 
@title{ weather }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': 'Under the National Oceanic and Atmpospheric Administration, the National Weather Service provides daily weather reports for cities across the county.  This is done through the use of 122 different Weather Forcast Offices throughout the country.  These WFOs are responsible for the daily weather reports for serveral cities throughout their region of coverage.  This data set takes the information from these WFO reports for cities across the country through the months of April to June of 2016.\n', 'short': 'Weather records through the months of April and June of 2016 across the U.S.', 'citation': 'http://w2.weather.gov/climate/'}



@section{Functions}

@defproc[(disconnect-weather ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-weather ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

