import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Given an array A = {a1,a2, ... , an) of N elements, find the maximum possible sum of a:

1. Contiguous subarray
2. Non-contiguous (not necessarily contiguous) subarray

Empty Subarrays/Sequencies should not be considered.

Input Format:

First line has integer T. T cases follow.
Each test case begins with an integer N. In the next line, N integers follow representing elements of array A.

Constraints:
* 1 <= T <= 10
* 1 <= N <= 10^5
* -10^4 <= ai <= 10^4

The subarray and subsequences you consider should have at least one element.

Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray.
At least one integer should be selected and put into the subarrays (this may be required in cases where all
elements are negative).

Sample Input
2
4
1 2 3 4
6
2 -1 2 3 4 -5

Sample Output
10 10
10 11

Explanation

In the first case:
The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

In the second case:
[2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum.
For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.

*/

public class Solution {

  public static void main( String[] args) {
    Scanner in = new Scanner(System.in);
    int numberOfArrays = in.nextInt();

    for (int i = 1; i <= numberOfArrays; i++) {

      int numberOfElements = in.nextInt();
      boolean onlyNegative = true;
      long nonContiguousSum = 0;
      long maxContiguous = 0;
      long maxNegativeNumber = 0;
      long runningSum = 0; // temporary running sum
      List<Integer> mixedArray = new ArrayList<Integer>();

      for( int j = 1; j <= numberOfElements; j++) {
        int thisValue = in.nextInt();

        if (thisValue >= 0) {
          nonContiguousSum += thisValue;
          onlyNegative = false;
          mixedArray.add(thisValue);
        } else if (thisValue < 0) {
          if (maxNegativeNumber == 0 || thisValue > maxNegativeNumber) {
            maxNegativeNumber = thisValue;
          }

          if (mixedArray.size() > 0 && j < numberOfElements) {
            mixedArray.add(thisValue);
          }
        }
      }

      for(long j : mixedArray) {
        runningSum += j;
        if (runningSum < 0) {
          runningSum = 0;
        }
        if (runningSum > maxContiguous) {
          maxContiguous = runningSum;
        }
      }

      if (onlyNegative) {
        System.out.printf("%d %d\n", maxNegativeNumber, maxNegativeNumber);
      } else {
        System.out.printf("%d %d\n", maxContiguous, nonContiguousSum);
      }

    }
  }
}
