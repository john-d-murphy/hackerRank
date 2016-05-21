#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
Objective
In this challenge, you'll work with arithmetic operators.
Check out the Tutorial tab for learning materials and an instructional video!

Task
Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip),
and tax percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost.

Note: Be sure to use precise values for your calculations, or you may end up with an incorrectly rounded result!

Input Format

There are 3 lines of numeric input:
The first line has a double,  mealCost (the cost of the meal before tax and tip).
The second line has an integer,  tipPercent (the percentage of mealCost being added as tip).
The third line has an integer, taxPercent (the percentage of mealCost being added as tax).

Output Format

Print totalMealCost , where totalMealCost is the rounded integer result of the entire bill
(mealCost with added tax and tip).

Sample Input
12.00
20
8
Sample Output

The total meal cost is 15 dollars.
Explanation

We round totalCost to the nearest dollar (integer) and then print our result:

The total meal cost is 15 dollars.*/

int main() {
  double mealCost;
  double tipPercent;
  double taxPercent;

  cin >> mealCost;
  cin >> tipPercent;
  cin >> taxPercent;

  double tipValue = (tipPercent/100) * mealCost;
  double taxValue = (taxPercent/100) * mealCost;
  int totalCost = round(tipValue + taxValue + mealCost);

  cout << "The total meal cost is " << totalCost << " dollars." << endl;

  return 0;
}
