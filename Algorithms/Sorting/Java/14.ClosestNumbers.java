import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Sorting is often useful as the first step in many different tasks.
The most common task is to make finding things easier, but there are other uses, as well.

Challenge
Given a list of unsorted integers, A={a1,a2,...an}, can you find the pair of elements that have the smallest absolute
difference between them? If there are multiple pairs, find them all.

Input Format
The first line of input contains a single integer,N, representing the length of array A.
In the second line, there are N space-separated integers,a1,a2,...an, representing the elements of array A.

Output Format
Output the pairs of elements with the smallest difference. If there are multiple pairs, output all of them in ascending
order, all on the same line (consecutively) with just a single space between each pair of numbers. If there's a number
which lies in two pair, print it two times (see the sample case #3 for explanation).

Constraints

* 2 <= N <= 2000000
* -10^7 <= ai <= 10^7
* ai != aj, where 1 <= i <= j <= N

Sample Input #1
10
-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854

Sample Output #1
-20 30
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

		for(int i = low; i < high; i++) {
			if(ar[i] <= pivot) {
				swap(ar,holder,i);
				holder++;
			}
		}

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


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int ar[] = new int[n];
		int minDifference = -1;
		StringBuilder differenceDisplay = new StringBuilder();

		for(int i = 0; i < n; i++) {
			ar[i] = scanner.nextInt();
		}

		quickSort(ar, 0, n -1);

		for(int i = 1; i < n; i++) {
			int difference = Math.abs(ar[i] - ar[i-1]);
			if(minDifference == -1 || difference < minDifference) {
				minDifference = difference;
				if(differenceDisplay.length() > 0) {
					differenceDisplay = new StringBuilder();
				}
				differenceDisplay.append(ar[i-1]).append(" ").append(ar[i]).append(" ");
			} else if(difference == minDifference) {
				differenceDisplay.append(ar[i-1]).append(" ").append(ar[i]).append(" ");
			}
		}

		System.out.printf("%s", differenceDisplay);



	}
}
