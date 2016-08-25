#lang scribble/manual
 
@title{ art-institute-metadata }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': "The Minneapolis Institute of Art's mission is to enrich the community by collecting, preserving, and making accessible outstanding works of art from the world's diverse cultures.  The following data contains information about the culture, location, and time period associated with the artist of the work in addition to descriptive information about the work as a whole.  Also added in information pertaining directly to information useful to the Minneapolis Institute of Art as it pertains to classification and location within the Institute.\n", 'short': 'A data set about the metadata associated with the collection of the Minneapolis Institute of Art.', 'citation': 'Obtained from the Minneapolis Institute of Art, specifically from https://github.com/artsmia/collection'}



@section{Functions}

@defproc[(disconnect-art-institute-metadata ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-art-institute-metadata ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

