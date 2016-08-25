#lang scribble/manual
 
@title{ broadway }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'This library holds data about over Broadway shows, grouped over weeklong periods. Only shows that reported capacity were included, so the dataset stretches back to the 1990s. The dataset is made available by the Broadway League (the national trade association for the Broadway industry), and you can view the data online at http://www.broadwayleague.com/. This dataset \n', 'short': 'This library holds data about Broadway shows, such as tickets sold.'}



@section{Functions}

@defproc[(disconnect-broadway ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-broadway ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

