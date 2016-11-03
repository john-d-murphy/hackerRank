import java.util.*;

/*The Fibonacci Sequence

The Fibonacci sequence begins with fibonacci(0) = 0 and fibonacci(1) = 1 and as its respective first and second terms.
After these first two elements, each subsequent element is equal to the sum of the previous two elements.

Here is the basic information you need to calculate :

* fibonacci(0) = 0
* fibonacci(1) = 1
* fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)

Task
Given n, complete the fibonacci function so it returns fibonacci(n).

Input Format

Locked stub code in the editor reads a single integer denoting the value of n and passes it to the fibonacci function.

Constraints
0 < n < 40

Output Format

Locked stub code in the editor prints the value of fibonacci(n) returned by the fibonacci function.

Sample Input
3

Sample Output
2 */

public class Solution {

  private static Map<Integer, Integer> fibonacciNumbers;

  public static int fibonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (fibonacciNumbers.get(n) != null) {
      return fibonacciNumbers.get(n);
    } else {
      Integer thisNumber = fibonacci(n-1) + fibonacci(n-2);
      fibonacciNumbers.put(n,thisNumber);
      return thisNumber;
    }
  }

  public static void main(String[] args) {
    fibonacciNumbers = new HashMap<>();
    fibonacciNumbers.put(0,0);
    fibonacciNumbers.put(1,1);
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();
    System.out.println(fibonacci(n));
  }
}
