#lang scribble/manual
 
@title{ graduates }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': "This library comes from FiveThirtyEight's story on earnings of college majors based on data from the American Community Survey 2010-2012 Public Use Microdata Series.  Included is information about employment numbers, major information, and the earnings of different majors.\n", 'short': 'This library holds data about employment of new graduates by major.', 'citation': 'http://www.census.gov/acs/www/data_documentation/pums_documentation/ <br> https://github.com/fivethirtyeight/data/tree/master/college-majors'}



@section{Functions}

@defproc[(disconnect-graduates ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-graduates ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

