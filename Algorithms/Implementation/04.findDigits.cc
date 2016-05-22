#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
Given an integer,N, traverse its digits (d1,d2,...,dn) and determine how many digits evenly divide N.
(i.e.: count the number of times N divided by each digit i has a remainder of 0).
Print the number of evenly divisible digits.

Note: Each digit is considered to be unique, so each occurrence of the same evenly divisible
digit should be counted (i.e.: for N=111, the answer is 3).

Input Format

The first line is an integer,T, indicating the number of test cases.
The T subsequent lines each contain an integer, N.

Constraints
1 <= T <= 15
0 < N < 10^9

Output Format

For every test case, count and print (on a new line) the number of digits in N that
 are able to evenly divide N.

Sample Input
2
12
1012
Sample Output
2
3
*/

int main() {
  int testCases;
  cin >> testCases;
  for(int testCase = 0; testCase < testCases; testCase++){
    long testNumber;
    long initialNumber;
    int divisible = 0;
    cin >> testNumber;
    initialNumber = testNumber;
    // Shrink testNumber by 1 digit each time, ending up at 0
    while (testNumber > 0) {
      int digit = testNumber % 10;
      if (digit != 0 && initialNumber % digit == 0) {
        divisible++;
      }
      testNumber = testNumber/10;
    }
    cout << divisible << endl;
  }
}
