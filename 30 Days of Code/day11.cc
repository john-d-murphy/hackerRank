#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <climits>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
using namespace std;

/*
Objective
Today, we're building on our knowledge of Arrays by adding another dimension.
Check out the Tutorial tab for learning materials and an instructional video!

Context
Given a 6x6 2D Array, A:
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical representation:

a b c
  d
e f g
There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values.

Task
Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.

Input Format

There are 6 lines of input, where each line contains 6 space-separated integers describing 2D Array A;
every value in A will be in the inclusive range of -9 to 9.

Constraints
-9 <= A[i][j] <= 9
0 <= i,j <= 5

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

int main() {

  int maximumSum = INT_MIN;

  // Populate the grid
  vector<vector<int>> grid(6,vector<int>(6));
  for(int y = 0; y < 6; y++) {
    for(int x = 0; x < 6; x++){
      cin >> grid[x][y];
    }
  }

  // Calculate the 16 sums
  // We use the 4x4 grid starting at 1,1 and ending
  // at 4,4
  for(int y = 1; y < 5; y++) {
    for(int x = 1; x < 5; x++) {
      int barbellSum;
      barbellSum = \
      grid[x-1][y-1] + grid[x][y-1] + grid[x+1][y-1]\
                     + grid[x][y]   +\
      grid[x-1][y+1] + grid[x][y+1] + grid[x+1][y+1];
      if (barbellSum > maximumSum) {
        maximumSum = barbellSum;
      }
    }
  }
  cout << maximumSum << endl;
}
