#include <iostream>
#include <cstddef>
#include <queue>
#include <string>
#include <cstdlib>

/*
Objective
Today, we're going further with Binary Search Trees. Check out the Tutorial tab for learning
materials and an instructional video!

Task
A level-order traversal, also known as a breadth-first search, visits each level of a tree's nodes
from left to right, top to bottom. You are given a pointer,root, pointing to the root of a binary search tree.
Complete the levelOrder function provided in your editor so that it prints the level-order traversal of
the binary search tree.

Hint: You'll find a queue helpful in completing this challenge.

Input Format

The locked stub code in your editor reads the following inputs and assembles them into a BST:
The first line contains an integer, T (the number of test cases).
The T subsequent lines each contain an integer,data, denoting the value of an element that must be added
to the BST.

Output Format

Print the data value of each node in the tree's level-order traversal as a single line of N space-separated
integers.

Sample Input
6
3
5
4
7
2
1

Sample Output

3 2 5 1 4 7
*/

class Node {
public:
  int data;
  Node *left,*right;
  Node(int d){
    data=d;
    left=right=NULL;
  }
};

class Solution {
public:
  Node* insert(Node* root, int data) {
    if(root==NULL) {
      return new Node(data);
    } else {
      Node* cur;
      if(data<=root->data) {
        cur=insert(root->left,data);
        root->left=cur;
      } else {
        cur=insert(root->right,data);
        root->right=cur;
      }
      return root;
    }
  }

  void levelOrder(Node * root) {
    queue<Node*> nodeQueue;
    nodeQueue.push(root);
    while(!nodeQueue.empty()) {
      Node* currentNode = nodeQueue.front();
      nodeQueue.pop();
      cout << currentNode->data << " ";
      if (currentNode->left != NULL) {
        nodeQueue.push(currentNode->left);
      }
      if (currentNode->right != NULL) {
        nodeQueue.push(currentNode->right);
      }
    }
  }
}; //End of Solution

int main() {
  Solution myTree;
  Node* root=NULL;
  int T,data;
  cin>>T;
  while(T-->0){
    cin>>data;
    root= myTree.insert(root,data);
  }
  myTree.levelOrder(root);
  return 0;
}
