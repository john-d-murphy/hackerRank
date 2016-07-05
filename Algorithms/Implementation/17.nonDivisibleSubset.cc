#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

/*
Given a set,S, of n integers, print the size of a maximal subset, S', of S where the sum of any 2
numbers in S' are not evenly divisible by k.

Input Format
The first line contains 2 space-separated integers, n and k, respectively.
The second line contains n space-separated integers (we'll refer to the ith value as ai) describing
the unique values of the set.

Constraints
* 1 <= n <= 10^5
* 1 <= k <= 100
* 1 <= ai <= 10^9

All of the given numbers are distinct.

Output Format
Print the size of the largest possible subset (S').

Sample Input
4 3
1 7 2 4

Sample Output
3

*/

/*
  From the discussion page -
  For any number K, the sum of 2 values (A & B) is evenly divisible by K if the sum of the remainders of A/K + B/K is K.
  (There is also a special case where both A & B are evenly divisible, giving a sum of 0.)
  For any such remainder, there is 1 and only 1 other remainder value which will make a sum divisible by K.
  Example: with K of 5, remainder pairs are 1+4 & 2+3. Given the numbers with a remainder of 1, they can't be paired with ANY
  of the numbers with remainder 4 (and vice versa).
  So, for the number of values in the resultant set, choose the larger of values with remainder 1 vs. values with remainder 4.
  Choose the larger set of remainder 2 vs remainder 3.
  For the special case where remainder is 0, given the set of all values which are individually divisible by K, they can't be paired
  with any others. So, at most 1 value which is evenly divisible by K can be added to the result set.
  For even values of K, the equal remainder is simular to the 0 case. For K = 6, pairs are 1+5, 2+4, 3+3.
  For values with remainder 3, at most one value can be added to the result set.

  In other words -
  Instead of trying to figure out the set number by number, use the property of A + B is divisible by K if A % K + B % K = K and map the
  remainder for each a1,a2 .. ai-1 to 0..K-1.
  Then you are left with an array of size K, which is always going to be <= 100.
  Now that the runtime is reduced, we need to figure out the max of each of the pairs i and k-i and sum those together.
  Two special cases remain:
  * Remainder of zero - if > 0, only add one since we cannot have more than one else the sum will be divisible by k.
  * Even K, K/2 remainder - if > 0, only add one since we cannoy have more than else else the sum will be divisible by k.

*/

int main() {
  // Variables
  int numberOfEntries;
  long k;
  cin >> numberOfEntries >> k;
  vector<long> values;
  map<long,long> divisorCount;
  long max = 0;
  long setSize = 0;

  // Populate Array of Remainders
  for (int i = 0; i < numberOfEntries; i++) {
    long newValue;
    cin >> newValue;
    long remainder = newValue % k;
    divisorCount[remainder]++;
  }

  // Determine the max iterator for the :0
  int iteratorMax = ( k % 2 == 0) ? k / 2 : ( k + 1 ) / 2;
  for(int i = 1; i < iteratorMax; i++) {
    if (divisorCount[i] > divisorCount[k-i]) {
      setSize += divisorCount[i];
    } else {
      setSize += divisorCount[k-i];
    }
  }

  if (divisorCount[0] > 0) {
    setSize++;
  }

  if ( (k % 2 == 0) && (divisorCount[k/2] > 0)) {
    setSize++;
  }

  cout << setSize << endl;

  return 0;
}
