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


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    for(int a_i=0; a_i < n; a_i++){
      a[a_i] = in.nextInt();
    }
  }
}

