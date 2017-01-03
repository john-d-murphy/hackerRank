import java.io.*;
import java.util.*;

/*
Given a graph consisting N nodes (labelled 1 to N) where a specific given node S represents the starting position S
and an edge between two nodes is of a given length, which may or may not be equal to other lengths in the graph.

It is required to calculate the shortest distance from the start position (Node S) to all of the other nodes in the
graph.

Note: If a node is unreachable, the distance is assumed as -1.

Input Format

The first line contains T, denoting the number of test cases.
First line of each test case has two integers N, denoting the number of nodes in the graph and M, denoting the number
of edges in the graph.

The next M lines each consist of three space-separated integers x,y,r, where x and y denote the two nodes between
which the undirected edge exists, r denotes the length of edge between these corresponding nodes.

The last line has an integer S, denoting the starting position.

Constraints:

* 1 <= T <= 10
* 2 <= N <= 3000
* 1 <= M <= N(N-1)/2
* 1 <= x,y,S <= N
* 1 <= r <= 10^5

If there are edges between the same pair of nodes with different weights, they are to be considered as is,
like multiple edges.

Output Format

For each of the T test cases, print a single line consisting N-1 space separated integers denoting the shortest
distance of N-1 nodes other than S from starting position S in increasing order of their labels.

For unreachable nodes, print -1

Sample Input

1
4 4
1 2 24
1 4 20
3 1 3
4 3 12
1
Sample Output

24 3 15
*/

public class Solution {

  public static class Node {
    int nodeID;
    Set<Edge> edges;

    public Node(int nodeID) {
      this.nodeID = nodeID;
      edges = new HashSet<Edge>();
    }

    public boolean equals(Object o) {
      if(!(o instanceof Node)) {
        return false;
      }

      Node otherNode = (Node) o;

      return (otherNode.nodeID == nodeID);
    }

    public String toString() {
      StringBuilder s = new StringBuilder();
      s.append("ID:").append(nodeID).append("\n");
      for(Edge edge : edges) {
        s.append("\t").append(edge.toString()).append("\n");
      }

      return s.toString();
    }
  }

  public static class Edge {
    final Node first;
    final Node second;
    final int weight;
    final int hashCode;
    final String display;

    public Edge(Node first, Node second, int weight) {
      this.first = first;
      this.second = second;
      this.weight = weight;
      hashCode = Integer.valueOf((first.nodeID + second.nodeID + weight));
      display = first.nodeID + " <-" + weight + "-> " + second.nodeID;
    }

    public boolean equals(Object o) {
      if(!(o instanceof Edge)) {
        return false;
      }

      Edge otherEdge = (Edge) o;

      return (otherEdge.first.equals(first) && otherEdge.second.equals(second) && otherEdge.weight == weight);
    }

    public int hashCode() {
      return hashCode;
    }

    public String toString() {
      return display;
    }
  }

  public static int getMinDistanceNode(Set<Integer> unvisitedNodes, int distances[]) {
    int minDistanceNode = -1;
    for (Integer nodeID : unvisitedNodes) {
      //System.out.printf("Node: %d - Distance: %d\n", node.nodeID, distances[node.nodeID]);
      if (distances[nodeID] >= 0 && (minDistanceNode == -1 || distances[nodeID] < distances[minDistanceNode])) {
        minDistanceNode = nodeID;
      }
    }
    //System.out.printf("Minimum Distance Node:%d\n", minDistanceNode);
    return minDistanceNode;
  }

  public static void djikstra(Node[] nodes, int source, int distances[], int previous[]) {

    // Assume distances and previous are both initialized to -1

    // Data Structures needed for path traversal
    Set<Integer> unvisitedNodes = new HashSet<Integer>();
    Node sourceNode = nodes[source];

    // Initialize values
    for(int i = 0; i < nodes.length; i++) {
      unvisitedNodes.add(i);
    }

    distances[source] = 0;

    // Traverse graph and get shortest distances
    while(!unvisitedNodes.isEmpty()) {
      int minDistanceNode = getMinDistanceNode(unvisitedNodes, distances);

      if(minDistanceNode == -1) {
        return;
      }

      Node node = nodes[minDistanceNode];
      unvisitedNodes.remove(node.nodeID);

      //System.out.printf("\n-----------------------------\n");
      //System.out.printf("Min Distance Node: %d\n", minDistanceNode);

      for(Edge edge : node.edges) {
        if(unvisitedNodes.contains(edge.first.nodeID) || unvisitedNodes.contains(edge.second.nodeID)) {
          int potentialDistance = edge.weight + distances[minDistanceNode];
          //System.out.printf("Potential Distance: %d\n", potentialDistance);
          int firstNodeID = edge.first.nodeID;
          int secondNodeID = edge.second.nodeID;

          if( distances[firstNodeID] == -1 || potentialDistance < distances[firstNodeID]) {
            //System.out.printf("Setting %d distance to %d\n", firstNodeID, potentialDistance);
            distances[firstNodeID] = potentialDistance;
            previous[firstNodeID] = node.nodeID;
          }

          if( distances[secondNodeID] == -1 || potentialDistance < distances[secondNodeID]) {
            //System.out.printf("Setting %d distance to %d\n", secondNodeID, potentialDistance);
            distances[secondNodeID] = potentialDistance;
            previous[secondNodeID] = node.nodeID;
          }
        }
      }
    }
  }

  // This requires a "fast reader" to handle all of the input in the 7th case.
  // Using a buffered reader for this works - benchmark of speed difference can
  // be found here:
  // https://www.cpe.ku.ac.th/~jim/java-io.html
  //
  // Short version:
  // Table 2. Time to read 10,000,000 double values from file
  // Input Method	Time (sec)
  // C scanf("%lf", &arg)	11.9
  // Scanner.parseDouble()	66.86
  // BufferedReader + inline Double.parseDouble	3.06
  // BufferedReader + Reader.nextDouble method	3.14

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int testCases = Integer.parseInt(reader.readLine());
    for(int t = 0; t < testCases; t++) {
      String testInfo[] = reader.readLine().split(" ");
      int nodeCount = Integer.valueOf(testInfo[0]);
      int edgeCount = Integer.valueOf(testInfo[1]);

      Node nodes[] = new Node[nodeCount];
      int distances[] = new int[nodeCount];
      int previous[] = new int[nodeCount];

      for(int n = 0; n < nodeCount; n++) {
        nodes[n] = new Node(n);
        distances[n] = -1;
        previous[n] = -1;
      }

      for(int e = 0; e < edgeCount; e++) {
        String testCase[] = reader.readLine().split(" ");
        int node1 = Integer.valueOf(testCase[0]) - 1; // Input not zero-indexed
        int node2 = Integer.valueOf(testCase[1]) - 1;
        int weight = Integer.valueOf(testCase[2]);

        Node first = nodes[node1];
        Node second = nodes[node2];

        Edge edge = new Edge(first, second, weight);

        first.edges.add(edge);
        second.edges.add(edge);
      }

      int startNode = Integer.valueOf(reader.readLine()) -1;
      int distance[] = new int[nodeCount];

      /*
         System.out.printf("Start Node: %d\n", startNode);

         for(int n = 0; n < nodeCount; n++) {
         System.out.printf("%s\n", nodes[n].toString());
         }
         */

      djikstra(nodes,startNode,distances,previous);

      for(int i = 0; i < nodes.length; i++) {
        if(i != startNode) {
          System.out.printf("%d ", distances[i]);
        }
      }
      System.out.printf("\n");
    }
  }
}
