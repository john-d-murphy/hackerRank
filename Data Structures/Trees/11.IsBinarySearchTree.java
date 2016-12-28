
/*
For the purposes of this challenge, we define a binary search tree to be a binary tree with the following ordering
requirements:

The data value of every node in a node's left subtree is less than the data value of that node.
The data value of every node in a node's right subtree is greater than the data value of that node.
Given the root node of a binary tree, can you determine if it's also a binary search tree?

Complete the function in your editor below, which has 1 parameter: a pointer to the root of a binary tree.
It must return a boolean denoting whether or not the binary tree is a binary search tree.
You may have to write one or more helper functions to complete this challenge.

Input Format

You are not responsible for reading any input from stdin.
Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.

Constraints

Output Format

You are not responsible for printing any output to stdout.
Your function must return true if the tree is a binary search tree; otherwise, it must return false.
Hidden code stubs will print this result as a Yes or No answer on a new line.
*/

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

// Crux of this one is that you need to know what the maximum and minimum are -
// so you need to keep some history of the tree.
//
// Use this by creating a helper method.

boolean checkBST(Node root) {

  if(root == null) {
    return true;
  }

  return checkBST(root.left, -1, root.data) && checkBST(root.right, root.data, -1);
}

boolean checkBST(Node root, int min, int max) {

  if (root == null) {
    return true;
  } else if( min > -1 && root.data <= min) {
    return false;
  } else if( max > -1 && root.data >= max) {
    return false;
  } else {
    return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
  }
}
