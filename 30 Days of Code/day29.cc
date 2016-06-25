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
Objective
Welcome to the last day! Today, we're discussing bitwise operations.
Check out the Tutorial tab for learning materials and an instructional video!

Task
Given set S={1,2,3, ..., N}. Find two integers, A and B (where A < B), from set S such that the
value of A&B is the maximum possible and also less than a given integer, K. In this case, & represents the
bitwise AND operator.

Input Format

The first line contains an integer,T, the number of test cases.
Each of the T subsequent lines defines a test case as 2 space-separated integers, N and K, respectively.

Constraints
1 <= T <= 10^3
2 <= N <= 10^3
2 <= K <= N

Output Format

For each test case, print the maximum possible value of A&B on a new line.

Sample Input

3
5 2
8 5
2 2
Sample Output

1
4
0
*/

int main(){
  int t;
  cin >> t;
  for(int testCase = 0; testCase < t; testCase++){
    int n;
    int k;
    cin >> n >> k;
    int max = 0;
    for (int i = 1; i < n; i++) {
      for(int j = i + 1; j <= n; j++) {
        int testValue = i & j;
        if (testValue > max && testValue < k) {
          max = testValue;
        }
      }
    }
    cout << max << endl;
  }
  return 0;
}
