import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*

* Create a list, seqList, of N empty sequences, where each sequence is indexed from 0 to N-1.
  The elements within each of the N sequences also use 0-indexing.
* Create an integer, lastAns, and initialize it to 0.
* There are 2 types of queries that can be performed on your list of sequences (seqList) are described below:

  1) Query: 1 x y
     * Find the sequence,seq, at index ((x xor lastAns) % N) in seqList.
     * Append integer y to sequence seq.
  2) Query: 2 x y
     * Find the sequence,seq, at index ((x xor lastAns) % N) in seqList.
     * Find the element y % size in seq (where size is the size of seq) and
       assign it to lastAns.
     * Print the new value of lastAns on a new line.

Task
Given N, Q, and Q queries, execute each query.

Input Format

The first line contains two space-separated integers, N (the number of sequences) and Q (the number of queries),
respectively. Each of the Q subsequent lines contains a query in the format defined above.

Constraints
* 1 <= N,Q <= 10^5
* 0 <= x <= 10^9
* 0 <= y <= 10^9
* It is guaranteed that query type 2 will never query an empty sequence or
  index.

Output Format
For each type 2 query, print the updated value of lastAns on a new line.

Sample Input

2 5
1 0 5
1 1 7
1 0 3
2 1 0
2 1 1
Sample Output

7
3
*/

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int seqs = scanner.nextInt();
    int queries = scanner.nextInt();
    int lastAns = 0;
    ArrayList<ArrayList<Integer>> sequences = new ArrayList<ArrayList<Integer>>();

    for( int i = 0 ; i < seqs; i++) {
      sequences.add(new ArrayList<Integer>());
    }

    for( int i = 0; i< queries; i++) {
      int queryType = scanner.nextInt();
      int x = scanner.nextInt();
      int y = scanner.nextInt();

      if (queryType == 1) {
        int seq = (x ^ lastAns) % seqs;
        sequences.get(seq).add(y);
      } else {
        int seq = (x ^ lastAns) % seqs;
        int element = y % sequences.get(seq).size();
        lastAns = sequences.get(seq).get(element);
        System.out.printf("%d\n", lastAns);
      }
    }
  }
}
