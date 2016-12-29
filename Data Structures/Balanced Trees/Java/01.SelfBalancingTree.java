
/*
An AVL tree (Georgy Adelson-Velsky and Landis' tree, named after the inventors) is a self-balancing binary search tree.
In an AVL tree, the heights of the two child subtrees of any node differ by at most one; if at any time they differ
by more than one, rebalancing is done to restore this property.

We define balance factor for each node as :
  balanceFactor = height(left subtree) - height(right subtree)

The balance factor of any node of an AVL tree is in the integer range [-1,+1].
If after any modification in the tree, the balance factor becomes less than −1 or greater than +1,
the subtree rooted at this node is unbalanced, and a rotation is needed.

(https://en.wikipedia.org/wiki/AVL_tree)

You are given a pointer to the root of an AVL tree.
You need to insert a value into this tree and perform the necessary rotations to ensure that it remains balanced.

Input Format
You are given a function,

node *insert(node * root,int new_val)
{


}
'node' is defined as :

struct node
{
  int val;            //value
  struct node* left;  //left child
  struct node* right; //right child
  int ht;             //height of the node
} node;

You only need to complete the function.

Note: All the values in the tree will be distinct.

Output Format

Insert the new value into the tree and return a pointer to the root of the tree. Ensure that the tree remains balanced.

Sample Input

    3
  /  \
 2    4
       \
        5
The value to be inserted is 6.

Sample Output

    3
  /  \
 2    5
     / \
    4   6

Explanation

After inserting 6 in the tree. the tree becomes:

    3 (Balance Factor = -2)
  /  \
 2    4 (Balance Factor = -2)
       \
        5 (Balance Factor = -1)
         \
          6 (Balance Factor = 0)

Balance Factor of nodes 3 and 4 is no longer in the range [-1,1].
We need to perform a rotation to balance the tree.
This is the right right case.
We perform a single rotation to balance the tree.

After performing the rotation, the tree becomes :

                              3 (Balance Factor = -1)
                            /   \
      (Balance Factor = 0) 2     5 (Balance Factor = 0)
                                / \
          (Balance Factor = 0) 4   6 (Balance Factor = 0)
*/

/* Class node is defined as :
   class Node
     int val;     //Value
     int ht;      //Height
     Node left;   //Left child
     Node right;  //Right child

*/

static Node insert(Node root,int val) {
  Node toInsert = new Node();
  toInsert.val = val;
  toInsert.ht = 0;

  root = insert(root, toInsert);
  //preOrder(root);
  //System.out.printf("\n");

  // System.out.printf("Left Value: [%d]\n", root.left.val);
  // System.out.printf("Right Value: [%d]\n", root.right.val);

  return root;
}

static int balanceFactor(Node root) {

  if(root == null) {
    //System.out.printf("Root null - returning 0");
    return 0;
  } else {
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    //System.out.printf("Balance Factor - Val: [%d] - Left: [%d] - Right: [%d]\n", root.val, leftHeight, rightHeight);
    return getHeight(root.left) - getHeight(root.right);
  }
}

static void preOrder(Node node) {
  if (node != null) {
    System.out.print(node.val + "(BF=" + balanceFactor(node) + ") (H=" + node.ht +") | ");
    preOrder(node.left);
    preOrder(node.right);
  }
}

static Node insert(Node root, Node toInsert) {

  // Base Case
  if(root == null) {
    //System.out.printf("Hit base case - returning toInsert with value [%d]\n", toInsert.val);
    return toInsert;
  }

  //System.out.printf("Calling insert with root [%d], height [%d], and insert value [%d]\n", root.val, root.ht, toInsert.val);

  // Base insertion
  if(toInsert.val < root.val) {
    //System.out.printf("Inserting Left\n");
    root.left = insert(root.left, toInsert);
  } else {
    //System.out.printf("Inserting Right\n");
    root.right = insert(root.right, toInsert);
  }

  // Update Height
  root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  //System.out.printf("Root [%d] height updated to: [%d]\n", root.val, root.ht);

  // Get Balance Factor
  int balance = balanceFactor(root);
  //System.out.printf("Balance Factor: [%d]\n", balance);

  // If Unbalanced, balance the tree in one of four ways
  if (balance > 1 && toInsert.val < root.left.val) {
    //System.out.printf("Right Rotate\n");
    return rightRotate(root);
  } else if (balance > 1 && toInsert.val > root.left.val) {
    //System.out.printf("Left -> Right Rotate\n");
    root.left = leftRotate(root.left);
    return rightRotate(root);
  } else if(balance < -1 && toInsert.val > root.right.val) {
    //System.out.printf("Left Rotate\n");
    return leftRotate(root);
  } else if(balance < -1 && toInsert.val < root.right.val) {
    //System.out.printf("Right -> Left Rotate\n");
    root.right = rightRotate(root.right);
    return leftRotate(root);
  }

  //System.out.printf("Balance Factor within tolerance - returning\n");

  return root;
}

static int getHeight(Node root) {
  if(root == null) {
    return -1;
    //} else if( root.left == null && root.right == null) {
    //   return root.ht;
} else {
  return root.ht;
  //return 1 + Math.max(getHeight(root.left), getHeight(root.right));
  //return 1 + Math.max(root.left.)
}
}

static Node leftRotate(Node root) {
  Node newRoot = root.right;
  Node pivot   = newRoot.left;

  // Rotation
  newRoot.left = root;
  root.right = pivot;

  // Reset Tree Height
  root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  newRoot.ht = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

  //System.out.printf("New Root After Left Rotate: [%d]\n",newRoot.val);
  //System.out.printf("Left Node After Left Rotate: [%d]\n", newRoot.left.val);
  //System.out.printf("Right Node After Left Rotate: [%d]\n", newRoot.right.val);

  // Return new root
  return(newRoot);
}

static Node rightRotate(Node root) {
  Node newRoot = root.left;
  Node pivot = newRoot.right;

  // Rotation
  newRoot.right = root;
  root.left = pivot;

  // Reset Tree Height
  root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  newRoot.ht = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

  // Return new Root
  return(newRoot);

}
