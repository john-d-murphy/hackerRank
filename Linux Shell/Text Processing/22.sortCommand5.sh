#
# The 'Sort' Command Line Program
#
# This is frequently used for sorting input in text or TSV formats, in various different ways supported by it;
# which may be either lexicographical, case insensitive, based on the numeric field only, based on a particular
# column, etc. Using a variety of flags and options, sort can also be extended in various powerful ways.
# The command can also be used for sorting tables of data, delimited by commas (csv) or tabs (tsv) or even spaces;
# on a particular column or field. The -k option helps sort the input file on a particular field, i.e. the column number.
#
# A few useful resources to study these variations of sort are:
# A Wikipedia entry for the 'sort' command
# How to Sort Files in Linux using Sort Command
#
# Task
# You are given a file of text, which contains temperature information about American cities, in TSV (tab-separated) format.
# The first column is the name of the city and the next four columns are the average temperature in the months of Jan, Feb,
# March and April (see the sample input). Rearrange the rows of the table in descending order of the values for the
# average temperature in January.
#
# Input Format
# A text file where each line contains a row of data as described above.
#
# Output Format
# Rearrange the rows of the table in descending order of the values for the average temperature in January
# (i.e, the mean temperature value provided in the second column).
#
# Sample Input
#
# Albany, N.Y.    22.2    46.6    71.1    49.3    38.60   136 64.4    57
# Albuquerque, N.M.   35.7    55.6    78.5    57.3    9.47    60  11.0    64
# Anchorage, Alaska   15.8    36.3    58.4    34.1    16.08   115 70.8    39 / 60
# Asheville, N.C. 35.8    54.1    73.0    55.2    47.07   126 15.3    39
# Atlanta, Ga.    42.7    61.6    80.0    62.8    50.20   115 2.1 69 / 65
# Atlantic City, N.J. 32.1    50.6    75.3    55.1    40.59   113 16.2    60 / 54
# Austin, Texas   50.2    68.3    84.2    70.6    33.65   85  0.9 62 / 58
# Baltimore, Md.  32.3    53.2    76.5    55.4    41.94   115 21.5    53
# Baton Rouge, La.    50.1    66.6    81.7    68.1    63.08   110 0.2 52 / 46
# Billings, Mont. 24.0    46.1    72.0    48.1    14.77   96  56.9    69
# Birmingham, Ala.    42.6    61.3    80.2    62.9    53.99   117 1.5 60
# Bismarck, N.D.  10.2    43.3    70.4    45.2    16.84   96  44.3    64
# Boise, Idaho    30.2    50.6    74.7    52.8    12.19   89  20.6    64
# Boston, Mass.   29.3    48.3    73.9    54.1    42.53   127 42.8    52 / 66
# Bridgeport, Conn.   29.9    48.9    74.0    54.7    44.15   119 26.2    55 / 49
# Sample Output
#
# Austin, Texas   50.2    68.3    84.2    70.6    33.65   85  0.9 62 / 58
# Baton Rouge, La.    50.1    66.6    81.7    68.1    63.08   110 0.2 52 / 46
# Atlanta, Ga.    42.7    61.6    80.0    62.8    50.20   115 2.1 69 / 65
# Birmingham, Ala.    42.6    61.3    80.2    62.9    53.99   117 1.5 60
# Asheville, N.C. 35.8    54.1    73.0    55.2    47.07   126 15.3    39
# Albuquerque, N.M.   35.7    55.6    78.5    57.3    9.47    60  11.0    64
# Baltimore, Md.  32.3    53.2    76.5    55.4    41.94   115 21.5    53
# Atlantic City, N.J. 32.1    50.6    75.3    55.1    40.59   113 16.2    60 / 54
# Boise, Idaho    30.2    50.6    74.7    52.8    12.19   89  20.6    64
# Bridgeport, Conn.   29.9    48.9    74.0    54.7    44.15   119 26.2    55 / 49
# Boston, Mass.   29.3    48.3    73.9    54.1    42.53   127 42.8    52 / 66
# Billings, Mont. 24.0    46.1    72.0    48.1    14.77   96  56.9    69
# Albany, N.Y.    22.2    46.6    71.1    49.3    38.60   136 64.4    57
# Anchorage, Alaska   15.8    36.3    58.4    34.1    16.08   115 70.8    39 / 60
# Bismarck, N.D.  10.2    43.3    70.4    45.2    16.84   96  44.3    64

sort -k2 -nr -t$'\t'
