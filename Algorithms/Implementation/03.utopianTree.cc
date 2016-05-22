#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
The Utopian Tree goes through 2 cycles of growth every year.
Each spring, it doubles in height.
Each summer, its height increases by 1 meter.

Laura plants a Utopian Tree sapling with a height of 1 meter at the onset of spring.
How tall will her tree be after N growth cycles?

Input Format

The first line contains an integer,T, the number of test cases.
T subsequent lines each contain an integer,N, denoting the number of cycles for that test case.

Constraints
1 <= T <= 10
0 <= N <= 60

Output Format

For each test case, print the height of the Utopian Tree after N cycles.
Each height must be printed on a new line.

Sample Input
3
0
1
4
Sample Output
1
2
7
*/
int main() {
  int testCases;
  cin >> testCases;
  for(int testCase = 0; testCase < testCases; testCase++){
    int growthCycles;
    long long height = 1;
    cin >> growthCycles;
    for (int i = 1 ; i <= growthCycles; i++) {
       // Spring then summer. Problem statement is unclear.
       if (i % 2 != 0) {
          height *= 2;
       } else {
          height++;
       }
    }
    cout << height << endl;
  }
}
