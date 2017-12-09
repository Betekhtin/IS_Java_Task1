import javafx.util.Pair;
import java.util.ArrayList;

/**
 * Class to check strings for palindromes
 * @author Betehtin Artem
 */
class PalindromeDetector {

    // Number of characters in input alphabet
    private static int d = 256;

    // Prime number to evaluate hash
    private static int m = 65537;

    /**
     * Returns an array with palindromes and positions of their last characters in the input string
     *
     * @param input input string
     * @return ArrayList of pairs where key is palindrome and value is position of the last character of
     *         palindrome in input string
     */
    static ArrayList<Pair<String, Integer>> getPalindromes(String input) {

        // Initialize results
        ArrayList<Pair<String, Integer>> palindromes  = new ArrayList<>();

        // Length of input string
        int n = input.length();

        // A single character is a palindrome
        palindromes.add(new Pair<>(String.valueOf(input.charAt(0)), 0));
        if (n == 1) return palindromes;

        // Initialize reversed first half and second half
        int first_half  = input.charAt(0) % m;
        int second_half = input.charAt(1) % m;

        int h = 1, i, j;

        // Look for palindromes starting from second character
        for (i = 1; i < n; i++) {

            // If the hash values of two halves match then check individual characters
            if (first_half == second_half) {

                // Check if input[0..i] is palindrome by matching characters
                for (j = 0; j < i/2; j++) {
                    if (input.charAt(j) != input.charAt(i - j)) break;
                }
                if (j == i/2) palindromes.add(new Pair<>(input.substring(0,i+1), i));
            }

            // Calculate hash values for next iteration
            // Check if current character is the last
            if (i != n - 1) {

                // If next i is odd
                if (i % 2 == 0) {

                    // Add next character at beginning of first_half
                    h = (h * d) % m;
                    first_half  = (first_half + h *input.charAt(i / 2)) % m;

                    // Add next character at the end of second_half.
                    second_half = (second_half * d + input.charAt(i + 1)) % m;
                } else {
                   // If next i is even first_half remains unchanged
                    // Remove first character of second_half and append a character to it.
                    second_half = (d * (second_half + m - input.charAt((i + 1) / 2) * h) % m + input.charAt(i + 1)) % m;
                }
            }
        }

        return palindromes;
    }
}
