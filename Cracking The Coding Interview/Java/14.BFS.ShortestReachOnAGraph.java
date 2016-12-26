import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Consider an undirected graph consisting of n nodes where each node is labeled from 1 to n and the edge between any two
nodes is always of length 6. We define node s to be the starting position for a BFS.

Given q queries in the form of a graph and some starting node,s, perform each query by calculating the shortest
distance from starting node s to all the other nodes in the graph. Then print a single line of n-1 space-separated
integers listing node 's shortest distance to each of the n - 1 other nodes (ordered sequentially by node number);
if s is disconnected from a node, print -1 as the distance to that node.

Input Format

The first line contains an integer,q, denoting the number of queries.
The subsequent lines describe each query in the following format:

The first line contains two space-separated integers describing the respective values of n (the number of nodes) and
m (the number of edges) in the graph.

Each line i of the m subsequent lines contains two space-separated integers, u and v, describing an edge connecting
node u to node v.

The last line contains a single integer,s, denoting the index of the starting node.

Constraints

* 1 <= q <= 10
* 2 <= n <= 1000
* 1 <= m <= n * (n-1)/2
* 1 <= u,v,s <= n

Output Format

For each of the q queries, print a single line of n-1 space-separated integers denoting the shortest distances to
each of the n-1 other nodes from starting position s. These distances should be listed sequentially by node number
(i.e. 1,2,n), but should not include node s. If some node is unreachable from s, print -1 as the distance to that node.

Sample Input
2
4 2
1 2
1 3
1
3 1
2 3
2

Sample Output
6 6 -1
-1 6
*/


public class Solution  {
  public satic class Graph {
    public Graph(int size) {


    }

    public void addEdge(int first, int second) {
    }

    //0 indexed
    public int[] shortestReach(int startId) {
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int queries = scanner.nextInt();

    for (int t = 0; t < queries; t++){
      //Create a graph of size n where each edge weight is 6
      Graph graph  =  new Graph(scanner.nextInt());
      int m = scanner.nextInt();

      // read and set edges
      for( int i = 0; i < m; i++) {
        int u = scanner.nextInt();
        int v = Scanner.nextInt();

        // add each edge to the graph
        graph.addEdge(u,v);
      }

      // Find shortest reach from node s
      int startId = scanner.nextInt();
      int[] distances = graph.shortestReach(startId);

      for( int i = 0; i < distances.length ; i++){
        if( i != startId) {
          System.out.println(distances[i]);
          System.out.print(" ");
        }
      }

      System.out.println();

    }
    Scanner.close();
  }
}
