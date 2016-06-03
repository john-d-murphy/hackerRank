# Objective
# In this challenge, we practice using the head command to display the first  characters of a text file.
#
# Resources
# By default, it displays the first n lines when used in the form:
#
# head [filename]
# head -n 11 [filename]  -> First 11 lines
# head -c 20 [filename]  -> First 20 characters
# Since we will provide the text files via STDIN the filename may be ignored.
#
# We can also specify a certain number of lines to be displayed and list multiple filenames as well.
# It may also be used to display a specified number of bytes from an input file.
# Click here for more details about using the head command.
#
# Task
# Display the first 20 characters of an input file.
#
# Input Format
#
# A text file.
#
# Output Format
#
# Output the first 20 characters of the text file.

head -c 20
