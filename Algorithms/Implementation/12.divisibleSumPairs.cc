#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
using namespace std;


/*
You are given an array of n integers, a0,a1 .. an-1, and a positive integer, k.
Find and print the number of pairs where i < j  and  ai + aj is evenly divisible by k.

Input Format

The first line contains 2 space-separated integers, n and k, respectively.
The second line contains n space-separated integers describing the respective values of a0,a1 .. an-1.

Constraints

2 <= n <= 100
1 <= k <= 100
1 <= ai <= 100

Output Format

Print the number of (i,j) pairs where i < j and i + j  is evenly divisible by k.

Sample Input
6 3
1 3 2 6 1 2

Sample Output
5
*/


int main() {

  // Get Data
  int n;
  int k;
  cin >> n >> k;
  vector<int> a(n);
  for(int i = 0; i < n; i++) {
    cin >> a[i];
  }

  // Calculate divisible pairs
  int numberOfDivisblePairs = 0;

  for(int i = 0; i < n; i++) {
    for(int j = i + 1; j < n; j++) {
      int sum = a[i] + a[j];
      if (sum % k == 0) {
        numberOfDivisblePairs++;
      }
    }
  }
  cout << numberOfDivisblePairs << endl;

  return 0;
}
