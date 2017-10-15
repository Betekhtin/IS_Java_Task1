/**
 * Class to generate test pairs for EuclidGCD
 * @author Betehtin Artem
 */
class TestPair {
    private int first;
    private int second;

    /**
     * Constructor for a test pair
     *
     * @param x first number
     * @param y second number
     * @throws IllegalArgumentException if both arguments equal zero
     */
    TestPair(int x, int y){
        if (x == 0 && y == 0) throw new IllegalArgumentException("At least one argument of GCD should be non-zero");
        this.first = x;
        this.second = y;
    }

    /**
     * Generate test pairs for GCD algorithms
     *
     * @param x first number
     * @param y second number
     * @return array of pairs
     * @throws IllegalArgumentException if both arguments equal zero
     */
    static TestPair[] generatePairs(int x, int y){
        if (x == 0 && y == 0) throw new IllegalArgumentException("At least one argument of GCD should be non-zero");
        if (x != y) {
            if (x == 0) {
                return new TestPair[]{new TestPair(x, y), new TestPair(y, x),
                                      new TestPair(x, -y), new TestPair(-y, x)};
            }
            if (y == 0) {
                return new TestPair[]{new TestPair(x, y), new TestPair(y, x),
                                      new TestPair(y, -x), new TestPair(-x, y)};
            }
            return new TestPair[]{new TestPair(x, y), new TestPair(y, x),
                                  new TestPair(x, -y), new TestPair(y, -x),
                                  new TestPair(-x, y), new TestPair(-y, x),
                                  new TestPair(-x, -y), new TestPair(-y, -x)};
        } else {
            return new TestPair[]{new TestPair(x, y), new TestPair(x, -y),
                                  new TestPair(-x, y), new TestPair(-x, -y)};
        }
    }

    int getFirst(){ return first; }
    int getSecond(){ return second; }

}