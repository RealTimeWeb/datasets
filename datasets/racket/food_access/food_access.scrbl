#lang scribble/manual
 
@title{ food-access }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': "From the United States Department of Agriculture's Economic Research Service, the dataset contains information about US county's ability to access supermarkets, supercenters, grocery stores, or other sources of healthy and affordable food.  Most measures of how individuals and neighborhoods are able to access food are based on the following indicators: \n    - Accessibility to sources of healthy food, as measured by distance to a store or by the number of stores in an area.\n    - Individual-level resources that may affect accessibility, such as family income or vehicle availability.\n    - Neighborhood-level indicators of resources, such as the average income of the neighborhood and the availability of public transportation.  \n", 'short': 'Data about counties ability to access supermarkets, supercenters, grocery stores, or other sources of healthy and affordable food.', 'citation': 'http://www.ers.usda.gov/data-products/food-access-research-atlas.aspx'}



@section{Functions}

@defproc[(disconnect-food-access ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-food-access ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

