import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
In an array, arr=[arr0,arr1 .. arrn], the elements at indices i and j (where i < j) form an inversion if arri > arrj.
In other words, inverted elements i  and j are considered to be "out of order".
To correct an inversion, we can swap adjacent elements.

For example, consider arr = [2,4,1]. It has two inversions: (2,1) and (4,1).
To sort the array, we must perform the following two swaps to correct the inversions:

swap(arr1,arr2) && swap(arr0,arr1)

Given d datasets, print the number of inversions that must be swapped to sort each dataset on a new line.

Input Format

The first line contains an integer,d, denoting the number of datasets.
The 2d subsequent lines describe each respective dataset over two lines:

* The first line contains an integer,n, denoting the number of elements in the dataset.
* The second line contains n space-separated integers describing the respective values of arr0,arr1 ... arrn.

Constraints

* 1 <= d <= 15
* 1 <= n <= 10^5
* 1 <= arri <= 10^7

Output Format

For each of the d datasets, print the number of inversions that must be swapped to sort the dataset on a new line.

*/

// Note that this isn't asking for the number of swaps that need to be done to
// merge the list, but rather how many numbers are inverted and, essentially,
// the distance those numbers are from their current position.
//
// This is why when you're doing your swap count that you use the offset of the
// index to calculate the number of inversions. This works extremely well and
// gives you an execution time of O(n log n), which is, coincidentally, the
// same as the sorting algorithm.

public class Solution {

  static long globalSwapCount;
  static long globalInversionCount;

  public static int[] mergeSort(int arr[]){

    // If the array is empty or of size 1, we're sorted
    if (arr.length == 0 || arr.length == 1) {
      return arr;
    }

    int half = arr.length/2;

    // Split the list in half for recursive sorting
    int leftSide[] = new int[half];
    int rightSide[] = new int[arr.length - half];

    for (int i = 0; i < half; i++) {
      leftSide[i] = arr[i];
    }

    for (int i = half ; i < arr.length; i++ ) {
      rightSide[i-half] = arr[i];
    }

    // Sort the lists
    leftSide = mergeSort(leftSide);
    rightSide = mergeSort(rightSide);
    int result[] = merge(leftSide, rightSide);
    return result;
  }

  public static int[] merge(int left[], int right[]) {
    int totalLength = left.length + right.length;
    int result[] = new int[totalLength];
    int currentIndex = 0;
    int leftIndex = 0;
    int rightIndex = 0;

    // Sort beginning of list
    while (leftIndex < left.length && rightIndex < right.length) {

      if (right[rightIndex] < left[leftIndex]) {
        result[currentIndex] = right[rightIndex];
        // calculate offset of current number - this is the number of inversions, not the swap count.
        // Not intuitive, but essentially, by inserting from the right array into the index at this
        // point, you're displacing everything in the left array. Since both
        // sides are sorted since we're in merge sort, this means that the
        // remaining items in the left array will be displaced. So we add them
        // all up, and this gives us the displaced count.

        globalSwapCount += left.length - leftIndex;
        rightIndex++;
      } else {
        result[currentIndex] = left[leftIndex];
        leftIndex++;
      }
      currentIndex++;
    }

    while (leftIndex < left.length) {
      result[currentIndex] = left[leftIndex];
      leftIndex++;
      currentIndex++;
    }

    while (rightIndex < right.length) {
      result[currentIndex] = right[rightIndex];
      rightIndex++;
      currentIndex++;
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a0 = 0; a0 < t; a0++){
      globalSwapCount = 0;
      int n = in.nextInt();
      int arr[] = new int[n];
      int unsorted[] = new int[n];
      for(int arr_i=0; arr_i < n; arr_i++){
        int nextInt = in.nextInt();
        arr[arr_i] = nextInt;
        unsorted[arr_i] = nextInt;
      }
      arr = mergeSort(arr);
      System.out.printf("%s\n", globalSwapCount);
    }
  }
}


