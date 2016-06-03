#
# Objective
# In this challenge, we practice using the head command to display the first  lines of a text file.
#
# Resources
# Here's a useful video on the topic:
#
#
# By default, it displays the first 10 lines when used in the following form:
#
# head [filename]
# head -n 11 [filename]  -> First 11 lines
# head -c 20 [filename]  -> First 20 characters
# Since we will provide the text files via STDIN, the filename may be ignored.
#
# We can also specify a certain number of lines to be displayed and list multiple filenames as well.
# It may also be used to display a specified number of bytes from an input file.
# Click here for more details about using the head command.
#
# Task
# Display the first 20 lines of an input file.
#
# Input Format
#
# A text file.
#
# Output Format
#
# Output the first 20 lines of the given text file.

head -20
