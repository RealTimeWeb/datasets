#lang scribble/manual
 
@title{ construction-spending }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'The Value of Construction Put in Place Survey (VIP) provides monthly estimates of the total dollar value of construction work done in the U.S. The United States Code, Title 13, authorizes this program. The survey covers construction work done each month on new structures or improvements to existing structures for private and public sectors. Data estimates include the cost of labor and materials, cost of architectural and engineering work, overhead costs, interest and taxes paid during construction, and contractor\'s profits. Data collection and estimation activities begin on the first day after the reference month and continue for about three weeks. Reported data and estimates are for activity taking place during the previous calendar month. The survey has been conducted monthly since 1964. <br><br><b>Why isn\'t the \'total construction\' the sum of the other categories?</b> It is! the trick is that the \'residential\' and "nonresidential" categories are supposed to be below the \'total construction\' level, and the other categories are below those two categories. This example of the data should make it more clear: <a href=\'http://www.census.gov/construction/c30/pdf/tot.pdf\'>http://www.census.gov/construction/c30/pdf/tot.pdf</a>.<br><br>More information about the nature of the construction projects is also <a href=\'https://www.census.gov/construction/c30/definitions.html\'>available.</a>\n', 'short': 'Estimates of the total dollar value of construction work done in the U.S.', 'citation': 'http://www.census.gov/construction/c30/c30index.html'}



@section{Functions}

@defproc[(disconnect-construction-spending ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-construction-spending ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

