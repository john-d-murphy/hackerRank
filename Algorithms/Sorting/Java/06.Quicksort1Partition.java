import java.util.*;

/*
The previous challenges covered Insertion Sort, which is a simple and intuitive sorting algorithm with an average case
performance of (n^2). In these next few challenges, we're covering a divide-and-conquer algorithm called Quicksort
(also known as Partition Sort).

Step 1: Divide
Choose some pivot element,p, and partition your unsorted array,ar, into three smaller arrays: left, rght, and equal,
where each element in left < p, each element in right > p, and each element in equal = p.

Challenge
Given ar and p=ar[0], partition ar into left, right, and equal using the Divide instructions above.
Then print each element in left followed by each element in right, followed by each element in equal on a single line.
Your output should be space-separated.

Note: There is no need to sort the elements in-place; you can create two lists and stitch them together at the end.

Input Format
The first line contains n (the size of ar).
The second line contains n space-separated integers describing ar (the unsorted array).
The first integer (corresponding to ar[0]) is your pivot element, p.

Constraints

* 1 <= n <= 1000
* -1000 <= x <= 1000, x in ar
* All elements will be unique
* Multiple answers can exist for the given test case. Print any one of them.

Output Format

On a single line, print the partitioned numbers (i.e.: the elements in left, then the elements in equal, and then the
elements in right). Each integer should be separated by a single space.

Sample Input

5
4 5 3 7 2
Sample Output

3 2 4 5 7

*/

public class Solution {

  static void partition(int[] ar) {

    int pivot = ar[0];

    // Print less
    for(int i = 0; i < ar.length; i++) {
      if(ar[i] < pivot) {
        System.out.printf("%d ", ar[i]);
      }
    }

    // Print equal
    for(int i = 0; i < ar.length; i++) {
      if(ar[i] == pivot) {
        System.out.printf("%d ", ar[i]);
      }

    }

    // Print more
    for(int i = 0; i < ar.length; i++) {
      if(ar[i] > pivot) {
        System.out.printf("%d ", ar[i]);
      }
    }


  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for(int i=0;i<n;i++){
      ar[i]=in.nextInt();
    }
    partition(ar);
  }
}
