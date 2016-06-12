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
Today, we're discussing a simple sorting algorithm called Bubble Sort.
Check out the Tutorial tab for learning materials and an instructional video!

Consider the following version of Bubble Sort:

for (int i = 0; i < n; i++) {
    int numberOfSwaps = 0;

    for (int j = 0; j < n - 1; j++) {
        if (a[j] > a[j + 1]) {
            swap(a[j], a[j + 1]);
            numberOfSwaps++;
        }
    }

    if (numberOfSwaps == 0) {
        break;
    }
}
Task
Given an array,a, of size n containing distinct elements a[0],a[1] ... a[n], sort array a in ascending order
using the Bubble Sort algorithm above. Once sorted, print the following 3 lines:

1. Array is sorted in 'numSwaps' swaps
where numswaps is the number of swaps that took place.

2. First Element: firstElement
where firstElement is the first element in the sorted array

3. Last Element: lastElement
where lastElement is the last element in the sorted array

Hint: To complete this challenge, you will need to add a variable that keeps a
running tally of all swaps that occur during execution.

Input Format

The first line contains an integer,n, denoting the number of elements in array a.
The second line contains n space-separated integers describing a, where the ith integer is,
a[i] for all i in [0, n-1].

Constraints
2 <= n <= 600
1 <= a[i] <= 2x10^6, for all i in [0, n-1]

Output format:
there should be three lines of output
1. Array is sorted in 'numSwaps' swaps
where numswaps is the number of swaps that took place.

2. First Element: firstElement
where firstElement is the first element in the sorted array

3. Last Element: lastElement
where lastElement is the last element in the sorted array

Sample Input 0

3
1 2 3
Sample Output 0

Array is sorted in 0 swaps.
First Element: 1
Last Element: 3
Sample Input 1

3
3 2 1
Sample Output 1

Array is sorted in 3 swaps.
First Element: 1
Last Element: 3
*/


int main() {
  int n;
  int totalSwaps;
  cin >> n;
  vector<int> a(n);
  for(int i = 0; i < n;i++) {
    cin >> a[i];
  }

  for (int i = 0; i < n; i++) {
    int numberOfSwaps = 0;

    for (int j = 0; j < n - 1; j++) {
      if (a[j] > a[j + 1]) {
        swap(a[j], a[j + 1]);
        numberOfSwaps++;
        totalSwaps++;
      }
    }

    if (numberOfSwaps == 0) {
      break;
    }
  }

  cout << "Array is sorted in " << totalSwaps << " swaps." << endl;
  cout << "First Element: " << a[0] << endl;
  cout << "Last Element: " << a[n-1] << endl;

  return 0;
}
