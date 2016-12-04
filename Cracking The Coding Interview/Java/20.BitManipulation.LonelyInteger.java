import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 Consider an array of n integers,A = [a0,a1,...an], where all but one of the integers occur in pairs.
 In other words, every element in A occurs exactly twice except for one unique element.

 Given A, find and print the unique element.


Input Format

The first line contains a single integer,n, denoting the number of integers in the array.
The second line contains n space-separated integers describing the respective values in A.

Constraints

* 1 <= n < 100
* It is guaranteed that n is an odd number.
* 0 <= ai <= 100, where 0 <= i < n

Output Format

Print the unique number that occurs only once in  on a new line.

Sample Input 0

1
1
Sample Output 0

1
Explanation 0
The array only contains a single 1, so we print 1 as our answer.

Sample Input 1

3
1 1 2
Sample Output 1

2
Explanation 1
We have two 's and one 1. We print 2, because that's the only unique element in the array.

Sample Input 2

5
0 0 1 2 1
Sample Output 2

2
Explanation 2
We have two 0's, two 1's, and one 2. We print 2, because that's the only unique element in the array.
*/

public class Solution {

  public static int lonelyInteger(int a[], int counts[]) {
    for( int i = 0; i < a.length; i++) {
      int value = a[i];
      counts[value]++;
    }

    for( int i = 0; i < counts.length; i++) {
      if (counts[i] == 1) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    int maxInt = 0;
    for(int a_i=0; a_i < n; a_i++){
      int nextInt = in.nextInt();
      a[a_i] = nextInt;
      if (nextInt > maxInt) {
        maxInt = nextInt;
      }
    }
    int counts[] = new int[maxInt+1];
    System.out.println(lonelyInteger(a, counts));
  }
}
