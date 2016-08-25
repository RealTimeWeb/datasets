#lang scribble/manual
 
@title{ aids }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': 'The UNAIDS Organization is an entity of the United Nations that looks to reduce the transmission of AIDS and provide resources to those currently affected by the disease.  The following data set contains information on the number of those affected by the disease, new cases of the disease being reported, and AIDS-related deaths for a large set of countries over the course of 1990 - 2015.\n', 'short': 'Records of AIDS related statistics from several countries.', 'citation': 'http://aidsinfo.unaids.org/'}



@section{Functions}

@defproc[(disconnect-aids ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-aids ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

