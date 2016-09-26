#lang scribble/manual
 
@title{ hydropower }
@author{+email "Ryan Whitcomb" ""}

@section{Structs}
 
{'overview': "Recent Federal policies and legislation focus on moving the nation towards a cleaner energy economy that includes developing environmentally appropriate renewable energy projects involving solar, wind and waves, geothermal, biofuels, and hydropower.  The 2010 Federal Memorandum of Understanding for Hydropower and the Energy Policy Act of 2005 direct the U.S. Department of Reclamation to evaluate development of new hydropower projects at Federally-owned facilities and upgrade or rehabilitate existing hydropower generation facilities, as a contribution to the nation's clean energy goals.  The following data describes the facilities currently being operated that contribute to nationwide renewable energy strategies.\n", 'short': 'Records about dams in the United States such as location, dimensions, and project information', 'citation': 'http://www.usbr.gov/power/AssessmentReport/'}



@section{Functions}

@defproc[(disconnect-hydropower ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-hydropower ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

