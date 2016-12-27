import java.util.*;
import java.io.*;

/*
The height of a binary tree is the number of edges between the tree's root and its furthest leaf.
This means that a tree containing a single node has a height of 0.

Complete the getHeight function provided in your editor so that it returns the height of a binary tree.
This function has a parameter,root, which is a pointer to the root node of a binary tree.

Input Format
You do not need to read any input from stdin. Our grader will pass the root node of a binary tree to your getHeight function.

Output Format
Your function should return a single integer denoting the height of the binary tree.
*/

class Node {
  Node left,right;
	int data;
	Node(int data){
		this.data=data;
		left=right=null;
	}
}

class Solution {

  //// MY CODE START
  static int getHeight(Node root) {
    if( root == null) {
      return 0;
    } else if (root.left == null && root.right == null) {
      return 0;
    } else {
      return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
  }
  //// MY CODE END

  public static Node insert(Node root,int data){
    if(root==null){
      return new Node(data);
    }
    else{
      Node cur;
      if(data<=root.data){
        cur=insert(root.left,data);
        root.left=cur;
      }
      else{
        cur=insert(root.right,data);
        root.right=cur;
      }
      return root;
    }
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int T=sc.nextInt();
    Node root=null;
    while(T-->0){
      int data=sc.nextInt();
      root=insert(root,data);
    }
    int height=getHeight(root);
    System.out.println(height);
  }
}



