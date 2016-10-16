import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
Check out the resources on the page's right side to learn more about arrays. 
The video tutorial is by Gayle Laakmann McDowell, author of the best-selling 
interview book Cracking the Coding Interview.

A left rotation operation on an array of size shifts each of the array's elements 1 unit to the left. 
For example, if left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].

Given an array of n integers and a number,d, perform left rotations on the array. 
Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values 
of n (the number of integers) and d (the number of left rotations you must perform).
The second line contains space-separated integers describing the respective elements of the array's initial state.

Constraints

Output Format

Print a single line of space-separated integers denoting the final state of the array after performing left rotations.

Sample Input

5 4
1 2 3 4 5

Sample Output

5 1 2 3 4

*/

public class Solution {
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
		// Figure out number of rotations actually needed by modding
		// the value - we can only have max n-1 rotations.
		int actualRotations = k % n;
		int newArray[]      = new int[n];
		int currentIndex    = 0;

		for (int i = actualRotations ; i < n ; i++ ) {
			newArray[currentIndex] = a[i];
			currentIndex++;
		}

		for (int i = 0; i < actualRotations; i++ ) {
			newArray[currentIndex] = a[i];
			currentIndex++;
		}

		return newArray;
	}
    
	public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        
		for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();

        }

        int[] output = new int[n];

        output = arrayLeftRotation(a, n, k);

        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();
    }

}
