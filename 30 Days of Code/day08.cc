#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

/*
Objective
Today, we're learning about Key-Value pair mappings using a Map or Dictionary data structure.
Check out the Tutorial tab for learning materials and an instructional video!

Task
Given N names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers.
You will then be given an unknown number of names to query your phone book for; for each queried, print the associated
entry from your phone book (in the form name=phonenumber) or Not found if there is no entry for name.

Note: Your phone book should be a Dictionary/Map/HashMap data structure.

Input Format

The first line contains an integer,N, denoting the number of entries in the phone book.
Each of the N subsequent lines describes an entry in the form of 2 space-separated values on a single line.
The first value is a friend's name, and the second value is an 8-digit phonenumber.

After the N lines of phone book entries, there are an unknown number of lines of queries.
Each line (query) contains a name to look up, and you must continue reading lines until there is no more input.

Note: Names consist of lowercase English letters and are first names only.

Constraints
1 <= N <= 10^5
1 <= queries <= 10^5

Output Format

On a new line for each query, print "Not found" if the name has no corresponding entry in the phone book;
otherwise, print the full name and phoneNumber in the format name=phoneNumber.

Sample Input
3
sam 99912222
tom 11122222
harry 12299933
sam
edward
harry
Sample Output

sam=99912222
Not found
harry=12299933
*/

int main() {
  int n;
  cin >> n;
  string lookupName;
  string notFound;
  notFound = "Not found";
  map<string,string> addressBook;
  for (int i = 0 ; i < n; i++) {
    string name;
    string phoneNumber;
    cin >> name >> phoneNumber;
    addressBook[name] = phoneNumber;
  }
  while(cin >> lookupName) {
    if (addressBook.count(lookupName) > 0) {
      cout << lookupName << "=" << addressBook[lookupName] << endl;
    } else {
      cout << notFound << endl;
    }
  }
}
