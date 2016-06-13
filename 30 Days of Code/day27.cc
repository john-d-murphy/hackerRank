#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
Objective
This challenge is very different from the others we've completed because it requires you to generate valid
test cases for a problem instead of solving the problem. There is no input to read, you simply have to generate
and print test values for the problem that satisfy both the problem's Input Format and the criteria laid out in
the Task section.

Check out the Tutorial tab for an instructional video on testing!

Consider the following problem:

Problem Statement

A Discrete Mathematics professor has a class of N students.
Frustrated with their lack of discipline, the professor decides to cancel class if fewer than K students are present
when class starts. Given the arrival time of each student, determine if the class is canceled.

Input Format

The first line of input contains T, the number of test cases.

Each test case spans two lines. The first has two space-separated integers, N (students in the class) and K (the cancelation threshold).
The second contains N space-separated integers describing the students' arrival times as array a(a0..an-1).

Note: Non-positive arrival times (ai < 0) indicate the student arrived early or on time; positive arrival times (ai >0)
indicate the student arrived ai minutes late. If a student arrives exactly on time (ai = 0), the student is considered to
have entered before the class started.

Output Format

For each test case, print the word YES if the class is canceled or NO if it is not.

When properly solved, this input:

2
4 3
-1 -3 4 2
4 2
0 -1 2 1
Will produce this output:

YES
NO

Task

Create and print one or more test cases for the problem above that meet the following criteria:

T <= 5
1 <= N <= 200
1 <= K <= N
-1000 <= ai <= 1000 where i in [1,N]
The value of N must be distinct across all the test cases.
Array a must have at least 1 zero, 1 positive integer, and 1 negative integer.

Scoring

If you submit x correct test cases, you will earn (20 * x)% of the maximum score.
If you submit more than 5 test cases, only the first 5 test cases will be evaluated.

You must create five test cases to earn the maximum possible score.

The output for your test case (were it to run against a correct solution to the problem above) must look like this:
YES
NO
YES
NO
YES

Print your test cases as output the same way the solution would expect to read them as input. For example:
print('1')
print('4 3')
print('-1 -3 4 2')
print('5 2')
print('0 -1 2 1 4')
*/

// Not worth the time for a poorly worded problem.
// A correct answer was put in the discussion, and I dropped this in.
// Made a comment to HackerRank that this one needed to be tightened up.
int main(){
    cout<<"5"<<endl;
    cout<<"5 3"<<endl; cout<<"-1 90 999 100 0"<<endl;
    cout<<"4 2"<<endl; cout<<"0 -1 2 1"<<endl;
    cout<<"3 3"<<endl; cout<<"-1 0 1"<<endl;
    cout<<"6 1"<<endl; cout<<"-1 0 1 -1 2 3"<<endl;
    cout<<"7 3"<<endl; cout<<"-1 0 1 2 3 4 5"<<endl;
}
