#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
Objective
Today, we're working with binary numbers.
Check out the Tutorial tab for learning materials and an instructional video!

Task
Given a base-10 integer,n, convert it to binary (base-2).
Then find and print the base-10 integer denoting the maximum number of consecutive 1's in n's binary
representation.

Input Format

A single integer, .

Constraints

Output Format

Print a single base- integer denoting the maximum number of consecutive 's in the binary representation of .

Sample Input 1
5

Sample Output 1
1

Sample Input 2
13
Sample Output 2
2
*/

int main(){
    int n;
    cin >> n;
    int numberOfDigits;
    int maxConsecutiveOnes = 0;
    int currentNumberOfOnes = 0;
    int currentDigit = 0;
    int previousDigit = 0;
    // Not using any libraries here - having some fun.
    // n.b. that this returns the binary number in reverse
    // order, but that's ok for the purposes of this problem.
    while (n > 0) {
      currentDigit = n % 2;
      if (currentDigit == 1) {
        currentNumberOfOnes++;
      } else {
        currentNumberOfOnes = 0;
      }
      if (currentNumberOfOnes > maxConsecutiveOnes) {
        maxConsecutiveOnes = currentNumberOfOnes;
      }
      n = n/2;
    }
    cout << maxConsecutiveOnes << endl;
}
