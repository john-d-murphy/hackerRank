#include <iostream>
#include <cmath>
#include <math.h>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

/*
Objective
In this challenge, we review some basic concepts that will get you started with this series.
Check out the Tutorial tab for learning materials and an instructional video!

Task
To complete this challenge, you must save a line of input from stdin to a variable, print "hello world"
on a single line, and finally print the value of your variable on a second line.

You've got this!

Note: The instructions are Java-based, but we support submissions in many popular languages. You can
switch languages using the drop-down menu above your editor.

Input Format

A single line of text denoting  (the variable whose contents must be printed).

Output Format

Print  on the first line, and the contents of  on the second line.

Sample Input

Welcome to 30 Days of Code!
Sample Output

Hello, World.
Welcome to 30 Days of Code!
*/

int main()
{
  string input;
  getline(cin, input);
  cout << "Hello, World." << endl;
  cout << input << endl;
}
