#lang scribble/manual
 
@title{ construction-permits }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'This dataset provides data on the number and valuation of new housing units authorized by building permits. Data are available monthly at the national, regional, divisional, and state level. The data are from the Building Permits Survey. The United States Code, Title 13, authorizes this survey, provides for voluntary responses, and provides an exception to confidentiality for public records.\n', 'short': 'This dataset provides data on the number and valuation of new housing units authorized by building permits.', 'citation': 'https://www.census.gov/construction/bps/about_the_surveys/'}



@section{Functions}

@defproc[(disconnect-construction-permits ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-construction-permits ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

