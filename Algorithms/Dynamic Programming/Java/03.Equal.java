import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Christy is interning at HackerRank. One day she has to distribute some chocolates to her colleagues.
She is biased towards her friends and may have distributed the chocolates unequally.
One of the program managers gets to know this and orders Christy to make sure everyone gets equal number of chocolates.

But to make things difficult for the intern, she is ordered to equalize the number of chocolates for every colleague
in the following manner,

For every operation, she can choose one of her colleagues and can do one of the three things.

She can give one chocolate to every colleague other than chosen one.
She can give two chocolates to every colleague other than chosen one.
She can give five chocolates to every colleague other than chosen one.
Calculate minimum number of such operations needed to ensure that every colleague has the same number of chocolates.

Input Format

First line contains an integer T denoting the number of testcases. T testcases follow.
Each testcase has 2 lines. First line of each testcase contains an integer N denoting the number of co-interns.
Second line contains N space separated integers denoting the current number of chocolates each colleague has.

Constraints

* 1 <= T <= 100
* 1 <= N <= 10000

Number of initial chocolates each colleague has < 1000

Output Format

T lines, each containing the minimum number of operations needed to make sure all colleagues have the same number of
chocolates.

Sample Input
1
4
2 2 3 7

Sample Output
2

Explanation
1st operation: Christy increases all elements by 1 except 3rd one
2 2 3 7 -> 3 3 3 8
2nd operation: Christy increases all element by 5 except last one
3 3 3 8 -> 8 8 8 8
*/

public class Solution {

  private static boolean isEqual(List<Integer> counts) {
    if (counts.size() <= 1) {
      return true;
    }

    for (int i = 1; i < counts.size(); i++) {
      if (!counts.get(i).equals(counts.get(i-1))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int cases = in.nextInt();
    for (int i = 1; i <= cases; i++) {
      int interns = in.nextInt();
      List<Integer> internChocolates = new ArrayList<Integer>();
      for( int j = 1; j <= interns; j++) {
        int chocolate = in.nextInt();
        internChocolates.add(chocolate);
      }
      for (Integer chocolate : internChocolates) {
        System.out.printf("%d ", chocolate);
      }
      System.out.printf("\n");
    }
  }
}
