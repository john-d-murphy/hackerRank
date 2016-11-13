import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 We define a modified Fibonacci sequence using the following definition:
 Given terms ti and ti+1 where i in [1,infinity], term ti+2 is computed using the following relation:
    ti+2 = ti + (ti + 1 )^2

For example, if term t1 = 0 and t2 =1, term t3 = 0 + 1^2 = 1, term t4 = 1 + 1^2 = 2, term t5 = 1+2^2 = 5, and so on.

Given three integers, t1, t2, and n, compute and print term n of a modified Fibonacci sequence.

Note: The value of  may far exceed the range of a 64-bit integer.
Many submission languages have libraries that can handle such large results but, for those that don't
(e.g., C++), you will need to be more creative in your solution to compensate for the limitations of your
chosen submission language.

Input Format:

A single line of three space-separated integers describing the respective values of t1, t2, and n.

Constraints:

* 0 <= t1,t2 <= 2
* 3 <= n <= 20
* tn may far exceed the range of a 64 bit integer.

Output Format:

Print a single integer denoting the value of term n in the modified Fibonacci sequence where the first
two terms are t1 and t2.

Sample Input:
0 1 5

Sample Output:
5

Explanation:

The first two terms of the sequence are t1=0 and t2=1, which gives us a modified Fibonacci sequence of
{0,1,1,2,5,27...}. Because n=5, we print term 5, which is 5.

*/

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger firstTerm = BigInteger.valueOf(in.nextInt());
		BigInteger secondTerm = BigInteger.valueOf(in.nextInt());
		int term = in.nextInt();

		for(int i = 2; i < term; i++) {
			BigInteger tempTerm = firstTerm.add(secondTerm.multiply(secondTerm));
			firstTerm = secondTerm;
			secondTerm = tempTerm;
		}

		System.out.printf("%s", secondTerm.toString());
	}
}
