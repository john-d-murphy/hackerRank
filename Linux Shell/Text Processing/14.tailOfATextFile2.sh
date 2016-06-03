#
#
# Objective
# In this challenge, we practice using the tail command to display the last  characters of a text file.
#
# Resources
# By default, it displays the last n lines when used in the following form:
#
# tail [filename]
# We can also use it to display the last n lines/words/characters/etc by using different flags. For example:
#
# tail -n 11 [filename]  # Last 11 lines
# tail -c 20 [filename]  # Last 20 characters
# We can also specify a certain number of lines to be displayed and list multiple filenames as well. It may also be used to display a specified number of bytes from an input file. Click here for more details about using the tail command.
#
# Task
# Display the last 20 characters of an input file.
#
# Input Format
#
# A text file.
#
# Output Format
#
# Output the last 20 characters of the text file.

tail -c 20
