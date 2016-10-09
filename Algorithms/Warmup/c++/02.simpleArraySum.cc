#include <iostream>
#include <cmath>
#include <math.h>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

/*
Given an array of N integers, can you find the sum of its elements?

Input Format

The first line contains an integer, N, denoting the size of the array.
The second line contains N space-separated integers representing the array's elements.

Output Format

Print the sum of the array's elements as a single integer.

Sample Input

6
1 2 3 4 10 11
Sample Output
31
Explanation

We print the sum of the array's elements, which is: 1 + 2 + 3 + 4 + 10 + 11 = 31.

Submissions: 158950
Max Score: 10
Difficulty: Easy
*/

int main()
{
    int numberOfElements;
    int sum = 0;
    cin >> numberOfElements;
    for(int i = 0; i < numberOfElements; i++)
    {
       int currentVal;
       cin >> currentVal;
       sum += currentVal;
    }
    cout << sum << endl;
}
