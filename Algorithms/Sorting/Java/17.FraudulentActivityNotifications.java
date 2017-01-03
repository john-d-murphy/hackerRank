import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity.
If the amount spent by a client on a particular day is greater than or equal to 2x the client's median spending for the
last d days, they send the client a notification about potential fraud.
The bank doesn't send the client any notifications until they have at least d prior days of transaction data.

Given the value of d and a client's total daily expenditures for a period of n days, find and print the number of times
the client will receive a notification over all n days.

Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest. If there is
an odd number of numbers, the middle one is picked. If there is an even number of numbers, median is then defined to be
the average of the two middle values. (Wikipedia)

Input Format

The first line contains two space-separated integers denoting the respective values of n (the number of days there is
transaction data for) and d (the number of prior days the bank uses to calculate median spending).
The second line contains n space-separated non-negative integers where each integer i denotes expendature (i.e., the
client's total expendature for day i).

Constraints

* 1 <= n < 2 x 10^5
* 1 <= d <= n
* 0 <= expendaturei <= 200

Output Format

Print an integer denoting the total number of times the client receives a notification over a period of n days.

Sample Input 0

9 5
2 3 4 2 3 6 8 4 5

Sample Output 0
2
*/

public class Solution {

  static double getMedian(int data[], int expectedValues, boolean isEven) {

    int foundValues = 0;
    int i;

    // Even Case requires two numbers, and it's possible to go over during the count, so it's a special case
    if(isEven) {

      int value1 = 0;
      int value2 = 0;
      for(i = 0; i < data.length; i++ ) {
        int currentValue = data[i];
        int tempSum = currentValue + foundValues;

        // Case for value1
        if(tempSum == expectedValues) {
          value1 = i;
        } else if(foundValues < expectedValues && tempSum > expectedValues) {
          value1 = i;
          value2 = i;
          break;
        } else if(foundValues >= expectedValues && currentValue > 0) {
          value2 = i;
          break;
        }

        foundValues = tempSum;
      }

      // Calculate the median
      return (value1 + value2)/2.0;

      // Odd case, we just need to find the place where we hit our expectedValue count and we're
      // good.
    } else {
      for(i = 0; i < data.length; i++ ) {
        foundValues += data[i];
        if(foundValues >= expectedValues) {
          break;
        }
      }

      // Index we stopped on is our median
      return i;
    }
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int spendingDays = scanner.nextInt();
    int medianCalculationSize = scanner.nextInt();
    int spendingData[] = new int[201];
    int allHistory[] = new int[spendingDays];
    int notificationDays = 0;
    boolean isEven = (medianCalculationSize % 2 == 0);

    // For even day counts, we will need both days/2 and days/2 + 1 to get the median,
    // so we set the initial increment at days/2
    int expectedValues = (isEven) ? medianCalculationSize/2 : medianCalculationSize/2 + 1;

    for(int i = 0; i < spendingDays; i++) {
      int value = scanner.nextInt();
      allHistory[i] = value;

      if (i < medianCalculationSize) {
        spendingData[value]++;

      } else {

        // Calculate median for last medianCalculationSizeDays
        double median = getMedian(spendingData, expectedValues, isEven);

        if(value >= 2 * median) {
          notificationDays++;
        }

        // Add value to running list and remove value outside of the window
        int previousIndex = i - medianCalculationSize;
        int previousValue = allHistory[previousIndex];
        spendingData[value]++;
        spendingData[previousValue]--;
        previousValue = value;


      }
    }

    System.out.printf("%d", notificationDays);
  }
}

