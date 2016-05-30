#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

/*
Objective
Today we're discussing scope.
Check out the Tutorial tab for learning materials and an instructional video!

The absolute difference between two integers, a and b, is written as |a-b|.
The maximum absolute difference between two integers in a set of positive integers,elements, is the largest
absolute difference between any two integers in elements.

The Difference class is started for you in the editor.
It has a private integer array (elements) for storing N non-negative integers,
and a public integer (maxDifference) for storing the maximum absolute difference.

Task
Complete the Difference class by writing the following:

A class constructor that takes an array of integers as a parameter and saves it to the elements instance variable.
A computeDifference method that finds the maximum absolute difference between any 2 numbers in N and stores it in
the maxDifference instance variable.

Input Format
You are not responsible for reading any input from stdin.
The locked Solution class in your editor reads in 2 lines of input;
the first line contains N, and the second line describes the elements array.

Constraints
1 <= N <= 10
1 <= elements[i] <= 100, where 0 <= i <= N-1

Output Format

You are not responsible for printing any output; the Solution class will print the value of the instance variable.

Sample Input

3
1 2 5
Sample Output

4
*/

class Difference {
private:
  vector<int> elements;

public:
  int maximumDifference;
  Difference(vector<int> newElements) {
    elements = newElements;
    sort(elements.begin(),elements.end());
  }

  void computeDifference() {
    maximumDifference = elements[elements.size()-1] - elements[0];
  }

};

int main() {
  int N;
  cin >> N;

  vector<int> a;

  for (int i = 0; i < N; i++) {
    int e;
    cin >> e;

    a.push_back(e);
  }

  Difference d(a);

  d.computeDifference();

  cout << d.maximumDifference;

  return 0;
}
