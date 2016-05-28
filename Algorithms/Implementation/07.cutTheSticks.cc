#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
#include <list>
using namespace std;

/*
You are given N sticks, where the length of each stick is a positive integer.
A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.

Suppose we have six sticks of the following lengths:
5 4 4 2 2 8

Then, in one cut operation we make a cut of length 2 from each of the six sticks.
For the next cut operation four sticks are left (of non-zero length), whose lengths are the following:
3 2 2 6

The above step is repeated until no sticks are left.

Given the length of N sticks, print the number of sticks that are left before each subsequent cut operations.

Note: For each cut operation, you have to recalcuate the length of smallest sticks (excluding zero-length sticks).

Input Format
The first line contains a single integer N.
The next line contains  integers: a0, a1,...aN-1 separated by space, where ai represents the length of ith stick.

Output Format
For each operation, print the number of sticks that are cut, on separate lines.

Constraints
1 ≤ N ≤ 1000
1 ≤ ai ≤ 1000

Sample Input #00
6
5 4 4 2 2 8
Sample Output #00
6
4
2
1
Sample Input #01
8
1 2 3 4 3 3 2 1
Sample Output #01
8
6
4
1
*/

int main() {
  int numberOfSticks;
  int runningSum = 0;
  int numberOfRounds;
  cin >> numberOfSticks;
  map<int,int> sticks;
  list<int> totalAfterRound;
  // This game is phrased in a weird way.
  // Basically, every pass, we get rid of the sticks
  // with the lowest value, so if we get the number of sticks
  // for each value and then group them in order, we'll know
  // with O(1) how many are left after each pass.

  // Group the sticks
  for(int i = 0; i < numberOfSticks; i++) {
    int length;
    cin >> length;
    sticks[length]++;
  }
  int currentRound;
  currentRound = sticks.size();

  // iterate through the list from smallest to largest to get cumulative # of sticks per turn
  for(map<int,int>::reverse_iterator iter=sticks.rbegin(); iter != sticks.rend(); ++iter ) {
    runningSum += (*iter).second;
    totalAfterRound.push_front(runningSum);
  }

  // iterate through the new list to print out the number of sticks after each turn
  for (list<int>::iterator it=totalAfterRound.begin(); it!=totalAfterRound.end(); ++it) {
    std::cout << *it << endl;
  }

}
