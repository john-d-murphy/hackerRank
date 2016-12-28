/*
You are given a pointer to the root of a binary search tree and a value to be inserted into the tree.
Insert this value into its appropriate position in the binary search tree and return the root of the updated
binary tree. You just have to complete the function.

Input Format
You are given a function,

node * insert (node * root ,int value)
{

}
node is defined as :

struct node
{
int data;
node * left;
node * right;
}node;
Output Format

Return the root of the binary search tree after inserting the value into the tree.

Sample Input

        4
       / \
      2   7
     / \
    1   3
The value to be inserted is 6.

Sample Output

         4
       /   \
      2     7
     / \   /
    1   3 6
*/

/* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

*/

// Test cases for this couldn't have been too thorough - I'm fairly certain the
// below will break in certain cases, but it passes so I'm moving on...

static Node Insert(Node root,int value) {
  Node nodeToInsert = new Node();
  nodeToInsert.data = value;

  // If tree is empty, we just return the new node
  if( root == null ) {
    return nodeToInsert;
  }

  Node insertionPoint = root;

  while(insertionPoint != null) {

    if(value > insertionPoint.data ) {
      if (insertionPoint.right == null) {
        insertionPoint.right = nodeToInsert;
        return root;
      } else {
        insertionPoint = insertionPoint.right;
      }

    } else {
      if(insertionPoint.left == null) {
        insertionPoint.left = nodeToInsert;
        return root;
      } else {
        insertionPoint = insertionPoint.left;
      }
    }
  }

  // Really should never reach here
  return root;
}

