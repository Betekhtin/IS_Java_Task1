import static java.lang.Math.abs;
import static java.lang.Math.floorMod;

/**
 * Recursive implementation of Euclid's GCD algorithm with three different operations
 * @author Betehtin Artem
 */
class EuclidGCD {

    static int gcd_perc(int a, int b) {
        a = (a < 0)? -a: a;
        b = (b < 0)? -b: b;
        while (b !=0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    static int gcd_floorMod(int a, int b) {
        if (b == 0) return (a > 0)? a: -a;
        b = (b < 0)? -b: b;
        while (b !=0) {
            int tmp = floorMod(a, b);
            a = b;
            b = tmp;
        }
        return a;
    }

    static int gcd_rem(int a, int b) {
        if (b == 0) return (a > 0)? a: -a;
        b = (b < 0)? -b: b;
        while (b !=0) {
            int tmp = abs(a % b);
            a = b;
            b = tmp;
        }
        return a;
    }

}