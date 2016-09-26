#lang scribble/manual
 
@title{ suicide-attacks }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': "The Chicago Project on Security and Terrorism (CPOST) maintains a searchable database on all suicide attacks from 1982 through September 2015. The database includes information about the location of attacks, the target type, the weapon used, and systematic information on the demographic and general biographical characteristics of suicide attackers. The database expands the breadth of the data available in English using native language sources (e.g., Arabic, Hebrew, Russian, Tamil) that are likely to have the most extensive relevant information.\nThe current CPOST-SAD release contains the universe of suicide attacks from 1982 through September 2015, a total of 4,814 attacks in over 40 countries. The CPOST Suicide Attack Database (CPOST-SAD) contains data on the universe of suicide attacks. For each attack, the database includes information about the geographic location, target classification, and weapon(s) used, as well as systematic information on the demographic and general biographical characteristics of suicide attackers. More information about the coding and methodology is available on the CPOST website below.\nNote that multiple attackers or targets are collapsed into a single record for simplicity's sake.\n", 'short': 'This dataset has about suicide attacks all over the world for the past three decades.', 'citation': 'Chicago Project on Security and Terrorism (CPOST). 2015. Suicide Attack Database (December 9, 2015 Release). [Data File]. Retrieved from http://cpostdata.uchicago.edu/'}



@section{Functions}

@defproc[(disconnect-suicide-attacks ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-suicide-attacks ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

