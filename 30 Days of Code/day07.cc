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
Objective
Today, we're learning about the Array data structure.
Check out the Tutorial tab for learning materials and an instructional video!

Task
Given an array,A, of N integers, print A's elements in reverse order as a single line of space-separated numbers.

Input Format

The first line contains an integer, N (the size of our array).
The second line contains N space-separated integers describing array A's elements.

Constraints
1 <= N <= 1000
1 <= Ai <= 10000 where Ai is the ith integer in the array.

Output Format

Print the elements of array A in reverse order as a single line of space-separated numbers.

Sample Input

4
1 4 3 2
Sample Output

2 3 4 1 */

int main() {
  int n;
  cin >> n;
  vector<int> arr(n);

  for(int arr_i = 0;arr_i < n;arr_i++) {
    cin >> arr[arr_i];
  }
  for (int arr_i = arr.size()-1; arr_i >= 0; arr_i--) {
    cout << arr[arr_i] << " ";
  }

  cout <<  endl;
  return 0;
}
