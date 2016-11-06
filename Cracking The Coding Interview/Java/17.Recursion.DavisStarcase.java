import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Davis has s staircases in his house and he likes to climb each staircase 1,2, or 3 steps at a time.
Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.

Given the respective heights for each of the s staircases in his house, find and print the number of ways he can
climb each staircase on a new line.

Input Format

The first line contains a single integer,s, denoting the number of staircases in his house.
Each line i of the s subsequent lines contains a single integer,n, denoting the height of staircase i.

Constraints

* 1 <= s <= 5
* 1 <= n <= 36

Subtasks

* 1 <= n <= 20 for 50% of the maximum score

Output Format

For each staircase, print the number of ways Davis can climb it in a new line.

Sample Input

3
1
3
7
Sample Output

1
4
44
*/

public class Solution {

  private static Map<Integer,Integer> staircaseCount;

  private static int countSteps(int numberOfStairs, int recursionLevel) {

    if (staircaseCount.get(numberOfStairs) != null) {
      return staircaseCount.get(numberOfStairs);
    } else if (numberOfStairs <= 0) {
      return 0;
    } else {
      int currentCount = 0;
      currentCount += countSteps(numberOfStairs-3, recursionLevel + 1);
      currentCount += countSteps(numberOfStairs-2, recursionLevel + 1);
      currentCount += countSteps(numberOfStairs-1, recursionLevel + 1);

      staircaseCount.put(numberOfStairs,currentCount);
      return currentCount;
    }
  }

  public static void main(String[] args) {
    staircaseCount = new HashMap<Integer,Integer>();
    staircaseCount.put(0,0);
    staircaseCount.put(1,1);
    staircaseCount.put(2,2);
    staircaseCount.put(3,4);
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    for(int a0 = 0; a0 < s; a0++){
      int n = in.nextInt();
      int staircaseCount = countSteps(n,0);
      System.out.printf("%d\n", staircaseCount);
    }
  }
}

