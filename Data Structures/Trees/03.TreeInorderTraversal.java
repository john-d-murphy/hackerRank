
/*
Complete the inOrder function in your editor below, which has 1 parameter: a pointer to the root of a binary tree.
It must print the values in the tree's inorder traversal as a single line of space-separated values.

Input Format
Our hidden tester code passes the root node of a binary tree to your inOrder function.

Output Format
Print the tree's inorder traversal as a single line of space-separated values.
*/

/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

void inOrder(Node root) {

  if(root == null) {
    return;
  }

  inOrder(root.left);
  System.out.printf("%d ", root.data);
  inOrder(root.right);
}

