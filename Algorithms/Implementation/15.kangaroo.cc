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
There are two kangaroos on an x-axis ready to jump in the positive direction (i.e, toward positive infinity).
The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump. The second kangaroo starts at
location x2 and moves at a rate of x2 meters per jump. Given the starting locations and movement rates for each
kangaroo, can you determine if they'll ever land at the same location at the same time?

Input Format
A single line of four space-separated integers denoting the respective values of x1, v1, x2, and v2.

Constraints
* 0 <= x1 < x2 <= 10000
* 1 <= v1 <= 10000
* 1 <= v2 <= 10000

Output Format
Print YES if they can land on the same location at the same time; otherwise, print NO.

Note: The two kangaroos must land at the same location after making the same number of jumps.

Sample Input 0

0 3 4 2
Sample Output 0

YES

Thus, the kangaroos meet after  jumps and we print YES.

Sample Input 1
0 2 5 3
Sample Output 1
NO

The second kangaroo has a starting location that is ahead (further to the right) of the first kangaroo's
starting location (e.g., x2 > x1). Because the second kangaroo moves at a faster rate (meaning v2 > v1) and is already
ahead of the first kangaroo, the first kangaroo will never be able to catch up. Thus, we print NO.
*/

int main() {
  int x1;
  int v1;
  int x2;
  int v2;
  cin >> x1 >> v1 >> x2 >> v2;
  if (v2 >= v1) {
    cout << "NO";
  } else {
    // Let's be lazy and just increment
    while(x1 < x2) {
      x1 += v1;
      x2 += v2;
    }
    // Did we travel the same distance ?
    if (x1 == x2) {
      cout << "YES";
    } else {
      cout << "NO";
    }
  }
  return 0;
}
