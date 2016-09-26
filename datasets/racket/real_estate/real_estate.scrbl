#lang scribble/manual
 
@title{ real-estate }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': "Real Estate Across the United States (REXUS) is the primary tool used by PBS to track and manage the government's real property assets and to store inventory data, building data, customer data, and lease information. STAR manages aspects of real property space management, including identification of all building space and daily management of 22,000 assignments for all property to its client Federal agencies. This data set contains PBS building inventory that consists of both owned and leased buildings with active and excess status.\n", 'short': 'Real estate information in the United States, including inventory, building, and customer data.', 'citation': 'https://catalog.data.gov/dataset/real-estate-across-the-united-states-rexus-inventory-building', 'changes': [{'body': 'Added a default argument for get buildings by state, corrected documentation about the state naming schema.', 'date': '3/11/2016 at 9:42pm'}]}



@section{Functions}

@defproc[(disconnect-real-estate ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-real-estate ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

