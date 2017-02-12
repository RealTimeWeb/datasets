#lang scribble/manual
 
@title{ drugs }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)Ryan Whitcomb (<a href="mailto:rwhit94@vt.edu">rwhit94@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'This dataset is about substance abuse (cigarettes, marijuana, cocaine, alcohol) among different age groups and states. Data was collected from individual states as part of the NSDUH study. The data ranges from 2002 to 2014. Some values were <i>imputed</i>, meaning that they are estimated. Both totals (in thousands of people) and rates (as a percentage of the population) are given.\n', 'short': 'This dataset is about substance abuse (cigarettes, marijuana, cocaine, alcohol) among different age groups and states.', 'citation': "<a href='https://nsduhweb.rti.org/respweb/homepage.cfm'>https://nsduhweb.rti.org/respweb/homepage.cfm</a>"}



@section{Functions}

@defproc[(disconnect-drugs ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-drugs ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

