#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
A jail has N prisoners, and each prisoner has a unique id number,S, ranging from 1 to N.
There are M sweets that must be distributed to the prisoners.

The jailer decides the fairest way to do this is by sitting the prisoners down in a
circle (ordered by ascending S), and then, starting with some random S, distribute one candy at a time
to each sequentially numbered prisoner until all M candies are distributed.
For example, if the jailer picks prisoner S=2, then his distribution order would be (2,3,4,5 .. n-1,n,1,2,3..)
until all M sweets are distributed.

But wait—there's a catch — the very last sweet is poisoned! Can you find and print the ID number of the last
prisoner to receive a sweet so he can be warned?

Input Format

The first line contains an integer,T, denoting the number of test cases.
The T subsequent lines each contain 3 space-separated integers:
M (the number of prisoners), M (the number of sweets), and S (the prisoner ID), respectively.

Constraints
1 <= T <= 100
1 <= N <= 10^9
1 <= M <= 10^9
1 <= S <= 10^9

Output Format
For each test case, print the ID number of the prisoner who receives the poisoned sweet on a new line.

Sample Input

1
5 2 1
Sample Output

2
*/

int main() {
  int testCases;
  cin >> testCases;
  for (int i = 0; i < testCases ; i++) {
    long prisoners;
    long sweets;
    long startingPrisoner;
    cin >> prisoners >> sweets >> startingPrisoner;
    // Poison Offset subtracts 1 because our first prisoner will eat a sweet.
    int poisonOffset = (sweets % prisoners) - 1;
    int prisonerToWarn = (startingPrisoner + poisonOffset) % prisoners;
    // If are to warn prisoner 0, this means we are warning the last prisoner
    // (due to the offset we put in earlier)
    if (prisonerToWarn == 0) {
        prisonerToWarn = prisoners;
    }

    cout << prisonerToWarn << endl;
  }
  return 0;
}
