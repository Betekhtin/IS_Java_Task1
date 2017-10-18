import java.util.*;
import java.util.stream.Stream;

/**
 * Class to turn Scanners into Streams of different types
 * @author Betehtin Artem
 * @see Scanner
 * @see Stream
 */
class ScannerToStream{

    /**
     * Makes a stream of all words in a scanner
     *
     * @param scanner Scanner to convert to a Stream
     * @return Stream of all words from a scanner
     */
    static Stream<String> getWordStream(Scanner scanner) {
        Stream<String> stream = Stream.empty();
        while (scanner.hasNext()) {
            String value = scanner.next();
            stream = Stream.concat(stream, Stream.of(value));
        }
        return stream;
    }

    /**
     * Makes a stream of all lines in a scanner
     *
     * @param scanner Scanner to convert to a Stream
     * @return Stream of all lines from a scanner
     */
    static Stream<String> getLineStream(Scanner scanner) {
        Stream<String> stream = Stream.empty();
        while (scanner.hasNextLine()) {
            String value = scanner.nextLine();
            stream = Stream.concat(stream, Stream.of(value));
        }
        return stream;
    }

    /**
     * Makes a stream of all integers in a scanner
     *
     * @param scanner Scanner to convert to a Stream
     * @return Stream of all integers from a scanner
     */
    static Stream<Integer> getIntStream(Scanner scanner) {
        Stream<Integer> stream = Stream.empty();
        while (scanner.hasNextInt()) {
            Integer value = scanner.nextInt();
            stream = Stream.concat(stream, Stream.of(value));
        }
        return stream;
    }

    /**
     * Makes a stream of all doubles in a scanner
     *
     * @param scanner Scanner to convert to a Stream
     * @return Stream of all doubles from a scanner
     */
    static Stream<Double> getDoubleStream(Scanner scanner) {
        Stream<Double> stream = Stream.empty();
        while (scanner.hasNextDouble()) {
            Double value = scanner.nextDouble();
            stream = Stream.concat(stream, Stream.of(value));
        }
        return stream;
    }


}