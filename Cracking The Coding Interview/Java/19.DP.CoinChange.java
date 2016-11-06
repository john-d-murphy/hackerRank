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

  public static Map<Integer,Long> changeCount;

  public static long makeChange(int[] coins, int money, int recursionLevel, int startIndex, String currentCombination) {
    String recursionTab = new String();

    for (int i = 0; i < recursionLevel; i++) {
      recursionTab += "| | ";
    }
    //System.out.printf("%sCurrent Combination: {%s }\n", recursionTab, currentCombination);

    //System.out.printf("%sCurrent Money: %d\n", recursionTab,money);
    if (money == 0) {
        //System.out.printf("%sFound 0 - Returning 1 - current Combination: {%s }\n", recursionTab, currentCombination);

      return 1;
    } else if(money < 0) {
        //System.out.printf("%sFound < 0 - Returning 0\n", recursionTab);
      return 0;

    /*
    } else if (changeCount.get(money) != null) {
      System.out.printf("%sFound Combination at %d - Returning %d\n", recursionTab, money, changeCount.get(money));
      return changeCount.get(money);
    */
    } else {
      long totalCombinations = 0;
      for( int i = startIndex; i < coins.length; i++) {
        //System.out.printf("%sStarting %d\n", recursionTab, coins[i]);
        int moneyToCheck = money - coins[i];
        totalCombinations += makeChange(coins,moneyToCheck, recursionLevel + 1, i, currentCombination + " " + coins[i]);
        //System.out.printf("%sFinished %d - Leaves %d - Current Combinations: %d\n", recursionTab,coins[i], moneyToCheck, totalCombinations);
      }
      //System.out.printf("%s### Storing %d for %d ###\n", recursionTab, totalCombinations, money);
      changeCount.put(money,totalCombinations);
      return totalCombinations;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    changeCount = new HashMap<Integer,Long>();
    int n = in.nextInt();
    int m = in.nextInt();
    int coins[] = new int[m];
    for(int coins_i=0; coins_i < m; coins_i++){
      coins[coins_i] = in.nextInt();
    }
    Arrays.sort(coins);
    //System.out.printf("Expecting to make change for %d\n", n);
    System.out.println(makeChange(coins, n, 0, 0, ""));
  }
}

