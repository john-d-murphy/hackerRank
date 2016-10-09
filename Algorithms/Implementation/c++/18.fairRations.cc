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
You are the benevolent ruler of Rankhacker Castle, and today you're distributing bread to a straight line of N subjects.
Each ith subject (where 1 <= i <= N) already has Bi loaves of bread.

Times are hard and your castle's food stocks are dwindling, so you must distribute as few loaves as possible according
to the following rules:

1)  Every time you give a loaf of bread to some person , you must also give a loaf of bread to the person immediately
    in front of or behind them in the line (i.e., persons i+1 or i-1).

2)  After all the bread is distributed, each person must have an even number of loaves.

Given the number of loaves already held by each citizen, find and print the minimum number of loaves you must distribute
to satisfy the two rules above. If this is not possible, print NO.


Input Format

The first line contains an integer,N, denoting the number of subjects in the bread line.
The second line contains N space-separated integers describing the respective loaves of bread
already possessed by each person in the line (i.e.,B1,B2 ... BN).

Constraints
* 2 <= N <= 1000
* 1 <= Bi <= 10, where 1 <= i <= N

Output Format

Print a single integer denoting the minimum number of loaves you must distribute to adjacent people in the line so that every
person has an even number of loaves; if it's not possible to do this, print NO.

Sample Input 0

5
2 3 4 5 6
Sample Output 0

4
Sample Input 1

2
1 2
Sample Output 1

NO
*/

bool isOdd(int i) {
  return ( i % 2 != 0);
}

int findNextOdd(vector<int> v, int i ) {
  for (int j = i+1; j < v.size(); j++) {
    if (isOdd(v[j])) {
      return j;
    }
  }
  return -1;
}


int main(){
  int N;
  int value;
  int count = 0;
  cin >> N;
  vector<int> B;
  for(int i = 0; i < N; i++){
    cin >> value;
    B.push_back(value);
  }

  for (int i = 0; i < B.size(); i++) {
    if (isOdd(B[i])) {
      int nextOdd = findNextOdd(B,i);
      if (nextOdd == -1) {
        cout << "NO" ;
        return 0;
      }
      count += (nextOdd - i) * 2;
      B[i] = 2;
      B[nextOdd] = 2;
    }

  }

  cout << count;

  return 0;
}
