import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
We're going to make our own Contacts application! The application must perform two types of operations:

1. add name, where n is a string denoting a contact name. This must store name as a new contact in the application.
2. find partial, where partial is a string denoting a partial name to search the application for.
It must count the number of contacts starting with partial and print the count on a new line.
Given n sequential add and find operations, perform each operation in order.

Input Format

The first line contains a single integer,n, denoting the number of operations to perform.
Each line i of the n subsequent lines contains an operation in one of the two forms defined above.

Constraints
* 1 <= n <= 10^5
* 1 <= |name| <= 21
* 1 <= |partial <= 21
* it is guaranteed that name and partial contain lowercase English letters only

Output Format

For each find partial operation, print the number of contact names starting with partial on a new line.

Sample Input

4
add hack
add hackerrank
find hac
find hak
Sample Output

2
0
Explanation

We perform the following sequence of operations:

Add a contact named hack.

Add a contact named hackerrank.

Find and print the number of contact names beginning with hac.
There are currently two contact names in the application and both of them start with hac, so we print 2 on a new line.

Find and print the number of contact names beginning with hak.
There are currently two contact names in the application but neither of them start with hak, so we print 0
on a new line.
*/

public class Solution {

  private static class Node {
    int numberOfEntries;
    Map<Character, Node> entries;

    public Node() {
      numberOfEntries = 0;
      entries = new HashMap<Character,Node>();
    }

    public void incrementCount() {
      numberOfEntries++;
    }

    public int getNumberOfEntries() {
      return numberOfEntries;
    }

    public Map<Character,Node> getEntries() {
      return entries;
    }
  }

  public static void insert(String toInsert, Node root) {
    if (toInsert == null || toInsert.length() == 0) {
      return;
    }

    Character nextChar = toInsert.charAt(0);
    String remainingString = toInsert.substring(1);

    if(root.getEntries().get(nextChar) == null) {
      root.getEntries().put(nextChar, new Node());
    }

    root.getEntries().get(nextChar).incrementCount();

    insert(remainingString, root.getEntries().get(nextChar));
  }

  public static int find(String toFind, Node root) {

    if (toFind == null || toFind.length() == 0) {
      return root.getNumberOfEntries();
    }

    Character nextChar = toFind.charAt(0);
    String remainingString = toFind.substring(1);

    if(root.getEntries().get(nextChar) == null) {
      return 0;
    }
    return find(remainingString, root.getEntries().get(nextChar));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Node root = new Node();
    int n = in.nextInt();
    for(int a0 = 0; a0 < n; a0++){
      String op = in.next();
      String contact = in.next();
      if ("add".equals(op)) {
        insert(contact,root);
      } else if("find".equals(op)) {
        int count = find(contact, root);
        System.out.printf("%d\n", count);
      }
    }
  }
}
