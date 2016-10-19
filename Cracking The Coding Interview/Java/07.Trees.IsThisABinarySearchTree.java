// One of the methods with hidden values - trick for this one is finding if the
// tree has duplicate values. To do this, we need to keep a running tally of
// what our highest and our lowest possible values can be. 

/*
For the purposes of this challenge, we define a binary search tree to be a binary tree with 
the following ordering properties:

The data value of every node in a node's left subtree is less than the data value of that node.
The data value of every node in a node's right subtree is greater than the data value of that node.

Given the root node of a binary tree, can you determine if it's also a binary search tree?

Complete the function in your editor below, which has 1 parameter: a pointer to the root of a binary tree. 
It must return a boolean denoting whether or not the binary tree is a binary search tree. 
You may have to write one or more helper functions to complete this challenge.

Note: A binary tree is not a binary search if there are duplicate values.

Input Format

You are not responsible for reading any input from stdin. 
Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.

Constraints
0 <= data <= 10^4
*/


/* Hidden stub code will pass a root argument to the function below. 
   Complete the function to solve the challenge. 
   Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

boolean checkBST(Node root) {
  return isBST(root, -1, -1);
}

boolean isBST(Node root, int lowValue, int highValue) {
  if(root == null) {
    return true;
  } else if (lowValue >= 0 && root.data <= lowValue) {
    return false;
  } else if (highValue >= 0 && root.data >= highValue) {
    return false;
  } 

  return (isBST(root.left,lowValue,root.data) && isBST(root.right,root.data,highValue) );
}

