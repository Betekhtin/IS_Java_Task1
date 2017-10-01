import java.util.stream.Stream;

/**
 * Class that generates an infinite stream of random numbers by implementing linear congruential generator.
 * @author Betehtin Artem
 */
public class RandomNumbersStream {

    /**
     *  Get stream of random numbers with specified generator parameters.
     *  This method uses lambda expression to generate the sequence.
     *
     * @param seed generation seed
     * @param a generator parameter a
     * @param c generator parameter c
     * @param m generator parameter m
     * @return stream of random numbers
     */
    public static Stream<Long> getStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, e -> (a * e + c) % m);
    }
}