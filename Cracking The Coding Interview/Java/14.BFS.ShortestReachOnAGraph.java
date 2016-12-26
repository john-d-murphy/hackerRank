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

The first line contains an integer, q, denoting the number of queries.
The subsequent lines describe each query in the following format:

The first line contains two space-separated integers describing the respective values of n (the number of nodes) and
m (the number of edges) in the graph.

Each line i of the m subsequent lines contains two space-separated integers, u and v, describing an edge connecting
node u to node v.

The last line contains a single integer, s, denoting the index of the starting node.

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

public class Solution {

  public static class Graph {

    Map<Integer, Set<Integer>> localGraph;

    public Graph(int size) {
      localGraph = new HashMap<Integer, Set<Integer>>();
      for(int i = 1; i <= size; i++) {
        localGraph.put(i, new HashSet<Integer>());
      }
    }

    public void addEdge(int first, int second) {
      localGraph.get(first).add(second);
      localGraph.get(second).add(first);
    }

    public int[] shortestReach(int startId) {
      int[] distances = new int[localGraph.size()+1];
      Arrays.fill(distances, -1);

      Set<Integer> visitedNodes   = new HashSet<Integer>();
      Queue<Integer> nodesToVisit = new LinkedList<Integer>();
      nodesToVisit.add(startId);

      distances[startId] = 0;

      while( nodesToVisit.size() > 0) {

        Integer currentNode = nodesToVisit.poll();
        visitedNodes.add(currentNode);

        for( Integer i : localGraph.get(currentNode)) {
          if( !visitedNodes.contains(i)){
            nodesToVisit.add(i);
            visitedNodes.add(i);
            distances[i] = distances[currentNode] + 1;
          }
        }
      }

      return distances;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int queries = scanner.nextInt();

    for (int query = 0;  query < queries; query++){
      //Create the graph
      Integer edges = scanner.nextInt();
      Graph graph   = new Graph(edges);
      int m         = scanner.nextInt();

      // read and set edges
      for( int i = 0; i < m; i++) {
        int first  = scanner.nextInt();
        int second = scanner.nextInt();

        // add each edge to the graph
        graph.addEdge(first,second);
      }

      // Find shortest reach from node s
      int startId = scanner.nextInt();
      int[] distances = graph.shortestReach(startId);

      for( int i = 1; i < distances.length ; i++){
        if( i != startId && distances[i] > -1) {
          System.out.printf("%d ",distances[i] * 6);
        } else if( i != startId && distances[i] == -1) {
          System.out.printf("%d ",distances[i]);
        }
      }

      System.out.printf("\n");
    }

    scanner.close();
  }
}
