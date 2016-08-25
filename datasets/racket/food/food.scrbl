#lang scribble/manual
 
@title{ food }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': "The following data comes from the United States Department of Agriculture's Food Composition Database.  It contains data for various types of food including the amounts of different vitamins and minerals found in the foods as well as macronutrient percentages.  The food covered spans a large variety of foods from butter to Campbell's soup.            \n", 'short': 'Statistics for various food items', 'citation': 'https://ndb.nal.usda.gov/'}



@section{Functions}

@defproc[(disconnect-food ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-food ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

