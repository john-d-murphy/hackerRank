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

// Note that this isn't asking for the number of swaps that need to be done for
// a merge sort, but rather the count of inverted numbers within the list.
// You can use the merge sort *idea*, but if mergesort is implemented, the
// count will necessarily be significantly lower than the number of inversions
// since the algorithm is efficient

public class Solution {

  static long globalSwapCount;
  static long globalInversionCount;

  public static int[] mergeSort(int arr[]){
    //System.out.printf("Array to Sort: "); printArray(arr); System.out.printf("\n");

    // If the array is empty or of size 1, we're sorted
    if (arr.length == 0 || arr.length == 1) {
      //System.out.printf("Recursive Case - finished sorting\n");
      return arr;
    }

    int half = arr.length/2;

    // Split the list in half for recursive sorting
    int leftSide[] = new int[half];
    int rightSide[] = new int[arr.length - half];

    //System.out.printf("Left Size: %d / Right Size: %d\n", leftSide.length, rightSide.length);

    for (int i = 0; i < half; i++) {
      leftSide[i] = arr[i];
    }

    for (int i = half ; i < arr.length; i++ ) {
      rightSide[i-half] = arr[i];
    }

    // Sort the lists
    //System.out.printf("Sorting Left:  ");
    //printArray(leftSide);
    //System.out.printf("\n");
    leftSide = mergeSort(leftSide);

    //System.out.printf("Sorted Left:   ");
    //printArray(leftSide);
    //System.out.printf("\n");

    //System.out.printf("Sorting Right: ");
    //printArray(rightSide);
    //System.out.printf("\n");
    rightSide = mergeSort(rightSide);

    //System.out.printf("Sorted Right:  ");
    //printArray(rightSide);
    //System.out.printf("\n");

    // Merge them together
    //System.out.printf("Merging lists: ");
    //printArray(leftSide); System.out.printf(" "); printArray(rightSide); System.out.printf("\n");
    int result[] = merge(leftSide, rightSide);
    //System.out.printf("Sorted Array:  ");
    //printArray(result);
    //System.out.printf("\nCurrent Swap Count: %d\n###################\n",globalSwapCount);
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
      //System.out.printf("Current Sorted List: "); printArray(result); System.out.printf("\n");
      //System.out.printf("Comparing: %d to %d - ", left[leftIndex], right[rightIndex]);
      //System.out.printf("Indexes: %d and %d - ", leftIndex, rightIndex);

      if (right[rightIndex] < left[leftIndex]) {
        //System.out.printf("Swap\n");
        result[currentIndex] = right[rightIndex];
        // calculate offset of current number - this is the number of inversions, not the swap count.
        for (int i = leftIndex ; i < left.length; i ++) {
          //System.out.printf("Inverted Pair found: (%d,%d)\n", left[i], right[rightIndex]);
          globalSwapCount++;
        }
        rightIndex++;
      } else {
        //System.out.printf("No Swap\n");
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

  private static void printArray(int arr[]) {
    System.out.printf("[ ");
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0)
        System.out.printf("%d ", arr[i]);
    }
    System.out.printf("]");
  }

  private static void printArrayFromIndex(int arr[], int index) {
    System.out.printf("[ ");
    for (int i = index; i < arr.length; i++) {
      if (arr[i] > 0)
        System.out.printf("%d ", arr[i]);
    }
    System.out.printf("]");
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
      //printArray(arr);System.out.printf("\n");printArray(unsorted);
      //System.out.printf("\nSwap Count: %s\n", globalSwapCount);
      //System.out.printf("##################\n\n\n\n");
      System.out.printf("%s\n", globalSwapCount);
    }
  }
}


