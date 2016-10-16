import java.util.*;

/* 
A kidnapper wrote a ransom note but is worried it will be traced back to him. 
He found a magazine and wants to know if he can cut out whole words from it and use them to create 
an untraceable replica of his ransom note.  The words in his note are case-sensitive and he must use 
whole words available in the magazine, meaning he cannot use substrings or concatenation to create 
the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his 
ransom note exactly using whole words from the magazine; otherwise, print No.

Input Format

The first line contains two space-separated integers describing the respective values of  
m (the number of words in the magazine) and n (the number of words in the ransom note). 
The second line contains m space-separated strings denoting the words present in the magazine. 
The third line contains n space-separated strings denoting the words present in the ransom note.

Constraints
* 1 <= m, n <= 30,000
* 1 <= length of any word <= 5
* Each word consists of English alphabetic characters (e.g. a->z and A->Z)
* The words in the note and the magazine are case-sensitive.

Output Format

Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.

Sample Input

6 4
give me one grand today night
give one grand today
Sample Output

Yes
*/

public class Solution {
  Map<String, Integer> magazineMap;
  Map<String, Integer> noteMap;

  public Solution(String magazine, String note) { 
    Collection<String> magazineStrings = Arrays.asList(magazine.split(" "));
    Collection<String> noteStrings = Arrays.asList(note.split(" "));
    magazineMap = new HashMap<String,Integer>();
    noteMap = new HashMap<String,Integer>();

    // For the purposes of an interview question, we can leave this a bit
    // unoptomized. Ideally, we'd put the duplicate code into a function.

    for(String value : magazineStrings) {
      if (magazineMap.get(value) == null) {
        magazineMap.put(value, 0);  
      }
      Integer currentValue = magazineMap.get(value);
      currentValue++;
      magazineMap.put(value,currentValue);
    }

    for(String value : noteStrings) {
      if (noteMap.get(value) == null) {
        noteMap.put(value, 0);  
      }
      Integer currentValue = noteMap.get(value);
      currentValue++;
      noteMap.put(value,currentValue);
    }
  }

  public boolean solve() {
    for(String ransomWord : noteMap.keySet()) {
      Integer ransomValue   = noteMap.get(ransomWord);
      Integer magazineValue = magazineMap.get(ransomWord);

      if (magazineValue == null || ransomValue > magazineValue) {
        return false;  
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();

    // Eat whitespace to beginning of next line
    scanner.nextLine();

    Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
    scanner.close();

    boolean answer = s.solve();
    if(answer)
      System.out.println("Yes");
    else System.out.println("No");
  }
}
