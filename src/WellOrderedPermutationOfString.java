import java.util.Arrays;

/**
 * Find all well ordered permutations of a given string.
 *
 * Well Ordered String: When all alphabets occur in increasing order irrespective of their case.
 *
 * Example:
 *
 * "Lipsa" - Not well formed
 * "Now" - Well formed
 *
 * Approach:
 *
 * 1) Find all the permutations
 * Loop the string
 * swap(i, left)
 * recursive call(String, left + 1)
 * swap(i, left)
 *
 * 2) If left == string.length
 * Check if it's well formed
 *
 * 3) Print it if well formed.
 */
public class WellOrderedPermutationOfString {

    private static int k = 2; //If you want to print upto 2 permutations

    private static void findAllPermutations(char[] A, int left) {

        if (left == A.length) {

            //Check if it's well formed and print it if true
            if (isWellFormed(A)) { //&& k > 0
                //k--;
                System.out.println(Arrays.toString(A));
            }
            return;
        }

        //Find all the permutations
        for (int i = left; i < A.length; i++) {
            //if (k > 0) {
                swap(i, left, A); //Fix the letter at left position
                findAllPermutations(A, left + 1); //Left position 0, 1, 2 fixed
                swap(i, left, A); //This is for backtrack
           // }
        }

    }

    private static void swap(int i, int left, char[] A) {
        char temp = A[i];
        A[i] = A[left];
        A[left] = temp;
    }

    private static boolean isWellFormed(char[] A) {

        boolean wellFormed = true;

        for (int i = 0; i < A.length - 1; i++) {

            if (Character.toLowerCase(A[i]) > Character.toLowerCase(A[i + 1])) {
                wellFormed = false;
                break;
            }
        }
        return wellFormed;
    }

    public static void main(String[] args) {

        String S = "Interview";
        System.out.println("Given String - " + S);

        findAllPermutations(S.toCharArray(), 0);
    }
}
