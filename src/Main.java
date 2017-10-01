import java.util.List;
import java.util.Map;

/**
 * First assignment of the course "Intellectual systems" that consist of 10 tasks.
 * This class integrates all 10 tasks to provide them with test values and call them to see the result.
 *
 * Tasks: https://docs.google.com/document/d/1y3kaCApOqBC38sE6aZhGJY-6pxXaDnrj7jaN-cNEKUw
 * @author Betehtin Artem
 */
public class Main {

    /**
     * Task: Euclid’s algorithm (which is over two thousand years old)
     * computes the greatest common divisor of two numbers as gcd(a, b) = a if b is zero,
     * and gcd(b, rem(a, b)) otherwise, where rem is the remainder.
     * Clearly, the gcd should not be negative, even if a or b are (since its negation would then be a greater divisor).
     * Implement the algorithm with %, floorMod, and a rem function that produces the
     * mathematical (non-negative) remainder.
     * Which of the three gives you the least hassle with negative values?
     *
     *
     * @param a the value of the first number
     * @param b the value of the second number
     */
    private static void Task1(int a, int b){
        EuclidGCD.run(a, b);
    }

    public static void main(String[] args) {
        Task1(8, -2);
    }
}
