
/*
A linked list is said to contain a cycle if any node is visited more than once while traversing the list.

Complete the function provided for you in your editor.
It has one parameter: a pointer to a Node object named head that points to the head of a linked list.
Your function must return a boolean denoting whether or not there is a cycle in the list.
If there is a cycle, return true; otherwise, return false.

Note: If the list is empty, head will be null.

Input Format

Our hidden code checker passes the appropriate argument to your function.
You are not responsible for reading any input from stdin.

Constraints

Output Format

If the list contains a cycle, your function must return true.
If the list does not contain a cycle, it must return false.
The binary integer corresponding to the boolean value returned by your function is printed to stdout by our
hidden code checker.
*/

/*
 * Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
 *
 * A Node is defined as:
 *     class Node {
 *     	int data;
 *      Node next;
 *     }
 *
*/

boolean hasCycle(Node head) {

  if (head == null || head.next == null ) {
    return false;
  }

  // Tortoise increments one node at a time.
  // Hare increments two nodes at a time.
  // Eventually, they will overlap if there is a cycle.
  Node tortoise = head.next;
  Node hare = head.next.next;

  while(hare != null && hare.next != null) {
    if(tortoise == hare) {
      return true;
    }

    tortoise = tortoise.next;
    hare = hare.next.next;
  }

  return false;
}
