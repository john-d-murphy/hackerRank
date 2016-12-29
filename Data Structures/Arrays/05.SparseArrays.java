import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
There are N strings.
Each string's length is no more than 20 characters.
There are also Q queries.
For each query, you are given a string, and you need to find out how many times this string occurred previously.

Input Format
The first line contains N, the number of strings.
The next N lines each contain a string.
The N+2nd line contains Q, the number of queries.
The following Q lines each contain a query string.

Constraints
1 <= N <= 1000
1 <= Q <= 1000
1 <= length of any string <= 20

Sample Input
4
aba
baba
aba
xzxb
3
aba
xzxb
ab

Sample Output
2
1
0

Explanation
Here, "aba" occurs twice, in the first and third string.
The string "xzxb" occurs once in the fourth string, and "ab" does not occur at all.
*/
c class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<String,Integer> counts = new HashMap<String,Integer>();

    // Get Data
    int strings = scanner.nextInt();
    String dummyString = scanner.nextLine();

    for(int i = 0; i < strings; i++) {
      String nextString = scanner.nextLine();

      if(counts.get(nextString) == null) {
        counts.put(nextString,0);
      }

      int currentCount = counts.get(nextString) + 1;

      counts.put(nextString, currentCount);
    }

    // Get Queries
    int queries = scanner.nextInt();
    dummyString = scanner.nextLine();

    for(int i = 0; i < queries; i++) {
      String queryString = scanner.nextLine();

      if(counts.get(queryString) == null) {
        System.out.printf("0\n");
      } else {
        System.out.printf("%d\n", counts.get(queryString));
      }
    }

  }
}

