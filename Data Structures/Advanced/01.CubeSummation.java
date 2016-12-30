import java.io.*;
import java.util.*;
import java.math.BigInteger;

/*
You are given a 3-D Matrix in which each block contains 0 initially.
The first block is defined by the coordinate (1,1,1) and the last block is defined by the coordinate (N,N,N).
There are two types of queries.

UPDATE x y z W
updates the value of block (x,y,z) to W.

QUERY x1 y1 z1 x2 y2 z2
calculates the sum of the value of blocks whose x coordinate is between x1 and x2 (inclusive),
y coordinate between y1 and y2 (inclusive) and z coordinate between z1 and z2 (inclusive).

Input Format

The first line contains an integer T, the number of test-cases.
T testcases follow.
For each test case, the first line will contain two integers N and M separated by a single space.
N defines the N * N * N matrix.
M defines the number of operations.
The next M lines will contain either

 1. UPDATE x y z W
 2. QUERY  x1 y1 z1 x2 y2 z2

Output Format
Print the result for each QUERY.

Constrains
1 <= T <= 50
1 <= N <= 100
1 <= M <= 1000
1 <= x1 <= x2 <= n
1 ≤ y1 <= y2 <= N
1 <= Z1 <= Z2 < = N
1 ≤ x, y, z ≤ N
-10 9 <= w <= 10 9

Sample Input

2
4 5
UPDATE 2 2 2 4
QUERY 1 1 1 3 3 3
UPDATE 1 1 1 23
QUERY 2 2 2 4 4 4
QUERY 1 1 1 3 3 3
2 4
UPDATE 2 2 2 1
QUERY 1 1 1 1 1 1
QUERY 1 1 1 2 2 2
QUERY 2 2 2 2 2 2
Sample Output

4
4
27
0
1
1
Explanation
First test case, we are given a cube of 4 * 4 * 4 and 5 queries. Initially all the cells (1,1,1) to (4,4,4) are 0.
UPDATE 2 2 2 4 makes the cell (2,2,2) = 4
QUERY 1 1 1 3 3 3. As (2,2,2) is updated to 4 and the rest are all 0.
The answer to this query is 4.
UPDATE 1 1 1 23. updates the cell (1,1,1) to 23.
QUERY 2 2 2 4 4 4.
Only the cell (1,1,1) and (2,2,2) are non-zero and (1,1,1) is not between (2,2,2) and (4,4,4). So, the answer is 4.
QUERY 1 1 1 3 3 3. 2 cells are non-zero and their sum is 23+4 = 27.
*/

public class Solution {

  public static final String UPDATE = "UPDATE";
  public static final String QUERY = "QUERY";

  public static class Node {

    int x;
    int y;
    int z;
    BigInteger value;

    public Node(int x, int y, int z, BigInteger value) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.value = value;
    }

    @Override
    public String toString() {
      return "X: " + x + " Y: " + y + " Z: " + z +  " Value: " + value.toString();
    }

    @Override
    public int hashCode() {
      return x * y * z;
    }

    @Override
    public boolean equals(Object obj) {
      if(!(obj instanceof Node)) {
        return false;
      }

      Node compareTo = (Node) obj;

      return (x == compareTo.x && y == compareTo.y && z == compareTo.z);
    }
  }

  public static BigInteger query(Set<Node> matrix, int xstart, int ystart, int zstart, int xend, int yend, int zend) {
    BigInteger sum = new BigInteger("0");
    Set<Node> valid = new HashSet<Node>();

    for(Node node : matrix) {
      //System.out.printf("%s\n", node.toString());
      if(node.x >= xstart && node.x <= xend && node.y >= ystart && node.y <= yend &&
        node.z >= zstart && node.z <= zend) {
        valid.add(node);
      }
    }

    for(Node node : valid) {
      sum = sum.add(node.value);
      //System.out.printf("%s - %s\n", node.toString(), sum.toString());
    }

    return sum;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = scanner.nextInt();

    for(int i = 0; i < testCases; i++) {
      int size = scanner.nextInt();
      int operations = scanner.nextInt();
      //System.out.printf("Size: %d - Operations: %d\n", size, operations);
      String noop = scanner.nextLine(); // Chomp
      Set<Node> matrix = new HashSet<Node>();
      for( int j = 0; j < operations; j ++) {
        String operation = scanner.nextLine();
        //System.out.printf("Operation: %s\n", operation);
        String data[] = operation.split(" ");
        if (UPDATE.equals(data[0])) {
          int x = Integer.valueOf(data[1]);
          int y = Integer.valueOf(data[2]);
          int z = Integer.valueOf(data[3]);
          BigInteger value = new BigInteger(data[4]);
          Node node = new Node(x,y,z,value);
          matrix.remove(node);
          matrix.add(node);
        } else {
          BigInteger value = query(matrix, Integer.valueOf(data[1]), Integer.valueOf(data[2]), Integer.valueOf(data[3]), Integer.valueOf(data[4]), Integer.valueOf(data[5]), Integer.valueOf(data[6]));
          System.out.printf("%s\n", value);
        }
      }
    }
  }
}

