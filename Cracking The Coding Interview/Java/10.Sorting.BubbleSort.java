import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Consider the following version of Bubble Sort:

for (int i = 0; i < n; i++) {
    // Track number of elements swapped during a single array traversal
    int numberOfSwaps = 0;

    for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
            swap(a[j], a[j + 1]);
            numberOfSwaps++;
        }
    }

    // If no elements were swapped during a traversal, array is sorted
    if (numberOfSwaps == 0) {
        break;
    }
}

Task
Given an n-element array,A=a0..an-1, of distinct elements, sort array A in ascending order using the Bubble Sort
algorithm above. Once sorted, print the following three lines:


* Array is sorted in numSwaps swaps., where is the number of swaps that took place.
* First Element: firstElement, where is the first element in the sorted array.
* Last Element: lastElement, where is the last element in the sorted array.

Input Format

The first line contains an integer,n, denoting the number of elements in array A.
The second line contains space-separated integers describing the respective values of a0, a1, an-1.

ample Input 0

3
1 2 3

Sample Output 0

Array is sorted in 0 swaps.
First Element: 1
Last Element: 3
*/

public class Solution {

  private static void swap(int a[], int element1, int element2 ) {
    int temp = a[element1];
    a[element1] = a[element2];
    a[element2] = temp;
  }

  private static int bubbleSort(int a[], int n) {
    int totalSwaps = 0;
    for (int i = 0; i < n; i++) {

      int numberOfSwaps = 0;

      for (int j = 0; j < n - 1; j++) {
        if (a[j] > a[j + 1]) {
          swap(a, j, j + 1);
          numberOfSwaps++;
        }
      }

      totalSwaps += numberOfSwaps;

      // If no elements were swapped during a traversal, array is sorted
      if (numberOfSwaps == 0) {
        break;
      }
    }
    return totalSwaps;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    for(int a_i=0; a_i < n; a_i++){
      a[a_i] = in.nextInt();
    }

    int swapCount = bubbleSort(a,n);
    System.out.printf("Array is sorted in %d swaps.\n", swapCount);
    System.out.printf("First Element: %d\n", a[0]);
    System.out.printf("Last Element: %d\n", a[n-1]);
  }
}
