#lang scribble/manual
 
@title{ retail-services }
@author{+email "Austin Cory Bart (<a href="mailto:acbart@vt.edu">acbart@vt.edu</a>)" ""}

@section{Structs}
 
{'overview': 'The Advance Monthly and Monthly Retail Trade Surveys (MARTS and MRTS), the Annual Retail Trade Survey (ARTS), and the Quarterly E-Commerce Report work together to produce the most comprehensive data available on retail economic activity in the United States. More detailed descriptions of these programs can be found by choosing one of the links to the left.\nRegular quality control and verification takes place between MARTS, MRTS, and ARTS annually and between these programs and the Economic Census of Retail Trade every five years. Each year when annual data become available, we compare and resolve differences between the data collected on the monthly and annual surveys. We refer to this process as the monthly-to-annual reconciliation. At the same time, we benchmark the monthly estimates using results of the annual survey. ARTS estimates are then benchmarked to data maintained by the Economic Census of Retail Trade. This process of benchmarking retail data over all four programs ensures consistency in our estimates.\nThe Business Expenses Supplement is an addition to the 2007 Annual Retail Trade Survey. Its purpose is to compile statistics on detailed business operating expenses. The United States Code, Title 13, authorizes this program as part of the Economic Census. This coverage was previously part of the predecessor Business Expenses Survey. Detailed expenses are collected every five years. \n', 'short': 'Monthly sales, inventories, and inventory/sales ratios for retail trade and food services.', 'citation': 'http://www.census.gov/retail/about_the_surveys.html'}



@section{Functions}

@defproc[(disconnect-retail-services ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-retail-services ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

