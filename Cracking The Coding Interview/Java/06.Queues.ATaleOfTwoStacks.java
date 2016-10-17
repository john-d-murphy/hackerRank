import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
A queue is an abstract data type that maintains the order in which elements were added to it, 
allowing the oldest elements to be removed from the front and new elements to be added to the rear. 
This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue 
(i.e., the one that has been waiting the longest) is always the first one to be removed.

A basic queue has the following operations:
    Enqueue: add a new element to the end of the queue.
    Dequeue: remove the element from the front of the queue and return it.

In this challenge, you must first implement a queue using two stacks. Then process queries, where each query 
is one of the following types:
    1 x: Enqueue element into the end of the queue.
    2: Dequeue the element at the front of the queue.
    3: Print the element at the front of the queue.

Input Format
The first line contains a single integer,q, denoting the number of queries.
Each line of the subsequent lines contains a single query in the form described in the 
problem statement above. All three queries start with an integer denoting the query type, but only query 
is followed by an additional space-separated value,x, denoting the value to be enqueued.

Constraints
* 1 <= q <= 10^5
* 1 <= type <= 3
* 1 <= |x| <= 10^9
* It is guaranteed that a valid answer always exists for each query of type 3.

Output Format
For each query of type 3, print the value of the element at the front of the queue on a new line.
*/


/* Since a stack extends vector, we can do vector operations - to handle the
 * stack as a queue, all we need to do is get the first element. This passes
 * fine.
 */

public class Solution {
  public static class MyQueue<T> {
    Stack<T> stackNewestOnTop = new Stack<T>();

    // Push onto newest stack
    public void enqueue(T value) { 
        stackNewestOnTop.push(value);
    }

    public T peek() {
      return stackNewestOnTop.firstElement();
    }

    public T dequeue() {
      T value = stackNewestOnTop.firstElement();
      stackNewestOnTop.removeElement(value);
      return value;
    }
  }


  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      
    if (operation == 1) { // enqueue
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) { // dequeue
        queue.dequeue();
      } else if (operation == 3) { // print/peek
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }
}
