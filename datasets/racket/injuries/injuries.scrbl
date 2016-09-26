#lang scribble/manual
 
@title{ injuries }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': "The Occupational Safety and Health Administration (OSHA) collected work-related injury and illness data from employers within specific industry and employment size specifications from 2002 through 2011. This data collection is called the OSHA Data Initiative or ODI. The data provided is used by OSHA to calculate establishment specific injury and illness incidence rates. This searchable database contains a table with the name, address, industry, and associated Total Case Rate (TCR), Days Away, Restricted, and Transfer (DART) case rate, and the Days Away From Work (DAFWII) case rate for the establishments that provided OSHA with valid data for calendar years 2002 through 2011.\nThis data has been sampled down from its original size to 4%. In addition, the original dataset only has data from a small portion of all private sector establishments in the United States (80,000 out of 7.5 million total establishments). Therefore, these data are not representative of all businesses and general conclusions pertaining to all US business should not be overdrawn.\nData quality: While OSHA takes multiple steps to ensure the data collected is accurate, problems and errors invariably exist for a small percentage of establishments. OSHA does not believe the data for the establishments with the highest rates on this file are accurate in absolute terms. Efforts were made during the collection cycle to correct submission errors, however some remain unresolved. It would be a mistake to say establishments with the highest rates on this file are the 'most dangerous' or 'worst' establishments in the Nation.\nRate Calculation: An incidence rate of injuries and illnesses is computed from the following formula: (Number of injuries and illnesses X 200,000) / Employee hours worked = Incidence rate. The Total Case Rate includes all cases recorded on the OSHA Form 300 (Column G + Column H + Column I + Column J). The Days Away/Restriced/Transfer includes cases recorded in Column H + Column I. The Days Away includes cases recorded in Column H. For further information on injury and illness incidence rates, please visit the Bureau of Labor Statistics' webpage at http://www.bls.gov/iif/osheval.htm\nState Participation: Not all state plan states participate in the ODI. The following states did not participate in the 2010 ODI (collection of CY 2009 data), establishment data is not available for these states: Alaska; Oregon; Puerto Rico; South Carolina; Washington; Wyoming.\n", 'short': 'A sampling of work-related injury and illness data from the US.', 'citation': 'https://www.osha.gov/pls/odi/establishment_search.html'}



@section{Functions}

@defproc[(disconnect-injuries ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-injuries ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

