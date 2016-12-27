
/*
You are given a pointer to the root of a binary tree.
You need to print the level order traversal of this tree.
In level order traversal, we visit the nodes level by level from left to right.
You only have to complete the function.

For example:

         3
       /   \
      5     2
     / \    /
    1   4  6
For the above tree, the level order traversal is 3 -> 5 -> 2 -> 1 -> 4 -> 6.

Input Format

You are given a function,

void level_order(node * root)
{

}
Output Format

Print the values in a single line seperated by a space.

Sample Input

         3
       /   \
      5     2
     / \    /
    1   4  6
Sample Output

3 5 2 1 4 6
Explanation

Level 1:        3
              /   \
Level 2:     5     2
            / \    /
Level 3:   1   4  6
We need to print the nodes level by level. We process each level from left to right.
Level Order Traversal: 3 -> 5 -> 2 -> 1 -> 4 -> 6
*/

/*

    class Node
       int data;
       Node left;
       Node right;
*/

// Simple breadth first traversal
void LevelOrder(Node root) {

  if (root == null) {
    return;
  }

  Queue<Node> traversal = new LinkedList<Node>();
  traversal.add(root);

  while(!traversal.isEmpty()) {
    Node node = traversal.poll();
    System.out.printf("%d ", node.data);

    if( node.left != null) {
      traversal.add(node.left);
    }

    if (node.right != null) {
      traversal.add(node.right);
    }
  }
}

