#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
Given a time in AM/PM format, convert it to military (-hour) time.

Note: Midnight is 12:00:00 AM on a 12-hour clock, and 00:00:00 on a 24-hour clock.
Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 12-hour clock.

Input Format

A single string containing a time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM ),
where 01 <= hh <= 12.

Output Format

Convert and print the given time in 24-hour format, where 00 <= hh <=23.

Sample Input

07:05:45PM
Sample Output

19:05:45
*/

int main() {
  string inputTime;
  string AM = "AM";
  string PM = "PM";
  cin >> inputTime;
  int hours = stoi(inputTime.substr(0,2));
  string minutes = inputTime.substr(3,2);
  string seconds = inputTime.substr(6,2);
  string AMorPM  = inputTime.substr(8,2);

  // Special cases
  if (AM.compare(AMorPM) == 0 && hours == 12) {
    hours = 0;
  } else if (PM.compare(AMorPM) == 0 && hours != 12) {
    hours += 12;
  }

  // Just print a leading zero if needed
  if (hours < 10) {
    cout << "0";
  }

  cout << hours << ":" << minutes << ":" << seconds ;
}
