/**
 * Goldbach's Conjecture - Every even integer greater than 2 can be represented as the
 * sum of two primes numbers.
 *
 * Example: 200
 *
 * Prime numbers are 3 197
 * Prime numbers are 7 193
 * Prime numbers are 19 181
 * Prime numbers are 37 163
 * Prime numbers are 43 157
 * Prime numbers are 61 139
 * Prime numbers are 73 127
 * Prime numbers are 97 103
 *
 * Example: 6
 *
 * Prime numbers are 1 5
 * Prime numbers are 3 3
 *
 * Example: 3
 *
 * Prime numbers are 1 2
 *
 * 1) If the number is not even then return
 * 2) If the number is less than equal to 2, then return
 * 3) Loop from i = 1 to number/2 and check if i and (number - i) is prime, if yes then print it.
 *
 * Loop from i = 1 to number/2 is O(n/2)
 * Loop for prime number check is from i = 2 to number/2 is O(n/2)
 *
 * Time Complexity: O(n/2+n/2) = O(n)
 */
public class Goldbachs_Conjecture_SumOfTwoPrime {

    private static void goldbach_conjecture_SumOfTwoPrime(int number) {

        if (number % 2 != 0) {
            System.out.println("The number is not even");
            return;
        }

        if (number <= 2) {
            System.out.println("The number is less than or equal to 2");
            return;
        }

        for (int i = 1; i <= number/2; i++) {

            if (isPrime(i) && isPrime(number - i)) {
                System.out.println("Prime numbers are " + i + " " + (number - i));
            }
        }
    }

    //checks whether an int is prime or not.
    //You have to go till the square root of n, because if you list all the factors
    //of n then square root will always be in the middle. (if it happens that square root
    //is not integer, we are still ok)
    private static boolean isPrime(int n) {

        //Number 2 is prime
        if (n == 2) {
            return true;
        }

        //check if n is a multiple of 2, then it's not prime
        if (n == 1 || n%2==0) {
            return false;
        }

        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        goldbach_conjecture_SumOfTwoPrime(200);

        System.out.println();

        goldbach_conjecture_SumOfTwoPrime(6);

        System.out.println();

        goldbach_conjecture_SumOfTwoPrime(3);

        System.out.println();

        goldbach_conjecture_SumOfTwoPrime(100);

        System.out.println();

        goldbach_conjecture_SumOfTwoPrime(10);
    }
}
