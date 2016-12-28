import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Greg received an -node tree as a graduation gift, where each node i contains ci coins.
He wants to insert exactly one new node, w, into the tree using the following process:

* Select a node,v, where 1 <= v <= n.
* Create a new edge connecting node v to a new node, w.
* Add cw coins to node w (this can be any non-negative integer).
* Now that Greg's tree has n+1 nodes, he wants to cut two of its edges to create a forest of 3 trees where each tree
  contains an equal number of coins. If such a configuration is possible, he calls it a balanced forest.

For each tree Greg receives as a gift, determine the minimum value of cw such that the tree can be split into a
balanced forest (meaning that each of the forest's three trees have the same number of coins); if no cw exists that
enables Greg to create a balanced forest, print -1 instead.

Input Format

The first line contains a single integer,q, denoting the number of trees gifted to Greg.
The subsequent lines describe each query in the following format:

* The first line contains an integer, n, denoting the number of nodes in the tree.
* The second line contains n space-separated integers describing the respective values of c1,c2,...cn, where each ci
  denotes the number of coins at node i.
* Each line j of the n-1 subsequent lines contains two space-separated integers, xj and yj  (where 1 <= xj,yj <= n),
  describing edge j connecting nodes xj and yj.

Note: It is guaranteed that each query forms a valid undirected tree.

Constraints
* 1 <= q <= 5
* 1 <= n <= 5 * 10^4
* 1 <= ci <= 10^9

Output Format

For each query, print the minimum value of cw on a new line; if no such value exists, print -1 instead.

Sample Input

2
5
1 2 2 1 1
1 2
1 3
3 5
1 4
3
1 3 5
1 3
1 2
Sample Output

2
*/


public class Solution {

	public static class Node {

		private int coins = 0;
		private int nodeID = -1;
		Collection<Node> connectedNodes;

		public Node(int coins, int nodeID) {
			this.coins = coins;
			this.nodeID = nodeID;
			connectedNodes = new ArrayList<Node>();
		}

		public void connectNode(Node connectedNode) {
			connectedNodes.add(connectedNode);
		}

		public Collection<Node> getConnectedNodes() {
			return connectedNodes;
		}

		public int getTreeCoinSum() {
			int treeCoins = coins;
			for(Node node : connectedNodes) {
				int connectedCoins = node.getTreeCoinSum();
				treeCoins += connectedCoins;
			}
			return treeCoins;
		}

		public int getCoinValue() {
			return coins;
		}

		public int getNodeID() {
			return nodeID;
		}

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int queries = scanner.nextInt();

		for(int i = 0; i < queries; i++) {

			int nodes = scanner.nextInt();

			List<Node> tree = new ArrayList<Node>();

			// Get Coins
			for( int j = 0 ; j < nodes; j++) {
				int nodeCoins = scanner.nextInt();
				tree.add(new Node(nodeCoins, j+1));
			}

			// Get Edges (note that array is zero indexed and edges are 1 indexed)
			for( int j = 0 ; j < nodes - 1; j++) {
				int sourceEdge = scanner.nextInt();
				int destinationEdge = scanner.nextInt();
				Node sourceNode = tree.get(sourceEdge-1);
				Node destinationNode = tree.get(destinationEdge-1);
				sourceNode.connectNode(destinationNode);
			}

			System.out.printf("Query: [%d]\n", i);
			for(int j = 0; j < nodes; j++) {
				Node currentNode = tree.get(j);

				System.out.printf("Node [%d] has value [%4d] and is connected to [%d] nodes with tree sum [%d]\n",
						currentNode.getNodeID(),
						currentNode.getCoinValue(),
						currentNode.getConnectedNodes().size(),
						currentNode.getTreeCoinSum());
			}

		}
	}
}
