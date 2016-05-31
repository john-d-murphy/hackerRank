

# Given two integers, X and Y, find their sum, difference, product, and quotient.
#
# Input Format
# Two lines containing one integer each ( X and Y, respectively).
#
# Input Constraints
#
#
# Output Format
# Four lines containing the sum (X+Y), difference (X-Y), product (X*Y), and quotient (X/Y), respectively.
# (While computing the quotient, print only the integer part.)
#
# Sample Input
# 5
# 2
# Sample Output
# 7
# 3
# 10
# 2

read x
read y
echo `expr $x + $y`
echo `expr $x - $y`
echo `expr $x \* $y`
echo `expr $x / $y`
