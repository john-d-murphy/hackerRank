#include <iostream>
#include <cmath>
#include <math.h>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

/*
Given a square matrix of size NxN, calculate the absolute difference between the sums of its diagonals.

Input Format

The first line contains a single integer, N.
The next N lines denote the matrix's rows, with each line containing space-separated integers describing the columns.

Output Format
Print the absolute difference between the two sums of the matrix's diagonals as a single integer.

Sample Input

3
11   2    4
4    5    6
10   8  -12
Sample Output

15
Explanation

The primary diagonal is:
11 5 -12

Sum across the primary diagonal: 11 + 5 - 12 = 4

The secondary diagonal is:
10 5 4
Sum across the secondary diagonal: 4 + 5 + 10 = 19
Difference: |4 - 19| = 15

--------------
Don't need to store the whole matrix -
the primary diagonal is 0,0 / 1,1 / 2,2 ... n,n
the secondary digonal is (n-1),0 / (n-2),1 / (n-3), 2  ... 0,(n-1)
so we can just store these and then print out the abs difference.
*/

int main() {
  int n;
  cin >> n;
  int primaryDiagonal = 0;
  int secondaryDiagonal = 0;
  for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
      int temp;
      cin >> temp;
      if (i == j) {
        primaryDiagonal += temp;
      }
      if (i + j == (n-1)) {
        secondaryDiagonal += temp;
      }
    }
  }
  cout << abs(primaryDiagonal - secondaryDiagonal) << endl;
}
