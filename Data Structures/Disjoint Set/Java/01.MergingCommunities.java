import java.io.*;
import java.util.*;

/*
People connect with each other in a social network.
A connection between Person I and Person J is represented as M I J.
When two persons belonging to different communities connect, the net effect is the merger of both communities
which I and J belongs to.

At the beginning, there are N people representing N communities.
Suppose person 1 an 2 connected and later 2 and 3 connected, then 1,2 and 3 will belong to the same community.

There are two type of queries:

1) M I J => communities containing person I and J merged (if they belong to different communities).
2) Q I => Print the Size of the community to which person I belongs.

Input Format

The first line of input will contain integers N and Q, i.e. the number of people and the number of queries.
The next Q lines will contain the queries.

Constraints :

* 1 <= N <= 10^5
* 1 <= Q <= 2 * 10^5


Output Format

The output of the queries.

Sample Input

3 6
Q 1
M 1 2
Q 2
M 2 3
Q 3
Q 2
Sample Output

1
2
3
3
Explanation

Initial size of each of the community is 1.

*/

public class Solution {

  private static final String QUERY = "Q";
  private static final String MERGE = "M";

  public static class Communities {

    static int parent[];
    static int rank[];
    static int count[];
    static int people;

    // Constructor
    public Communities(int people) {
      this.people = people;
      parent = new int[people];
      rank = new int[people];
      count = new int[people];

      for(int i = 0; i < people; i++){
        parent[i] = i; count[i] = 1;
      }
    }

    public static int getParent(int i) {
      //System.out.printf("Querying for Parent of: %d\n", i);
      if(parent[i] != i) {
        parent[i] = getParent(parent[i]);
      }

      //System.out.printf("Parent of %d is: %d\n", i, parent[i]);

      return parent[i];
    }

    public static int getSize(int i) {
        int parent = getParent(i);

        return count[parent];
    }

    public static void join(int i, int j) {

      //System.out.printf("Joining %d and %d - ", i, j);

      int iParent = getParent(i);
      int jParent = getParent(j);

      //System.out.printf("Parent: i=%d j=%d - ", iParent, jParent);

      int iCount = getSize(i);
      int jCount = getSize(j);
      int newCount = iCount + jCount;

      //System.out.printf("Rank: i=%d j=%d - ", rank[i], rank[j]);

      //System.out.printf("Count: i=%d j=%d total=%d\n", iCount, jCount, newCount);

      if(iParent == jParent) {
        return;
      } else if (rank[iParent] < rank[jParent]) {
        //System.out.printf("Hit Rank I < Rank J\n");
        parent[iParent] = jParent;
        count[jParent] = newCount;
      } else if (rank[jParent] < rank[iParent]) {
        //System.out.printf("Hit Rank J < Rank I\n");
        parent[jParent] = iParent;
        count[iParent] = newCount;
      } else {
        //System.out.printf("Hit Equal Case\n");
        parent[jParent] = iParent;
        count[iParent] = newCount;
        rank[iParent] = rank[iParent] + 1;
      }
    }

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Integer people = scanner.nextInt();
    Integer queries = scanner.nextInt();
    scanner.nextLine(); // Chomp


    Communities communities = new Communities(people);

    for(int i = 0 ; i < queries; i++) {
      String nextLine = scanner.nextLine();
      String query[] = nextLine.split(" ");

      if(QUERY.equals(query[0])) {
        Integer person = Integer.valueOf(query[1]) - 1;
        //System.out.printf("Querying For: %d\n", person);
        System.out.printf("%d\n", communities.getSize(person));
      } else if (MERGE.equals(query[0])) {
        Integer person1 = Integer.valueOf(query[1]) - 1;
        Integer person2 = Integer.valueOf(query[2]) - 1;
        communities.join(person1,person2);

        /*
        System.out.printf("Parents: %d(%d) %d(%d)\n",
                           person1, communities.getParent(person1),
                           person2, communities.getParent(person2));

        System.out.printf("Size: %d(%d) %d(%d)\n",
                           person1, communities.getSize(person1),
                           person2, communities.getSize(person2));
        */
      }
    }
  }
}
