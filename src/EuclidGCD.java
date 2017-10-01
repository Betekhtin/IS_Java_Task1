import static java.lang.Math.abs;
import static java.lang.Math.floorMod;

/**
 * Recursive implementation of Euclid's GCD algorithm with three different operations
 * @author Betehtin Artem
 */
class EuclidGCD {

    static int gcd_perc(int a, int b) {
        return b == 0 ? a : gcd_perc(b, a % b);
    }

    static int gcd_floorMod(int a, int b) {
        return b == 0 ? a : gcd_perc(b, floorMod(a, b));
    }

    static int gcd_rem(int a, int b) { return b == 0 ? a : gcd_perc(b, abs(a % b)); }

    /**
     * Prints the result of all three implementations of GCD in this class with given parameters
     * @param a the value of the first number
     * @param b the value of the second number
     */
    static void run(int a, int b){
        System.out.println("Input: a = " + a + ", b = " + b);
        System.out.println("%: " + gcd_perc(a,b));
        System.out.println("FloorMod: " + gcd_floorMod(a,b));
        System.out.println("Rem: " + gcd_rem(a,b));
    }
}