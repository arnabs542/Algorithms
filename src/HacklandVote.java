import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * There are n citizens voting in this year's Hackland election.
 * Each voter writes the name of their chosen candidate on a ballot and
 * places it in a ballot box. The candidate with the highest number of
 * votes win the election; if two or more candidates have the same number
 * of votes, then the tied candidates' names are ordered alphabetically and the last name wins.

 Complete the election Winner function in your editor.
 It has 1 parameter:L an array of strings, votes, describing the
 votes in the ballot box. This function must review these votes and
 return a string representing the name of the winning candidate.

 Constraints

 1<= n <= 10^4
 Input Format An array of Strings

 Output Format Name of the person who has the max votes.
 If there are multiple people with same number of votes(max) then print the last name.

 Sample Input 1 String[] votes = {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor",
 "Harry", "Alex", "Mary", "Mary"};

 Sample Output 1 Michael

 Explanation 1 votes = {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry",
 "Alex", "Mary", "Mary"} Alex, Harry, Michael, and Mary are all tied for the highest number of votes. Because Michael is alphabetically last, we return his name as the winner.

 Sample Input 2 String[] votes = { "victor", "veronica", "ryan", "dave", "maria",
 "farah", "farah", "ryan", "veronica" };

 Sample Output 2 veronica

 Explanation 2 votes = {"Victor", "Veronica", "Ryan", "Dave", "Maria",
 "Maria", "Farah", "Farah", "Ryan", "Veronica"} Veronica, Ryan, Maria, and
 Farah are all tied for the highest number of votes.
 Because Veronica is alphabetically last, we return her name as the winner.
 *
 */
public class HacklandVote {

    private static String findWinner(String[] votes) {
        TreeMap<String, Integer> treeMapVotes = new TreeMap<String, Integer>(Collections.reverseOrder());

        for (String vote: votes) {
            if (treeMapVotes.containsKey(vote)) {
                treeMapVotes.put(vote, treeMapVotes.get(vote) + 1);
            } else {
                treeMapVotes.put(vote, 1);
            }
        }

        return Collections.max(treeMapVotes.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String[] votes = {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor",
                "Harry", "Alex", "Mary", "Mary"};

        System.out.println("The winner for input 1 is " + findWinner(votes));

        String[] votes1 = { "victor", "veronica", "ryan", "dave", "maria",
                "farah", "farah", "ryan", "veronica" };

        System.out.println("The winner for input 2 is " + findWinner(votes1));
    }
}
