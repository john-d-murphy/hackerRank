# Introduction
#
# The 'tr' command is a useful translation utility in linux.
#
# 'e' being transformed to 'E'
#
# $ echo "Hello" | tr "e" "E"
# HEllo
# Spaces being transformed to hyphens
#
# $ echo "Hello how are you" | tr " " '-'
# Hello-how-are-you
# Digits (numerals) being deleted
#
# $ echo "Hello how are you 1234" | tr -d [0-9]
# Hello how are you
# The Task
# In a given fragment of text, replace all sequences of multiple spaces with just one space.
#
# Input Format
# A block of ASCII text.
#
# Output Format
# Replace all sequences of multiple spaces with just one space.
#
# Sample Input
#
# He  llo
# Wor  ld
# how  are  you
# Sample Output
#
# He llo
# Wor ld
# how are you

tr -s " "
