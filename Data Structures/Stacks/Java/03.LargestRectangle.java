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

    public static int getMaxArea(List<Integer> heights, Stack<Integer> maxHeights, int index, int maxArea ) {
        //System.out.printf("Current Stack: %s - ", maxHeights);
        int rightBuilding = maxHeights.pop();
        int leftBuilding = (maxHeights.isEmpty() ? index : index - maxHeights.peek() - 1);
        int areaWithTop = heights.get(rightBuilding) * leftBuilding;
        //System.out.printf("index = %d , Right Building = %d, leftBuilding = %d, areaWithTop = %d\n",
        //                   index, rightBuilding, leftBuilding, areaWithTop);

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

        // Run through buildings and calculate values
        int index = 0;
        while(index < numberOfBuildings) {
            // Push the current index onto the stack if the stack is empty or
            // the top of the stack is smaller than our current value.
            // Note that here and only here do we do the increment of the index
            //
            // This is how we set our left and right boundaries for calculating the building area.
            // As an example see the below input:
            //
            //10
            //8979 4570 6436 5083 7780 3269 5400 7579 2324 2116
            // With the comments above enabled, this gives you:
            // Current Stack: [0] - index = 1 , Right Building = 0, leftBuilding = 1, areaWithTop = 8979
            // Current Stack: [1, 2] - index = 3 , Right Building = 2, leftBuilding = 1, areaWithTop = 6436
            // Current Stack: [1, 3, 4] - index = 5 , Right Building = 4, leftBuilding = 1, areaWithTop = 7780
            // Current Stack: [1, 3] - index = 5 , Right Building = 3, leftBuilding = 3, areaWithTop = 15249
            // Current Stack: [1] - index = 5 , Right Building = 1, leftBuilding = 5, areaWithTop = 22850
            // Current Stack: [5, 6, 7] - index = 8 , Right Building = 7, leftBuilding = 1, areaWithTop = 7579
            // Current Stack: [5, 6] - index = 8 , Right Building = 6, leftBuilding = 2, areaWithTop = 10800
            // Current Stack: [5] - index = 8 , Right Building = 5, leftBuilding = 8, areaWithTop = 26152
            // Current Stack: [8] - index = 9 , Right Building = 8, leftBuilding = 9, areaWithTop = 20916
            // Current Stack: [9] - index = 10 , Right Building = 9, leftBuilding = 10, areaWithTop = 21160
            // 26152
            if(biggestBuildings.isEmpty() || initialSet.get(biggestBuildings.peek()) <= initialSet.get(index) ) {
                biggestBuildings.push(index);
                index++;
           } else {
                maxArea = getMaxArea(initialSet,biggestBuildings,index,maxArea);
            }
        }

        // Clean up the rest of the stack
        while(!biggestBuildings.isEmpty()) {
            maxArea = getMaxArea(initialSet,biggestBuildings,numberOfBuildings,maxArea);
        }

        System.out.printf("%d", maxArea);

    }
}



