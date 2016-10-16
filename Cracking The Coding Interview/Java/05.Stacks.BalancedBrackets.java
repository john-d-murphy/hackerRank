import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left 
of a closing bracket (i.e., ), ], or }) of the exact same type. 
There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. 
For example, {[(])} is not balanced because the contents in between { and } are not balanced. 
The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses 
encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

* It contains no unmatched brackets.
* The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.

Given n strings of brackets, determine whether each sequence of brackets is balanced. 
If a string is balanced, print YES on a new line; otherwise, print NO on a new line.

Input Format

The first line contains a single integer,n, denoting the number of strings.
Each line of the subsequent lines consists of a single string,s, denoting a sequence of brackets.

Constraints
* 1 <= n <= 10^3
* 1 <= length(s) <= 10^3 where length(s) is the length of the sequence

Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).
*/


public class Solution {


  public static boolean isBalanced(String expression) {

    Stack<Character> openBrackets = new Stack<Character>();

    for( Character c : expression.toCharArray()) {
      if (isOpen(c)) {
        openBrackets.push(c);
      } else if(openBrackets.isEmpty()) {
        return false;
      } else {
        Character open = openBrackets.pop();

        if (!isPair(open,c)) {
          return false;
        }
      }
    }

    // If we have more open brackets than closed brackets
    if (openBrackets.size() > 0) {
      return false;
    }
    return true;
  }

    private static boolean isOpen(Character c) {
    return c != null && (c.equals('(') || c.equals('[') || c.equals('{'));
  }

  private static boolean isPair(Character open, Character close) {
    if (open == null || close == null) {
      return false;
    } else if (open.equals('(') && close.equals(')')) {
      return true;
    } else if (open.equals('[') && close.equals(']')) { 
      return true;
    } else if (open.equals('{') && close.equals('}')) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int t = in.nextInt();

    for(int a0 = 0; a0 < t; a0++) {
      String expression = in.next();
      boolean answer = isBalanced(expression);

      if(answer)
        System.out.println("YES");
      else System.out.println("NO");
    }
  }
}

