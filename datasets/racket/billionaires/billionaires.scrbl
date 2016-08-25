#lang scribble/manual
 
@title{ billionaires }
@author{+email "Ryan Whitcomb (<a href="mailto:rwhit94">rwhit94</a>)" ""}

@section{Structs}
 
{'overview': "Researchers have compiled a multi-decade database of the super-rich. Building off the Forbes World's Billionaires lists from 1996-2014, scholars at Peterson Institute for International Economics have added a couple dozen more variables about each billionaire - including whether they were self-made or inherited their wealth. (Roughly half of European billionaires and one-third of U.S. billionaires got a significant financial boost from family, the authors estimate.)\n", 'short': 'Information about over 2000 billionaires from around the world.\n', 'citation': 'http://www.iie.com/publications/interstitial.cfm?ResearchID=2917'}



@section{Functions}

@defproc[(disconnect-billionaires ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-billionaires ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

