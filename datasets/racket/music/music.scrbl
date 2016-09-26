#lang scribble/manual
 
@title{ music }
@author{+email "Ryan Whitcomb (<a href="mailto:rwhit94@vt.edu">rwhit94@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'This library comes from the Million Song Dataset, which used a company called the Echo Nest to derive data points about one million popular contemporary songs.  The Million Song Dataset is a collaboration between the Echo Nest and LabROSA, a laboratory working towards intelligent machine listening.  The project was also funded in part by the National Science Foundation of America (NSF) to provide a large data set to evaluate research related to algorithms on a commercial size while promoting further research into the Music Information Retrieval field.  The data contains standard information about the songs such as artist name, title, and year released.  Additionally, the data contains more advanced information; for example, the length of the song, how many musical bars long the song is, and how long the fade in to the song was.\n', 'short': 'The Music library is a compilation of over one million contemporary songs and information about their audio features and metadata.', 'citation': 'Thierry Bertin-Mahieux, Daniel P.W. Ellis, Brian Whitman, and Paul Lamere. <br> The Million Song Dataset. In Proceedings of the 12th International Society <br> for Music Information Retrieval Conference (ISMIR 2011), 2011.'}



@section{Functions}

@defproc[(disconnect-music ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-music ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

