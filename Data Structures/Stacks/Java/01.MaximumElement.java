import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
You have an empty sequence, and you will be given N queries. Each query is one of these three types:

1 x  -Push the element x into the stack.
2    -Delete the element present at the top of the stack.
3    -Print the maximum element in the stack.

Input Format

The first line of input contains an integer, N. The next N lines each contain an above mentioned query.
(It is guaranteed that each query is valid.)

Constraints

* 1 <= N <= 10^5
* 1 <= x <= 10^9
* 1 <= type <= 3

Output Format

For each type 3 query, print the maximum element in the stack on a new line.

Sample Input

10
1 97
2
1 20
2
1 26
1 20
2
3
1 91
3
Sample Output

26
91
*/

public class Solution {

  public static class Node {
    int value;
    int count;
    Node next;

    public Node(int value) {
      this.value = value;
      count = 1;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int queries = scanner.nextInt();
    Node stack = null;

    for(int i = 0; i < queries; i++) {

      int queryType = scanner.nextInt();

      if(queryType == 1) {
        int value = scanner.nextInt();
        if (stack == null) {
          stack = new Node(value);
        } else {
          int newMax = Math.max(value,stack.value);
          if (newMax == stack.value) {
            stack.count++;
          } else {
            Node newNode = new Node(newMax);
            newNode.next = stack;
            stack = newNode;
          }
        }
      } else if (queryType == 2) {
        if(stack.count == 1) {
          stack = stack.next;
        } else {
          stack.count--;
        }
      } else if (queryType == 3) {
        System.out.printf("%s\n", stack.value);
      }
    }
  }
}



