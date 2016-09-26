#lang scribble/manual
 
@title{ medal-of-honor }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': "This dataset has records for the awarding of the United States Medal of Honor. The Medal of Honor is the United States of America's highest military honor, awarded for personal acts of valor above and beyond the call of duty. The medal is awarded by the President of the United States in the name of the U.S. Congress to U.S. military personnel only. There are three versions of the medal, one for the Army, one for the Navy, and one for the Air Force.[5] Personnel of the Marine Corps and Coast Guard receive the Navy version.\nThe dataset was collected from the official military site, and includes records about how the medal was awarded and characteristics of the recipient. Unfortunately, because of the nature of century-old record keeping, many of the records are incomplete. While a very interesting dataset, it does have some missing data. \n", 'short': "This dataset has records for the awarding of the United States Medal of Honor, one of the military's highest honors.", 'citation': 'http://www.cmohs.org/'}



@section{Functions}

@defproc[(disconnect-medal-of-honor ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-medal-of-honor ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

