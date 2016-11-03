import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*

A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself.
Given p integers, determine the primality of each integer and print whether it is Prime or Not prime on a new line.

If possible, try to come up with an O(sqrt(n)) primality algorithm, or see what optimizations you can come up with
for an O(n) algorithm. Be sure to check out the editorial after submitting your code!

Input Format

The first line contains an integer,n, denoting the number of integers to check for primality.
Each of the p subsequent lines contains an integer,n, you must test for primality.

Constraints

* 1 <= p <= 20
* 1 <= n <= 2 * 10^9

Output Format

For each integer, print whether n is Prime or Not prime on a new line.

Sample Input

3
12
5
7

Sample Output

Not prime
Prime
Prime
*/


public class Solution {

  static List<Integer> primes;

  private static List<Integer> populatePrimeList() {
    List<Boolean> sieve = new ArrayList<Boolean>();
    List<Integer> primes = new ArrayList<Integer>();
    double maxInt = Math.ceil(Math.sqrt(2000000000));

    // Sieve
    for (int i = 0; i <= maxInt; i++ ) {
      sieve.add(true);
    }

    for (int i = 2; i <= maxInt; i++ ) {
      if(sieve.get(i) == true) {
        primes.add(i);
        for (int j = i; j <= maxInt ; j += i) {
          sieve.set(j,false);
        }
      }
    }

    return primes;
  }

  private static boolean isPrime(int valueToCheck) {

    if (valueToCheck == 1) {
      return false;
    }

    for (Integer i : primes) {
      if (i >= valueToCheck) {
        return true;
      } else if (valueToCheck % i == 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

    primes = populatePrimeList();

    Scanner in = new Scanner(System.in);
    int p = in.nextInt();
    for(int a0 = 0; a0 < p; a0++){
      int n = in.nextInt();
      if (isPrime(n)) {
        System.out.printf("%s\n", "Prime" );
      } else {
        System.out.printf("%s\n", "Not prime");
      }
    }
  }
}

