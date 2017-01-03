import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
In the Quicksort challenges, you sorted an entire array.
Sometimes, you just need specific information about a list of numbers, and doing a full sort would be unnecessary.
Can you figure out a way to use your partition code to find the median in an array?

Challenge
Given a list of numbers, can you find the median?

Input Format
There will be two lines of input:

* n   - the size of the array
* ar  - n numbers that makes up the array

Output Format
Output one integer, the median.

Constraints
* 1 <= n <= 1000001
* n is odd
* -1000 <= x <= 10000, x in ar

Sample Input

7
0 1 2 4 6 5 3
Sample Output

3
*/

public class Solution {

  static void swap(int[] ar, int index1, int index2) {
    int temp = ar[index2];
    ar[index2] = ar[index1];
    ar[index1] = temp;
  }

  static int partition(int[] ar, int low, int high) {

    int pivot = ar[high];
    int holder = low; // hold temporary values

    //System.out.printf("Pivot: %d - Holder: %d - Low: %d - High: %d\n",pivot, holder, low, high);

    for(int i = low; i < high; i++) {
      //System.out.printf("Comparing:%d and %d\n", ar[i], pivot);
      if(ar[i] <= pivot) {
        //System.out.printf("Swapping: %d and %d\n", ar[i], pivot);
        swap(ar,holder,i);
        holder++;
      }
      //printArray(ar);
    }

    //System.out.printf("Swapping: %d and %d\n", ar[high], holder);

    swap(ar,holder,high);

    return holder;

  }

  static void quickSort(int[] ar, int low, int high) {
    if (ar.length == 0 || ar.length == 1) {
      return;
    } else if (low < high){
      int partition = partition(ar,low,high);
      quickSort(ar,low, partition - 1);
      quickSort(ar,partition+1,high);
    }

  }
  static void printArray(int[] ar) {
    for(int n: ar){
      System.out.print(n+" ");
    }
    System.out.println("");
  }



  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n];

    for(int i = 0; i < n ; i++) {
      arr[i] = scanner.nextInt();
    }

    quickSort(arr,0,n-1);

    System.out.printf("%d", arr[n/2]);

  }
}
