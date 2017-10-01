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

}