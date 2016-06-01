
# Given N integers, compute their average correct to three decimal places.
#
# Input Format
# The first line contains an integer, N.
# N lines follow, each containing a single integer.
#
# Output Format
# Display the average of the N integers, rounded off to three decimal places.
#
# Input Constraints
# 1 <= N <= 500
# -10000 <= x <= 10000
#
# Sample Input
#
# 4
# 1
# 2
# 9
# 8
# Sample Output
#
# 5.000

export SUM=0
read N

for i in $(eval echo {1..$N}); do
  read TEMP;
  SUM=`echo $SUM+$TEMP | bc -l`;
done

printf %.3f $(echo "scale = 4; ${SUM}/${N}" | bc -l)
