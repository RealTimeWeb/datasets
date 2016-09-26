#lang scribble/manual
 
@title{ immigration }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'The Yearbook of Immigration Statistics is a compendium of tables that provides data on foreign nationals who, during a fiscal year, were granted lawful permanent residence (i.e., admitted as immigrants or became legal permanent residents), were admitted into the United States on a temporary basis (e.g., tourists, students, or workers), applied for asylum or refugee status, or were naturalized. The Yearbook also presents data on immigration enforcement actions, including alien apprehensions, removals, and returns.\n', 'short': 'A dataset about the immigration of foreign nationals to the United States.', 'citation': 'http://www.dhs.gov/yearbook-immigration-statistics'}



@section{Functions}

@defproc[(disconnect-immigration ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-immigration ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

