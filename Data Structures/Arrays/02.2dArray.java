import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Given a 6x6 2D Array, A:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical
representation:

a b c
  d
e f g

There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values.

Task
Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.


Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

Input Format

There are 6 lines of input, where each line contains 6 space-separated integers describing 2D Array ;
every value in A will be in the inclusive range of -9 to 9.

Constraints

* -9 <= A[i][j] <= 9
*  0 <= i,j <= 5

Output Format

Print the largest (maximum) hourglass sum found in A.

Sample Input
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output
19
*/

public class Solution {

  public static int getHourGlassSum( int arr[][], int x, int y) {
    int sum = -999;
    if (x == 0 || x == 5) {
      return sum;
    } else if (y == 0 || y == 5) {
      return sum;
    } else {
      sum = arr[x-1][y-1];
      sum += arr[x][y-1];
      sum += arr[x+1][y-1];
      sum += arr[x][y];
      sum += arr[x-1][y+1];
      sum += arr[x][y+1];
      sum += arr[x+1][y+1];

      return sum;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int arr[][] = new int[6][6];
    for(int y=0; y < 6; y++){
      for(int x=0; x < 6; x++){
        arr[x][y] = in.nextInt();
      }
    }

    int maxSum = -999;
    for(int x = 0; x < 6; x++) {
      for(int y = 0; y < 6; y++) {
        int tempSum = getHourGlassSum(arr, x, y);
        if (tempSum > maxSum) {
          maxSum = tempSum;
        }
      }
    }
    System.out.printf("%d", maxSum);
  }
}

