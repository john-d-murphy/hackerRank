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
It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!

There are n people queued up, and each person wears a sticker indicating their initial
position in the queue (i.e.:  1, 2, n, n-1 with the first number denoting the frontmost position.)

Any person in the queue can bribe the person directly in front of them to swap positions.
If two people swap positions, they still wear the same sticker denoting their original place in line.
One person can bribe at most two other persons.

That is to say, if n=8 and Person 5 bribes Person 4, the queue will look like this: 1,2,3,5,4,6,7,8.

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that
took place to get the queue into its current state!

Note: Each Person X wears sticker X, meaning they were initially the Xth person in queue.

Input Format

The first line contains an integer, T, denoting the number of test cases.
Each test case is comprised of two lines; the first line has n (an integer indicating the number of people
in the queue), and the second line has n space-separated integers describing the final state of the queue.

Constraints
1 <= T <= 10
1 <= n <= 10^5

Subtasks
For 60% score - 1 <= n <= 10^3
For 100% score - 1 <= n <= 10^5

Output Format

Print an integer denoting the minimum number of bribes needed to get the queue into its final state;
print Too chaotic if the state is invalid (requires Person X to bribe more than 2 people).

Sample Input

2
5
2 1 5 3 4
5
2 5 1 3 4
Sample Output

3
Too chaotic
*/


int main() {
  int testCases;
  cin >> testCases;
  for(int i = 0; i < testCases; i++){
    // Variables
    int n;
    int numberOfBribes = 0;
    vector<int> queue;
    int swapCount = 0;
    int tooChaotic = false;

    // Populate Queue
    // We can determine if this is too chaotic
    // as we're iterating over the initial list.
    // There's no reason to iterate over the list again if we know
    // we're not going to find a solution.
    cin >> n;
    for(int j = 0; j < n; j++) {
      // Queue is indexed by 1, vector by 0
      int queuePosition = j + 1 ;
      int value;
      cin >> value;
      if (value - queuePosition > 2) {
        tooChaotic = true;
      } else {
        queue.push_back(value);
      }
    }

    // Find number of permutations in the list
    if (tooChaotic) {
      cout << "Too chaotic" << endl;
    } else {
      for (int j = queue.size() - 1; j >= 0; j--) {
        // We know that the number that can offset this number is
        // at most two to the left of it, so if we use that shift
        // and check, we'll get our correct answer.
        int currentValue = queue[j];
        int maximumEntryThatCanOffset = max(0, currentValue - 2);
        for(int k = maximumEntryThatCanOffset; k < j ; k++) {
          if (queue[k] > currentValue) {
            numberOfBribes++;
          }
        }
      }
      cout << numberOfBribes << endl;
    }

  }
  return 0;
}
