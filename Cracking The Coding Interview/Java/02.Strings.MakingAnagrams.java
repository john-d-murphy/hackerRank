import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Alice is taking a cryptography class and finding anagrams to be very useful. 
We consider two strings to be anagrams of each other if the first string's letters can be rearranged 
to form the second string. In other words, both strings must contain the same exact letters in the same 
exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

Alice decides on an encryption scheme involving two large strings where encryption is dependent on the 
minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?

Given two strings, a and b, that may or may not be of the same length, determine the minimum number of character 
deletions required to make and anagrams. Any characters can be deleted from either of the strings.

This challenge is also available in the following translations:

    Chinese
    Russian

Input Format

The first line contains a single string, a.
The second line contains a single string, b.

Constraints
  
* 1 <= |a|,|b| <= 10^4

* It is guaranteed that and consist of lowercase English alphabetic letters (i.e., a through z).

Output Format

Print a single integer denoting the number of characters you must delete to make the two strings 
anagrams of each other.

Sample Input

cde
abc

Sample Output
4

*/

public class Solution {
  
  public static int numberNeeded(String first, String second) {
    /* Explanation - we're guaranteed to have a-z, so we don't
     * need to use a hashmap. We can just have an array of 
     * size 26, each letter representing a number. 
     *
     * We iterate through each of the strings, and count the 
     * number of times each letter appears.
     *
     * To find the number of letters we need to make an anagram
     * we just need to find the differences between each bucket.
     * 
     * We may be able to do this in one bucket, but this is efficient
     * and clear. 
     */

    int offset        = (int) 'a';
    int firstArray[]  = new int[26];h
    int secondArray[] = new int[26];
    int numberNeeded  = 0;

    for (char value : first.toCharArray()) {
      int characterValue = (int) value - offset;
      firstArray[characterValue]++;
    }

    for (char value : second.toCharArray()) {
      int characterValue = (int) value - offset;
      secondArray[characterValue]++;
    }

    for (int i = 0 ; i < 26; i++) {
      numberNeeded += Math.abs(firstArray[i] - secondArray[i]);
    }

    return numberNeeded;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    System.out.println(numberNeeded(a, b));
  }
}

