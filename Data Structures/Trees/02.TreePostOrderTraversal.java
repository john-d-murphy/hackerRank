/*
Complete the postOrder function in your editor below, which has 1 parameter:
a pointer to the root of a binary tree.
It must print the values in the tree's postorder traversal as a single line of space-separated values.

Input Format
Our hidden tester code passes the root node of a binary tree to your postOrder function.

Output Format
Print the tree's postorder traversal as a single line of space-separated values.
*/

/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/
void postOrder(Node root) {

  if( root == null) {
    return;
  }

  postOrder(root.left);
  postOrder(root.right);
  System.out.printf("%d ", root.data);
}

