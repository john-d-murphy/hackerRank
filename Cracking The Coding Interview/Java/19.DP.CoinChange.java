import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Given a number of dollars,n, and a list of dollar values for m distinct coins,{c0,c1,c2,..cm-1}, find and print
the number of different ways you can make change for n dollars if each coin is available in an infinite quantity.

Hints:
* You can solve this problem recursively, but you must optimize your solution to eliminate overlapping subproblems
using Dynamic Programming if you wish to pass all test cases. More specifically, think of ways to store the checked
solutions and use the stored values to avoid repeatedly calculating the same values.
* Think about the degenerate cases:
** How many ways can you make change for 0  dollars?
** How many ways can you make change for less than 0 dollars if you have no coins?

If you are having trouble defining the storage for your precomputed values, then think about it in
terms of the base case (n=0).

Input Format

The first line contains two space-separated integers describing the respective values of n and m.
The second line contains m space-separated integers describing the respective values of c0,c1,...cm-1, where each
integer denotes the dollar value of a distinct coin available in an infinite quantity.

Constraints
* 1 <= ci <= 50
* 1 <= n <= 250
* 1 <= m <= 50
* The list of coins contains m distinct integers where each integer denotes the dollar value of a coin available in
and infinite quantity.

Output Format

Print a single integer denoting the number of ways we can make change for n dollars using an infinite supply of our m
types of coins.

Sample Input 0

4 3
1 2 3
Sample Output 0

4

Explanation 0
For n=4 and C={1,2,3} there are four solutions:
1. {1,1,1,1}
2. {1,1,2}
3. {2,2}
4. {1,3}

Thus, we print  on a new line.

Sample Input 1

10 4
2 5 3 6

Sample Output 1

5

Explanation 1
For n=10  and C={2,5,3,6} there are five solutions:
1. {2,2,2,2,2}
2. {2,2,3,3}
3. {2,2,6}
4. {2,3,5}
5. {5,5}
*/

public class Solution {

  public static Map<List<Integer>, Long> changeCount;

  public static long makeChange(int[] coins, int money, List<Integer> currentCombination) {

    System.out.printf("Current Combination: %s\n", currentCombination);

    if (money == 0) {
      System.out.printf("#### Valid Combination:%s\n", currentCombination);
      return 1;
    } else if (changeCount.containsKey(currentCombination)) {
      return changeCount.get(currentCombination);
    } else {
      long combinations = 0;
      for( int i = 0; i < coins.length; i++) {
        int moneyToCheck = money - coins[i];
        List<Integer> newCombination = new ArrayList<Integer>(currentCombination);
        newCombination.set(i, newCombination.get(i) + 1);
        if (moneyToCheck < 0) {
          break;
        } else if (changeCount.containsKey(newCombination)) {
          System.out.printf("Already seen: %s\n", newCombination);
        } else {
          Long combinationChange = makeChange(coins, moneyToCheck, newCombination);
          combinations += combinationChange;
          changeCount.put(newCombination, combinationChange);
        }
      }
      return combinations;
    }


  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    changeCount = new HashMap<List<Integer>,Long>();
    List<Integer> currentCombination = new ArrayList<>();
    int n = in.nextInt();
    int m = in.nextInt();
    int coins[] = new int[m];
    for(int coins_i=0; coins_i < m; coins_i++){
      coins[coins_i] = in.nextInt();
      currentCombination.add(0);
    }

    Arrays.sort(coins);
    long totalCombinations = 0;

    for(int i = 0; i < coins.length; i++) {
      System.out.printf("Expecting to make change for %d\n", coins[i]);
      totalCombinations += makeChange(coins, coins[i], currentCombination);
    }
    System.out.println(totalCombinations);
  }
}
