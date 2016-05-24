#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
Watson gives two integers ( A and B ) to Sherlock and asks if he can count the number
of square integers between A and B (both inclusive).

Note: A square integer is an integer which is the square of any integer.
For example, 1, 4, 9, and 16 are some of the square integers as they are squares
of 1, 2, 3, and 4, respectively.

Input Format
The first line contains T, the number of test cases.  T test cases follow, each in a new line.
Each test case contains two space-separated integers denoting A and B.

Output Format
For each test case, print the required answer in a new line.

Constraints
1 <= T <= 100
1 <= A <= B <= 10^9

Sample Input

2
3 9
17 24
Sample output
2
0
*/

int main() {
  int testCases;
  cin >> testCases;
  for(int testCase = 0; testCase < testCases; testCase++){
    long startNumber;
    long stopNumber;
    long startRoot;
    long stopRoot;
    // The number of squares between the two numbers is the
    // count of the integers betwen the root of the two numbers.
    // e.g. there are three perfect squares between 25 and 49,
    // inclusive.

    // I needed this one explained to me - there's a property of
    // the numbers that's not really intuitive.

    int numberOfSquares = 0;
    cin >> startNumber >> stopNumber;
    startRoot = floor(sqrt(startNumber));
    stopRoot = ciel(sqrt(stopNumber));
    numberOfSquares = stopRoot-startRoot + 1;
    cout << numberOfSquares << endl;
  }
}
