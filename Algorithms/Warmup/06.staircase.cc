#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
Your teacher has given you the task of drawing a staircase structure.
Being an expert programmer, you decided to make a program to draw it for you instead.
Given the required height, can you print a staircase as shown in the example?

Input
You are given an integer N depicting the height of the staircase.

Output
Print a staircase of height N that consists of # symbols and spaces.
For example for N=6, here's a staircase of that height:

     #
    ##
   ###
  ####
 #####
######
Note: The last line has 0 spaces before it.
*/

int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n ; i++) {
      // Spaces
      for (int space = 1 ; space <= n-i ; space++) {
        cout << " ";
      }
      // Hashes
      for (int hash = 1; hash <= i; hash++) {
        cout << "#";
      }
      cout << endl;
    }
    return 0;
}
