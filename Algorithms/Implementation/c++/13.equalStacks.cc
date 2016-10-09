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
You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height.
You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height.
This means you must remove zero or more cylinders from the top of zero or more of the three stacks until
they're all the same height, then print the height. The removals must be performed in in such a way as to
maximize the height.

Note: An empty stack is still a stack.

Input Format

The first line contains three space-separated integers, n1, n2, and n3, describing the respective number of
cylinders in stacks 1, 2, and 3. The subsequent lines describe the respective heights of each cylinder in a stack
from top to bottom:

* The second line contains n1 space-separated integers describing the cylinder heights in stack 1.
* The third line contains n2 space-separated integers describing the cylinder heights in stack 2.
* The fourth line contains n3 space-separated integers describing the cylinder heights in stack 3.

Constraints
0 <= n1,n2,n3 <= 10^5
0 < height of any cylinder <= 100

Output Format

Print a single integer denoting the maximum height at which all stacks will be of equal height.

Sample Input
5 3 4
3 2 1 1 1
4 3 2
1 1 4 1

Sample Output
5
*/

// Create stack with smallest value in the front
deque<long> makeStack(int numEntries) {
  deque<long> stack;
  for(int i = 0; i < numEntries; i++){
    int value;
    cin >> value;
    stack.push_front(value);
  }
  return stack;
}

// Create stack with the largest value at the front
deque<long> makeSumStack(deque<long> stack) {
  deque<long> sumStack;
  sumStack.push_back(stack[0]);
  for(int i = 1; i < stack.size(); i++){
    int value = sumStack[0] + stack[i];
    sumStack.push_front(value);
  }
  return sumStack;
}

int main(){
  int n1;
  int n2;
  int n3;
  cin >> n1 >> n2 >> n3;

  // Get Stacks
  deque<long> stack1 = makeStack(n1);
  deque<long> stack2 = makeStack(n2);
  deque<long> stack3 = makeStack(n3);

  // Sum Stacks
  deque<long> sum1 = makeSumStack(stack1);
  deque<long> sum2 = makeSumStack(stack2);
  deque<long> sum3 = makeSumStack(stack3);

  // Find max height
  long maxHeight = 0;
  long lastSum2 = 0;
  long lastSum3 = 0;

  // Since we start from the largest item in the stack,
  // as soon as we find a value that's equal, we know
  // we've found the largest and can leave the loop.

  // Additionally, we don't need to re-check values from
  // the start in sum2 and sum3 after we've already checked,
  // we can start from where we left off. This will reduce the
  // complexity to O(n1+n2+n3) instead of O(n1*n2*n3);
  for( int i = 0; i < sum1.size(); i++) {
    int testValue = sum1[i];
    for( int j = lastSum2; sum2[j] >= testValue; j++) {
      lastSum2 = j;
      for( int k = lastSum3; sum3[k] >= testValue; k++) {
        lastSum3 = k;
        if (sum2[j] == sum3[k] && sum2[j] == testValue) {
          maxHeight = testValue;
          goto finish;
        }
      }
    }
  }

  finish:
  cout << maxHeight << endl;
}
