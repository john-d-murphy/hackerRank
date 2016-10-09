#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*

Sherlock Holmes suspects his archenemy, Professor Moriarty, is once again plotting something diabolical.
Sherlock's companion, Dr. Watson, suggests Moriarty may be responsible for MI6's recent issues with their
supercomputer, The Beast.

Shortly after resolving to investigate, Sherlock receives a note from Moriarty boasting about infecting
The Beast with a virus; however, he also gives him a clue—a number, N. Sherlock determines the key to removing the
virus is to find the largest Decent Number having N digits.

A Decent Number has the following properties:

Its digits can only be 3's and/or 5's.
The number of 3's it contains is divisible by 5.
The number of 5's it contains is divisible by 3.
If there are more than one such number, we pick the largest one.
Moriarty's virus shows a clock counting down to The Beast's destruction, and time is running out fast.
Your task is to help Sherlock find the key before The Beast is destroyed!

Constraints
1 <= T <= 20
1 <= N <= 100000

Input Format

The first line is an integer,T, denoting the number of test cases.

The T subsequent lines each contain an integer,N, detailing the number of digits in the number.

Output Format

Print the largest Decent Number having N digits; if no such number exists, tell Sherlock by printing -1.

Sample Input

4
1
3
5
11
Sample Output

-1
555
33333
55555533333
--------------------
This one is suuuuuuuper annoying because of how you have to think about the threes and the fives.
First you have to figure out how many multiples of three fit in the number of digits, and if the
difference of that multiple of three and the number of digits is a multiple of five, then you have
a valid number. If you have a maximum multiple of three, that's your answer.

The confusion is that the multiple of three needs to be printed out as a 5.

I've left the comments in so that it's possible to print out the states and see where the values end up.
*/

int maxMultipleOfThree(int numberOfDigits) {
  int maxMultiple = numberOfDigits/3;
  int multipleOfThrees = 0;
  //cout << "Number of Digits: "<< numberOfDigits << endl;
  //cout << "Max Multiple of Three: " << maxMultiple << endl;
  for (int i = 0; i <= maxMultiple; i++) {
    int potentialThree = i * 3;
    int potentialFive = numberOfDigits - potentialThree;

    /*
    cout << " Using Multiple: "  << i << \
            " Potential Five: "  << potentialFive << \
            " Potential Three: " << potentialThree << endl;
    */
    if( potentialFive % 5 == 0) {
       multipleOfThrees = i;
       //cout << "setting multiple of threes to " << i << endl;
    }
  }
  //cout << "Maximum Mutiple of Threes: " << multipleOfThrees << endl;
  //cout << "Using Number of Threes: " << multipleOfThrees * 3 << endl;
  return multipleOfThrees * 3;
}

int main() {
  int testCases;
  cin >> testCases;
  for(int testCase = 0; testCase < testCases; testCase++){
    int numberOfDigits;
    cin >> numberOfDigits;
    string largestDecentNumber;
    int numberOfThrees = maxMultipleOfThree(numberOfDigits);
    int remainingDigits = numberOfDigits - numberOfThrees;
    //cout << "Remaining Digits: " << remainingDigits << endl;
    if (remainingDigits % 5 != 0 ) {
      cout << "-1";
    } else {
      for (int i = 0; i < numberOfThrees; i++) {
        cout << "5";
      }
      for (int i = 0; i < remainingDigits; i++) {
        cout << "3";
      }
    }
    cout << endl;
  }
  return 0;
}
