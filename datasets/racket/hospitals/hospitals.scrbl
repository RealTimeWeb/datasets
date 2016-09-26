#lang scribble/manual
 
@title{ hospitals }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': "Medicare has collected data on many different hospitals throughout the country to allow users to compare the quality of these institutions before using their services.  Data includes descriptions of the location of the hospitals, information about the hospitals' emergency services and type of hospital, and outpatient volume for the different wards of the hospitals.\n", 'short': 'Records about the outpatient volume and other information for hospitals across the U.S.', 'citation': 'https://data.medicare.gov/data/hospital-compare'}



@section{Functions}

@defproc[(disconnect-hospitals ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-hospitals ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

