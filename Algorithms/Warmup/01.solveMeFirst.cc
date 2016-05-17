#include <iostream>
#include <cmath>
#include <math.h>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

/*
Welcome to HackerRank! The purpose of this challenge is to familiarize you with reading input
from stdin (the standard input stream) and writing output to stdout (the standard output stream)
using our environment.

Review the code provided in the editor below, then complete the solveMeFirst function so that
it returns the sum of two integers read from stdin. Take some time to understand this code so
you're prepared to write it yourself in future challenges.

Select a language below, and start coding!

Input Format

Code that reads input from stdin is provided for you in the editor. There are 2 lines of input,
and each line contains a single integer.

Output Format

Code that prints the sum calculated and returned by solveMeFirst is provided for you in the editor.
*/

int solveMeFirst(int a, int b)
{
  return a + b;
}

int main()
{
  int num1, num2;
  int sum;
  cin>>num1>>num2;
  sum = solveMeFirst(num1,num2);
  cout<<sum;
  return 0;
}
