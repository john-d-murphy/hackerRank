import java.io.*;
import java.util.*;

/*
Consider an undirected graph consisting of n nodes where each node is labeled from 1 to n and the edge between any two
nodes is always of length 6. We define node s to be the starting position for a BFS.

Given q queries in the form of a graph and some starting node, s, perform each query by calculating the shortest
distance from starting node s to all the other nodes in the graph.
Then print a single line of n-1 space-separated integers listing node s's shortest distance to each of the n-1 other
nodes (ordered sequentially by node number); if s is disconnected from a node, print n-1 as the distance to that node.

Input Format

The first line contains an integer,q, denoting the number of queries. The subsequent lines describe each query in the
following format:

* The first line contains two space-separated integers describing the respective values of n (the number of nodes) and
  m (the number of edges) in the graph.

* Each line i of the m subsequent lines contains two space-separated integers,u and v, describing an edge connecting
  node u to node v.

* The last line contains a single integer,s, denoting the index of the starting node.

Constraints

* 1 <= q <= 10
* 2 <= n <= 1000
* 1 <= m <= n(n-1)/2
* 1 <= u,v,s <= n

Output Format

For each of the q queries, print a single line of n-1 space-separated integers denoting the shortest distances to each
of the n-1 other nodes from starting position s. These distances should be listed sequentially by node number
(i.e.1,2...n), but should not include node s. If some node is unreachable from s, print -1 as the distance to that node.

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

  public static class Node {
    int value;
    Set<Integer> connectedNodes;

    public Node(int value) {
      this.value = value;
      connectedNodes = new HashSet<Integer>();
    }

    public boolean equals(Object o) {
      if( !(o instanceof Node)) {
        return false;
      }

      Node otherNode = (Node) o;

      return (otherNode.value == value);
    }
  }



  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int queries = Integer.valueOf(reader.readLine());

    for(int i = 0; i < queries; i++) {

      // Populate Data
      String nextLine[] = reader.readLine().split(" ");
      int nodeCount = Integer.valueOf(nextLine[0]);
      int edgeCount = Integer.valueOf(nextLine[1]);
      Node nodes[] = new Node[nodeCount];
      int distances[] = new int[nodeCount];
      int visitedNodes[] = new int[nodeCount];

      for(int j = 0; j < nodeCount; j++) {
        nodes[j] = new Node(j);
        distances[j] = -1;
        visitedNodes[j] = -1;
      }

      for(int j = 0; j < edgeCount; j++) {
        nextLine = reader.readLine().split(" ");
        int edge1 = Integer.valueOf(nextLine[0])-1;
        int edge2 = Integer.valueOf(nextLine[1])-1;

        //ystem.out.printf("Edge1: %d - Edge2:%d\n", edge1, edge2);

        nodes[edge1].connectedNodes.add(edge2);
        nodes[edge2].connectedNodes.add(edge1);
      }

      int startIndex = Integer.valueOf(reader.readLine().trim()) - 1;

      // Run BFS
      Queue<Integer> traversal = new ArrayDeque<Integer>();
      traversal.add(startIndex);
      distances[startIndex] = 0;
      visitedNodes[startIndex] = 1;

      while(!traversal.isEmpty()) {
        int currentIndex = traversal.poll();
        Node node = nodes[currentIndex];
        for(Integer linkedIndex : node.connectedNodes) {

          if(visitedNodes[linkedIndex] != 1) {
            //System.out.printf("Current Index: %d - Adding index: %d\n", currentIndex, linkedIndex);
            distances[linkedIndex] = distances[currentIndex] + 6;
            visitedNodes[linkedIndex] = 1;
            traversal.add(linkedIndex);
          }
        }
      }

      for(int j = 0; j < nodes.length; j++) {
        if(j != startIndex) {
          System.out.printf("%d ", distances[j]);
        }
      }

      System.out.printf("\n");
    }

  }
}

