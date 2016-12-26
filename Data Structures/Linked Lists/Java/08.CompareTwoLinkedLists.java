
/*
You’re given the pointer to the head nodes of two linked lists.
Compare the data in the nodes of the linked lists to check if they are equal.
The lists are equal only if they have the same number of nodes and corresponding nodes contain the same data.
Either head pointer given may be null meaning that the corresponding list is empty.

Input Format
You have to complete the int CompareLists(Node* headA, Node* headB) method which takes two arguments -
the heads of the two linked lists to compare. You should NOT read any input from stdin/console.

Output Format
Compare the two linked lists and return 1 if the lists are equal.
Otherwise, return 0.
Do NOT print anything to stdout/console.

Sample Input

NULL, 1 --> NULL
1 --> 2 --> NULL, 1 --> 2 --> NULL

Sample Output

0
1
Explanation
1. We compare an empty list with a list containing 1. They don't match, hence return 0.
2. We have 2 similar lists. Hence return 1.
*/

/*
  Compare two linked lists A and B
  Return 1 if they are identical and 0 if they are not.
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

// More garbage -- using ints instead of booleans

int CompareLists(Node headA, Node headB) {
  // This is a "method-only" submission.
  // You only need to complete this method
  if(headA == null && headB == null) {
    return 1;
  } else if(headA != null && headB == null) {
    return 0;
  } else if(headB != null && headA == null) {
    return 0;
  } else if (headA.data != headB.data) {
    return 0;
  } else {
    return CompareLists(headA.next,headB.next);
  }
}
