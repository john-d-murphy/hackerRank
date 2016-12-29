import java.io.*;
import java.util.*;
import java.math.*;

/*
There are N buildings in a certain two-dimensional landscape.
Each building has a height given by hi, i in [1,N].
If you join K adjacent buildings, they will form a solid rectangle of area K x min(hi,hi+1, ... hi+k-1).

Given N buildings, find the greatest such solid area formed by consecutive buildings.

Input Format
The first line contains N, the number of buildings altogether.
The second line contains N space-separated integers, each representing the height of a building.

Constraints
* 1 <= N <= 10^5
* 1 <= hi <= 10^6

Output Format
One integer representing the maximum area of rectangle formed.

Sample Input

5
1 2 3 4 5
Sample Output

9
*/


public class Solution {

  public static Integer getLargestAreaFromStack(Stack<Integer> currentStack) {
    Integer currentCount = 1;
    Integer maxArea = 0;
    while(!currentStack.isEmpty()) {
      Integer tempArea = currentStack.pop() * currentCount;
      if (tempArea > maxArea) {
        maxArea = tempArea;
      }
      currentCount++;
    }
    return maxArea;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfBuildings = scanner.nextInt();
    Integer maxArea = 0;
    Stack<Integer> currentComputation = new Stack<Integer>();


    for(int i = 0; i < numberOfBuildings; i++) {
      int newValue = scanner.nextInt();
      if (currentComputation.isEmpty() || newValue > currentComputation.peek()) {
        currentComputation.push(newValue);
      } else {
        // We've hit a boundary - let's calculate all of the possible areas,
        // empty the stack, then start creating a new stack.
        Integer tempArea = getLargestAreaFromStack(currentComputation);
        maxArea = Math.max(tempArea, maxArea);
        currentComputation.clear();
        currentComputation.push(newValue);
      }
    }
    Integer tempArea = getLargestAreaFromStack(currentComputation);
    maxArea = Math.max(tempArea, maxArea);
    System.out.printf("%d", maxArea);
  }
}

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    /*
    public static int getMaxArea(List<Integer> heights, Stack<Integer> maxHeights, int index, int maxArea ) {
        System.out.printf("Current Stack: %s", maxHeights);
        int top = maxHeights.pop();
        int numberOfBuildingsEqualToOrSmaller = (maxHeights.isEmpty() ? index : index - maxHeights.peek() - 1);
        int areaWithTop = heights.get(top) * numberOfBuildingsEqualToOrSmaller;
        System.out.printf("index = %d , top = %d, numberOfBuildings = %d, areaWithTop = %d\n",
                           index, heights.get(top), numberOfBuildingsEqualToOrSmaller, areaWithTop);

        return Math.max(areaWithTop,maxArea);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfBuildings = scanner.nextInt();
        Integer maxArea = 0;
        Integer top = 0;
        Integer areaWithTop = 0;
        List<Integer> initialSet = new ArrayList<Integer>();
        Stack<Integer> biggestBuildings = new Stack<Integer>();

        // Translation of: http://www.geeksforgeeks.org/largest-rectangle-under-histogram/

        // First Populate All Building Heights Into An Array
        for(int i = 0; i < numberOfBuildings; i++) {
            initialSet.add(scanner.nextInt());
        }

        // Run through histogram and calculate values
        int i = 0;
        while(i < numberOfBuildings) {
            // Populate the building stack with maximum height of the building
            if(biggestBuildings.isEmpty() || initialSet.get(biggestBuildings.peek()) <= initialSet.get(i) ) {
                biggestBuildings.push(i++);
           } else {
                maxArea = getMaxArea(initialSet,biggestBuildings,i,maxArea);
                biggestBuildings.push(i);
            }
        }

        // Clean up the rest of the stack
        while(!biggestBuildings.isEmpty()) {
            maxArea = getMaxArea(initialSet,biggestBuildings,numberOfBuildings,maxArea);
        }

        System.out.printf("%d", maxArea);

    }
    */
    static int area(int[] a) {
        int i,area=0;
        int maxArea=0;
        Stack<Integer> st=new Stack<>();
        for(i=0;i<a.length;) {

        if(st.isEmpty()||a[st.peek()]<=a[i])
        {
            System.out.printf("%s\n", st);
            st.push(i++);

        }
        else
        {
            System.out.printf("%s\n", st);

            int x=st.pop();
            if(st.isEmpty())
            {
                area=a[x]*i;
            }
            else
            {
                area=a[x]*(i-st.peek()-1);
            }
             if(area>maxArea)
            maxArea=area;

        }
    }

    while(!st.isEmpty())
    {
        int x=st.pop();

            if(st.isEmpty())
            {
                area=a[x]*i;
            }
            else
            {
                area=a[x]*(i-st.peek()-1);
            }


         if(area>maxArea)
            maxArea=area;
        }

  return maxArea;
}

public static void main(String[] args) {
   Scanner sc=new Scanner(System.in);
   int n;
   n=sc.nextInt();
   int[] a=new int[n];
   for(int i=0;i<n;i++)
       a[i]=sc.nextInt();
    System.out.println("max area="+area(a));
}


}


