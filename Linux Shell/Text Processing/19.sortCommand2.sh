# Objective
# In this challenge, we practice using the sort command to sort input in text or TSV formats.
#
# Resources
# The sort command is frequently used for sorting input in text or TSV formats in various different ways. These ways may be either lexicographical, case insensitive, based on the numeric field only, based on a particular column, etc.
#
# Sort Options
#
# The vanilla sort command simply sorts the lines of the input file in lexicographical order.
# The -n option sorts the file on the basis of the numeric fields available if the first word or column in the file is a number.
# The -r option reverses the sorting order to either the reverse of the usual lexicographical ordering or descending order while sorting in numerical mode.
# The -k option is useful while sorting a table of data (tsv, csv etc.) based on a specified column (or columns).
# The -t option is used while specifying a delimiter in a particular file where columns are separated by tabs, spaces, pipes etc.
# A few useful resources to study different variants as well as working examples of the sort command are:
# A Wikipedia entry for the 'sort' command
# How to Sort Files in Linux using Sort Command
#
# Task
# Given a text file, order the lines in reverse lexicographical order (i.e. Z-A instead of A-Z).
#
# Input Format
#
# A text file.
#
# Output Format
#
# Output the text file with the lines reordered in reverse lexicographical order.
#
# Sample Input
#
# Dr. Rajendra Prasad     January 26, 1950    May 13, 1962
# Dr. S. Radhakrishnan        May 13, 1962    May 13, 1967
# Dr. Zakir Hussain       May 13, 1967    August 24, 1969
# Shri Varahagiri Venkata Giri        August 24, 1969 August 24, 1974
# Shri Fakhruddin Ali Ahmed       August 24, 1974 February 11, 1977
# Shri Neelam Sanjiva Reddy       July 25, 1977   July 25, 198
# Sample Output
#
# Shri Varahagiri Venkata Giri        August 24, 1969 August 24, 1974
# Shri Neelam Sanjiva Reddy       July 25, 1977   July 25, 198
# Shri Fakhruddin Ali Ahmed       August 24, 1974 February 11, 1977
# Dr. Zakir Hussain       May 13, 1967    August 24, 1969
# Dr. S. Radhakrishnan        May 13, 1962    May 13, 1967
# Dr. Rajendra Prasad     January 26, 1950    May 13, 1962

sort -r
