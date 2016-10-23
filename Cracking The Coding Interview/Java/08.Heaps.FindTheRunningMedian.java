import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
The median of a dataset of integers is the midpoint value of the dataset for which an equal number of integers 
are less than and greater than the value. To find the median, you must first sort your dataset of integers in 
non-decreasing order, then:

If your dataset contains an odd number of elements, the median is the middle element of the sorted sample. 
In the sorted dataset {1,2,3}, 2 is the median.
If your dataset contains an even number of elements, the median is the average of the two middle elements of 
the sorted sample. In the sorted dataset {1,2,3,4}, (2 + 3)/2 = 2.5 is the median.
Given an input stream of n integers, you must perform the following task for each ith integer:

Add the ith integer to a running list of integers.
Find the median of the updated list (i.e., for the first element through the ith element).
Print the list's updated median on a new line. 
The printed value must be a double-precision number scaled to decimal place (e.g., 1.2 format).

Input Format
The first line contains a single integer,n, denoting the number of integers in the data stream. 
Each line t of the n subsequent lines contains an integer,ai, to be added to your list.

Constraints

* 1 <= n <= 10^5
* 0 <= ai <= 10^5

Output Format

After each new integer is added to the list, print the list's updated median on a new line as a single 
double-precision number scaled to decimal place (e.g., 1.2 format).
*/


public class Solution {

  private static class Node {
    public int value;
    public Node next;

    Node(int value) {
      this.value = value;
      next = null;
    }
  }

  private static Node listInsert(Node toInsert, Node root) {
    if (root == null) {
      return toInsert;
    } else if (toInsert.value < root.value) {
      toInsert.next = root;
      return toInsert;
    } else {
      root.next = listInsert(toInsert, root.next);
      return root;
    }
  }

  private static double getMedian(int index, boolean getNext, Node root) {
    Node tempNode = root;
    double median;
    //System.out.printf("Index: %s - Get Next: %s\n", index, getNext, root);

    for( int i = 0 ; i < index; i++) {
      tempNode = tempNode.next;
    }

    if (getNext) {
      median = (tempNode.value + tempNode.next.value)/2.0;
    } 
    else {
      median = tempNode.value;
    }
    return median;


  }

  private static void printList(Node root) {
    Node tempRoot = root;
    System.out.printf("List: ");
    while( tempRoot != null) {
      System.out.printf("%d ", tempRoot.value);
      tempRoot = tempRoot.next;
    }
    System.out.printf("\n");
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Node list = null;
    for(int count=0; count < n; count++){
      int value = in.nextInt();
      Node newNode = new Node(value);
      list = listInsert(newNode, list);
      //printList(list);
      int index = count / 2;
      boolean getNext = count % 2 == 1;
      //System.out.printf("Median Index: %d\n", index);
      //System.out.printf("Get Next: %s\n", getNext);
      double median = getMedian( index, getNext, list);
      //System.out.printf("Median: %.2f\n##############\n", median);
      System.out.printf("%.1f\n", median);
    }
  }
}

