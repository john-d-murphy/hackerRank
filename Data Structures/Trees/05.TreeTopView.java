
/*
You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
You only have to complete the function.
For example :

     3
   /   \
  5     2
 / \   / \
1   4 6   7
 \       /
  9     8
Top View : 1 -> 5 -> 3 -> 2 -> 7
Input Format

You are given a function,

void top_view(node * root)
{

}
Output Format

Print the values on a single line separated by space.

Sample Input

     3
   /   \
  5     2
 / \   / \
1   4 6   7
 \       /
  9     8
Sample Output

1 5 3 2 7
Explanation

     3
   /   \
  5     2
 / \   / \
1   4 6   7
 \       /
  9     8
From the top only nodes 1,5,3,2 and 7 will be visible.
*/

/*
   class Node
       int data;
       Node left;
       Node right;
*/

// Super contrived example - biggest issue is printing the left
// side in reverse order. Just did this with a string instead of
// any fancy recursion.

void top_view(Node root) {
  if(root == null) {
    return;
  }

  ArrayList<Integer> topView = new ArrayList<Integer>();

  // Print left
  StringBuilder left = new StringBuilder();
  Node leftNode = root.left;
  while(leftNode != null) {
    left.append(leftNode.data).append(" ");
    leftNode = leftNode.left;
  }

  System.out.printf("%s", left.reverse().toString().trim());

  // Print root
  System.out.printf(" %d ", root.data);

  // Print right
  Node rightNode = root.right;
  while(rightNode != null) {
    System.out.printf("%d ", rightNode.data);
    rightNode = rightNode.right;
  }

}
