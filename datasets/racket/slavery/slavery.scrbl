#lang scribble/manual
 
@title{ slavery }
@author{+email "Ryan Whitcomb (<a href="mailto:rwhit94@vt.edu">rwhit94@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'This dataset has financial records of New Orleans slave sales, 1856-1861. There are almost 16,000 sales recorded in this dataset. \n', 'provenance': 'These data were collected from the office of the Orleans parish Civil Clerk of Court. The sample includes all slave sales recorded by the register of conveyance from October 1856 to August 1861. The construction of the dataset is similar to that employed previously by Fogel and Engerman (1976). The unit of observation is the individual with the exception of children who were bundled with their mothers. \n', 'citation': 'Calomiris, Charles W., and Jonathan Pritchett. 2016. "Betting on Secession: Quantifying Political Events Surrounding Slavery and the Civil War." American Economic Review, 106(1): 1-23.\n', 'short': 'This dataset has financial records of New Orleans slave sales, 1856-1861. There are almost 16,000 sales recorded in this dataset.'}



@section{Functions}

@defproc[(disconnect-slavery ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-slavery ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

