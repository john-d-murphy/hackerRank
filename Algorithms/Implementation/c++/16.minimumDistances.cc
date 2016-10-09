#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
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
#include <unordered_map>

using namespace std;

/*
Consider an array of n integers, A=[a0,a1,...an-1].
The distance between two indices, i and j, is denoted by di,j = |i-j|.

Given A, find the minimum di,j such that ai = aj and i != j.
In other words, find the minimum distance between any pair of equal elements in the array.
If no such value exists, print -1.

Note: |a| denotes the absolute value of a.

Input Format

The first line contains an integer, n, denoting the size of array A.
The second line contains n space-separated integers describing the respective elements in array A.

Constraints
1 <= n <= 10^3
1 <= ai <= 10^5

Output Format
Print a single integer denoting the minimum di,j in A; if no such value exists, print -1.

Sample Input
6
7 1 3 4 1 7

Sample Output
3
*/

int main() {
  int n;
  int minimumDistance = -1;
  cin >> n;
  vector<int> A(n);
  for(int i = 0;i < n;i++){
    cin >> A[i];
  }

  // Simplest solution - passes all tests.
  for(int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++ ) {
      if (A[j] == A[i]) {
        if (minimumDistance == -1 || (j - i  < minimumDistance)) {
          minimumDistance = j - i;
        }
      }
    }
  }
  cout << minimumDistance << endl;

  return 0;
}
