import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool together m dollars for ice cream.
On any given day, the parlor offers a line of n flavors. Each flavor,i, is numbered sequentially with a unique ID
number from 1 to n and has a cost,ci, associated with it.

Given the value of m and the cost of each flavor for t trips to the Ice Cream Parlor, help Sunny and Johnny choose
two flavors such that they spend their entire pool of money (m) during each visit.
For each trip to the parlor, print the ID numbers for the two types of ice cream that Sunny and Johnny purchase as
two space-separated integers on a new line. You must print the smaller ID first and the larger ID second.

Note: Two ice creams having unique IDs i and j may have the same cost (i.e. ci == cj).

Input Format

The first line contains an integer,t, denoting the number of trips to the ice cream parlor.
The 3t subsequent lines describe all of Sunny and Johnny's trips to the parlor; each trip is described as follows:

1) The first line contains m.
2) The second line contains n.
3) The third line contains n space-separated integers denoting the cost of each respective flavor.
The ith integer corresponds to the cost,ci, for the ice cream with ID number i (where 1 <= i <= n).

Constraints
* 1 <= t <= 50
* 2 <= m <= 10^4
* 2 <= n <= 10^4
* 1 <= ci <= 10^4, where i in [1,n]
* It is guaranteed that there will always be a unique solution.

Output Format

Print two space-separated integers denoting the respective ID numbers for the flavors they choose to purchase,
where the smaller ID is printed first and the larger ID is printed second.
Recall that each ice cream flavor has a unique ID number in the inclusive range from 1 to n.

Sample Input

2
4
5
1 4 5 3 2
4
4
2 2 4 3
Sample Output

1 4
1 2
*/

class IceCream implements Comparable{
    int flavor;
    int index;

    public IceCream(int flavor, int index) {

    }

    @Override
    public int compareTo(Object o) {

    }

    @Override
    public boolean equals(Object o){

    }

}

public class Solution {

  public static int binarySearch(int first, int last, IceCream[] arr, int search) {


  }

  public static void main(String[] args) {

    int t;
    int n, m;

    Scanner in = new Scanner(System.in);
    t = in.nextInt();
    for(int test = 0; test < t; test++) {

      m = in.nextInt();
      n = in.nextInt();
      IceCream[] arr = new IceCream[n];

      for (int i = 0; i < n; i++)
        arr[i] = new IceCream(in.nextInt(), i + 1);

      Arrays.sort(arr);
      int firstIndex = 100000, secondIndex = 100000;
      for(int i = 0; i < n - 1 ; i++) {
        int search = m - arr[i].flavor;
        if(search >= arr[i].flavor) {
          int index = binarySearch( i + 1, n - 1, arr, search);
          if( index != -1 ) {
            System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
            break;

          }
        }
      }

    }

  }

}

