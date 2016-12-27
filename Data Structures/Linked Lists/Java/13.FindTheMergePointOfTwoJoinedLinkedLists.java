

/*
Given pointers to the head nodes of 2 linked lists that merge together at some point,
find the Node where the two lists merge.
It is guaranteed that the two head Nodes will be different, and neither will be NULL.

In the diagram below, the two lists converge at Node x:

[List #1] a--->b--->c
                     \
                      x--->y--->z--->NULL
                     /
     [List #2] p--->q

Complete the int FindMergeNode(Node* headA, Node* headB) method so that it finds and returns the data value of
the Node where the two lists merge.

Input Format

The FindMergeNode(Node*,Node*) method has two parameters,headA and headB, which are the non-null head Nodes of two
separate linked lists that are guaranteed to converge.

Do not read any input from stdin/console.

Output Format

Each Node has a data field containing an integer; return the integer data for the Node where the two lists converge.
Do not write any output to stdout/console.

Sample Input

The diagrams below are graphical representations of the lists that input Nodes headA and headB are connected to.
Recall that this is a method-only challenge; the method only has initial visibility to those 2 Nodes and must explore
the rest of the Nodes using some algorithm of your own design.

Test Case 0
 1
  \
   2--->3--->NULL
  /
 1

Test Case 1
1--->2
      \
       3--->Null
      /
     1

Sample Output
2
3
Explanation

Test Case 0: As demonstrated in the diagram above, the merge Node's data field contains
the integer 2 (so our method should return 2).
Test Case 1: As demonstrated in the diagram above, the merge Node's data field contains
the integer 3 (so our method should return 3).
*/
/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/
int FindMergeNode(Node headA, Node headB) {
  // Complete this function
  // Do not write the main method.

  // Absolutely nothing fancy here - runtime of A + B
  // Storage complexity of size.headA

  Set<Integer> visitedNodes = new HashSet<Integer>();

  // Traverse A
  Node tempNode = headA;
  while(tempNode != null) {
    visitedNodes.add(tempNode.data);
    tempNode = tempNode.next;
  }

  // Traverse B
  tempNode = headB;
  while(tempNode != null) {
    if (visitedNodes.contains(tempNode.data)) {
      return tempNode.data;
    }
    tempNode = tempNode.next;
  }

  return -1;

}

