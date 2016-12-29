import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a
closing bracket (i.e., ), ], or }) of the exact same type.
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
Each line i of the n subsequent lines consists of a single string,s, denoting a sequence of brackets.

Constraints

* 1 <= n <= 10^3
* 1 <= len(s) <= 10^3, where len(s) is the length of the sequence
* Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).

Output Format

For each string, print whether or not the string of brackets is balanced on a new line.
If the brackets are balanced, print YES; otherwise, print NO.

Sample Input
3
{[()]}
{[(])}
{{[[(())]]}}

Sample Output
YES
NO
YES
Explanation
The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced.
The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
*/

public class Solution {

  private static boolean isOpen(Character bracket) {
    if(bracket == ']' || bracket == ')' || bracket == '}') {
      return false;
    } else {
      return true;
    }
  }

  private static boolean bracketsMatch(Character close, Character open) {
    if(open == null || close == null) {
      return false;
    } else if(open == '[' && close == ']') {
      return true;
    } else if(open == '(' && close == ')') {
      return true;
    } else if(open == '{' && close == '}') {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a0 = 0; a0 < t; a0++){
      String s = in.next();
      Stack<Character> openBrackets = new Stack<Character>();
      char brackets[] = s.toCharArray();
      boolean matchingBraces = true;
      for(int i = 0; i < brackets.length; i++) {
        //System.out.printf("[%s] - checking\n", brackets[i]);
        if(isOpen(brackets[i])) {
          //System.out.printf("[%s] is open\n", brackets[i]);
          openBrackets.push(brackets[i]);
        } else if(openBrackets.isEmpty()) {
          matchingBraces = false;
        } else if (!bracketsMatch(brackets[i],openBrackets.pop())) {
          matchingBraces = false;
        }
        if(matchingBraces == false) {
          break;
        }
      }

      if(matchingBraces && openBrackets.isEmpty()) {
        System.out.printf("YES\n");
      } else {
        System.out.printf("NO\n");
      }
    }
  }
}

