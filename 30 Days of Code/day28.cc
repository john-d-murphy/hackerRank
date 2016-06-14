#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <regex>

using namespace std;
/*
Objective
Today, we're working with regular expressions. Check out the Tutorial tab for learning materials and an instructional video!

Task
Consider a database table, Emails, which has the attributes First Name and Email ID. Given N rows of data simulating the Emails
table, print an alphabetically-ordered list of people whose email address ends in @gmail.com

Input Format
The first line contains an integer,N, total number of rows in the table.
Each of the N subsequent lines contains 2 space-separated strings denoting a person's first name and email ID, respectively.

Constraints
2 <= N <= 30
Each of the first names consists of lower case letters [a-z] only.
Each of the email IDs consists of lower case letters [a-z], @ and . only.
The length of the first name is no longer than 20.
The length of the email ID is no longer than 50.

Output Format

Print an alphabetically-ordered list of first names for every user with a gmail account. Each name must be printed on a new line.

Sample Input
6
riya riya@gmail.com
julia julia@julia.me
julia sjulia@gmail.com
julia julia@gmail.com
samantha samantha@gmail.com
tanya tanya@gmail.com

Sample Output
julia
julia
riya
samantha
tanya
*/

int main() {
  
  int testCases;
  vector<string> matchedUsers;
  regex gmail(".*\\@gmail\\.com$");
  cin >> testCases;

  // Get values
  for(int i = 0; i < testCases; i++) {
    string firstName;
    string emailID;
    cin >> firstName >> emailID;
    if (regex_match(emailID,gmail)) {
      matchedUsers.push_back(firstName);
    }
  }
  // Sort values
  sort(matchedUsers.begin(),matchedUsers.end());

  // Output values
  for (int i = 0; i < matchedUsers.size(); i++) {
    cout << matchedUsers[i] << endl;
  }
}
