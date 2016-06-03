#
# Task
# Given a sentence, identify and display its fourth word. Assume that the space (' ') is the only delimiter between words.
#
# Input Format
# A text file with lines of ASCII text only. Each line has exactly one sentence.
#
# Input Constraints
# 1 <= N <= 100 (N is the number of lines of text in the input file) Note: These values don't really impact your command.
#
# Output Format
# The output should contain N lines. For each input sentence, identify and display its fourth word.
# Assume that the space (' ') is the only delimiter between words.
#
# Sample Input
#
# Hello
# World
# how are you
# Sample Output
#
# Hello
# World

cut -f4 -d' '
