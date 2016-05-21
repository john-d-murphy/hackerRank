#include <iostream>
#include <iomanip>
#include <limits>

/*
Objective
Today, we're discussing data types. Check out the Tutorial tab for learning materials and an instructional video!

Task
Complete the code in the editor below. The variables i, d, and s are already declared and initialized for you.
You must declare 3 variables: one of type int, one of type double, and one of type String.
Then you must read 3 lines of input from stdin and initialize your 3 variables.
Finally, you must use the + operator to perform the following operations:

Print the sum of i  plus your int variable on a new line.
Print the sum of d plus your double variable to a scale of one decimal place on a new line.
Concatenate s with the string you read as input and print the result on a new line.
Note: If you are using a language that doesn't support using + for string concatenation (e.g.: C ),
you can just print one variable immediately following the other on the same line.
The string provided in your editor must be printed first, immediately followed by the string you read as input.

Input Format

The first line contains an integer, i .
The second line contains a double, d.
The third line contains a string, s.

Output Format

Print the sum of both integers on the first line, the sum of both doubles on the second line,
and then the two concatenated strings on the third line.

Sample Input

12
4.0
is the best place to learn and practice coding!
Sample Output

16
8.0
HackerRank is the best place to learn and practice coding!
*/
using namespace std;

int main() {
    int i = 4;
    double d = 4.0;
    string s = "HackerRank ";
    // Declare second integer, double, and String variables.
    int input_i;
    double input_d;
    string input_s;

    // Read and save an integer, double, and String to your variables.
    cin >> input_i;
    cin >> input_d;
    getline(cin, input_s);
    getline(cin, input_s);

    // Print the sum of both integer variables on a new line.
    cout << i + input_i << endl;

    // Print the sum of the double variables on a new line.
    printf("%.1f\n", d + input_d);

    // Concatenate and print the String variables on a new line
    // The 's' variable above should be printed first.
    cout << s << input_s << endl;

    return 0;
}
