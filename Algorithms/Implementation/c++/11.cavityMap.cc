#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
You are given a square map of size nxn.
Each cell of the map has a value denoting its depth.
We will call a cell of the map a cavity if and only if this cell is not on the border of the map and
each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).

You need to find all the cavities on the map and depict them with the uppercase character X.

Input Format
The first line contains an integer,n, denoting the size of the map.
Each of the following n lines contains n positive digits without spaces.
Each digit (1-9) denotes the depth of the appropriate area.

Constraints
1 <= n <= 100

Output Format
Output n lines, denoting the resulting map. Each cavity should be replaced with character X.

Sample Input
4
1112
1912
1892
1234

Sample Output
1112
1X12
18X2
1234
*/

int main() {
  int n;
  cin >> n;
  vector<vector<int>> grid(n, vector<int>(n));
  for(int row = 0; row < n; row++) {
    string rowValue;
    cin >> rowValue;
    for(int column = 0; column < rowValue.length(); column++) {
      // C++ : chars are ints, so subtracting '0' will
      // get us to the value we need. Kind of hacky.
      int value = rowValue.at(column) - '0';
      grid[row][column] = value;
    }
  }
  for(int row = 0; row < n; row++) {
    for(int column = 0; column < n; column++) {
      int value = grid[row][column];
      // inner grid
      if (row > 0 && row < n-1 && column > 0 && column < n-1) {
        int up    = grid[row-1][column];
        int down  = grid[row+1][column];
        int right = grid[row][column+1];
        int left  = grid[row][column-1];
        if (value > up && value > down && value > right && value > left) {
          cout << "X";
        } else {
          cout << value;
        }
      // outer ring
      } else {
        cout << value;
      }
    }
    cout << endl;
  }
  return 0;
}
