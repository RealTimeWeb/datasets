#lang scribble/manual
 
@title{ education }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': "This dataset comes from the National Center for Educational Statistics' Common Core of Data. Data is available for every state and the District of Columbia from the 2009-2010 school year. The data is roughly categorized into four categories: funding, how much money is given to the school; score, how students perform academically; attendance, the rate at which students and teachers attend; enrollment, the size of the schools. Funding is given in dollars. The 'Year' field has records for Preschool, Kindergarten, and grades 1-12.\n", 'short': 'Information about K-12 education for different states, collected from the US government.', 'citation': "<a href='https://nces.ed.gov/ccd/aboutCCD.asp'>https://nces.ed.gov/ccd/aboutCCD.asp</a>"}



@section{Functions}

@defproc[(disconnect-education ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-education ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

