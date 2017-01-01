import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Sorting
One common task for computers is to sort data.
For example, people might want to see all their files on a computer sorted by size.
Since sorting is a simple problem with many different possible solutions, it is often used to introduce the study of
algorithms.

Insertion Sort
These challenges will cover Insertion Sort, a simple and intuitive sorting algorithm.
We will first start with an already sorted list.

Insert element into sorted list
Given a sorted list with an unsorted number e in the rightmost cell, can you write some simple code to insert into the
array so that it remains sorted?

Print the array every time a value is shifted in the array until the array is fully sorted.
The goal of this challenge is to follow the correct order of insertion sort.

Guideline: You can copy the value of e to a variable and consider its cell "empty".
Since this leaves an extra cell empty on the right, you can shift everything over until e can be inserted.
This will create a duplicate of each value, but when you reach the right spot, you can replace it with e.

Input Format
There will be two lines of input:

 Size - the size of the array
 Arr - the unsorted array of integers

Output Format
On each line, output the entire array every time an item is shifted in it.

Constraints

* 1 <= Size <= 1000
* -10000 <= e <= 10000, e in Arr

Sample Input

5
2 4 6 8 3
Sample Output

2 4 6 8 8
2 4 6 6 8
2 4 4 6 8
2 3 4 6 8

Task

Complete the method insertionSort which takes in one parameter:

Arr - an array with the value e in the right-most cell.
*/

class Solution {


	public static void insertIntoSorted(int[] ar) {
		int lastEntry = ar.length -1;
		int value = ar[lastEntry];
		int index = lastEntry;

		do {
			ar[index] = ar[index-1];
			printArray(ar);
			index --;
		} while(index > 0 && ar[index-1] > value);

		ar[index] = value;
		printArray(ar);

	}


	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for(int i=0;i<s;i++){
			ar[i]=in.nextInt();
		}
		insertIntoSorted(ar);
	}


	private static void printArray(int[] ar) {
		for(int n: ar){
			System.out.print(n+" ");
		}
		System.out.println("");
	}
}




