# Objective
# In this challenge, we practice using the cut command to get and print characters from a file.
#
# Resources
# This is a very well written tutorial demonstrating different ways in which cut may be used to
# either print characters at a particular position, or to print columns of a text file based on delimiters.
# The latter is particularly useful while dealing with tabulated data in *.tsv or *.csv format.
#
# Task
# Display the 2nd and 7th character from each line of text.
#
# Input Format
#
# A text file with N lines of ASCII text only.
#
# Note: These values don't really impact your command.
#
# Output Format
# The output should contain N lines. Each line should contain just two characters at the 2nd and the 7th position
# of the corresponding input line.
#
# Do not code defensively for situations where the text is short, and the required characters may not be
# present in a line of text. The cut command will handle it and will not display any character or line in
# such a situation.
#
# Sample Input
#
# Hello
# World
# how are you
# Sample Output
#
# e
# o
# oe
cut -b2,7
