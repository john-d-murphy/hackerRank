import java.util.*;

/*
Comparators are used to compare two objects.
In this challenge, you'll create a comparator and use it to sort an array.
The Player class is provided in the editor below; it has two fields:

A string, name.
An integer, score.
Given an array of n Player objects, write a comparator that sorts them in order of decreasing score;
if 2 or more players have the same score, sort those players alphabetically by name.
To do this, you must create a Checker class that implements the Comparator interface,
then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.

Input Format

Locked stub code in the Solution class handles the following input from stdin:
* The first line contains an integer,n, denoting the number of players.
*Each of the n subsequent lines contains a player's respective name and score.

Constraints

* 0 <= score <= 1000
* Two or more players can have the same name.
* Player names consist of lowercase English alphabetic letters.

Output Format

You are not responsible for printing any output to stdout.
Locked stub code in Solution will create a Checker object,
use it to sort the Player array, and print each sorted element.
*/

// Write your Checker class here
class Checker implements Comparator<Player> {

  @Override
  public int compare(Player a1, Player a2) {
    if (a1.score < a2.score) {
      return 1;
    } else if (a1.score > a2.score) {
      return -1;
    } else {
      return a1.name.compareTo(a2.name);
    }
  }
}

class Player {
  String name;
  int score;

  Player(String name, int score){
    this.name = name;
    this.score = score;
  }
}

class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    Player[] player = new Player[n];
    Checker checker = new Checker();

    for(int i = 0; i < n; i++){
      player[i] = new Player(scan.next(), scan.nextInt());
    }
    scan.close();

    Arrays.sort(player, checker);
    for(int i = 0; i < player.length; i++){
      System.out.printf("%s %s\n", player[i].name, player[i].score);
    }
  }
}
