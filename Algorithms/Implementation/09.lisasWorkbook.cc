#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
Lisa just got a new math workbook. A workbook contains exercise problems, grouped into chapters.

There are n chapters in Lisa's workbook, numbered from 1 to n.
The i-th chapter has ti problems, numbered from 1 to ti.
Each page can hold up to k problems.
There are no empty pages or unnecessary spaces, so only the last page of a chapter may contain fewer than k problems.
Each new chapter starts on a new page, so a page will never contain problems from more than one chapter.
The page number indexing starts at 1.

Lisa believes a problem to be special if its index (within a chapter)
is the same as the page number where it's located.
Given the details for Lisa's workbook, can you count its number of special problems?

Input Format

The first line contains two integers n and k — the number of chapters and the maximum number of problems
per page respectively.
The second line contains n integers t1, t2, ... tn where ti denotes the number of problems in the ith chapter.

Constraints
1 <= n,k,ti <= 100

Output Format
print the number of special problems in Lisa's workbook

Sample Input

5 3
4 2 6 1 10
Sample Output

4
*/

// This is a somewhat confusing specification, so I am not going to do anything fancy here.
// Just going to count out each page and check to see if each problem is a special problem.
// If it is, great, we'll increment.

// Also: this is the closest to a real-world problem as I've seen in these problems sets yet.

int main() {
  int numberOfChapters;
  int maxProblemsPerPage;
  int currentPage = 1;
  int numberOfSpecialProblems = 0;
  cin >> numberOfChapters >> maxProblemsPerPage;

  for (int chapter = 1; chapter <= numberOfChapters; chapter++ ) {
    int numberOfProblems;
    cin >> numberOfProblems;
    int currentProblemCount = 1;
    int numberOfPages = (numberOfProblems % maxProblemsPerPage == 0) ? \
            numberOfProblems/maxProblemsPerPage : numberOfProblems/maxProblemsPerPage + 1;

    int chapterLastPage = currentPage + numberOfPages;
    for (int chapterPage = 1; currentPage < chapterLastPage; ++currentPage) {
      for (int i = 1; i <= maxProblemsPerPage; i++) {
        int currentProblem = ((chapterPage-1) * maxProblemsPerPage) + i;
        if (currentProblem > numberOfProblems) {
          break;
        }
        if (currentPage == currentProblem ) {
          numberOfSpecialProblems++;
        }
      }
      chapterPage++;
    }
  }

  cout << numberOfSpecialProblems << endl;
}
