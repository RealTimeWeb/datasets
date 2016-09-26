#lang scribble/manual
 
@title{ state-fragility }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': "The Center for Systemic Peace was founded in 1997 to engage in global systems analysis to minimize the effects of political violence in the world as a whole.  The following data set shows the state fragility for countries with a population greater than 500,000 in 2013.  The State Fragility Index scores countries on two main categories, effectiveness and legitimacy.  These are then broken down into four dimensions: Security, Political, Economic, and Social.  The State Fragility Index score is the sum of the individual country's effectiveness score and their legitimacy score.  Each of these scores are the summation of the four dimensions within the category.  \n", 'short': 'The State Fragility Index scores for countries around the world from 1995 to 2014', 'citation': 'http://www.systemicpeace.org/inscrdata.html'}



@section{Functions}

@defproc[(disconnect-state-fragility ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-state-fragility ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

