import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

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
     * @param a the value of the first number
     * @param b the value of the second number
     */
    private static void Task1(int a, int b){
        System.out.println("Input: a = " + a + ", b = " + b);
        System.out.println("%: " + EuclidGCD.gcd_perc(a,b));
        System.out.println("FloorMod: " + EuclidGCD.gcd_floorMod(a,b));
        System.out.println("Rem: " + EuclidGCD.gcd_rem(a,b));
    }

    /**
     * Task: Implement a bidirectional Rot13 algorithm.
     * Encode/decode a string from the command line argument.
     *
     * @param to_encode string to encode
     * @param to_decode string to decode
     */
    private static void Task2(String to_encode, String to_decode){
        System.out.println("String to encode: " + to_encode);
        String encoded = Rot13Eng.encode(to_encode);
        System.out.println("Encoded: " + encoded);
        System.out.println("Check(Decode): " + Rot13Eng.decode(encoded));

        System.out.println("String to decode: " + to_decode);
        String decoded = Rot13Eng.decode(to_decode);
        System.out.println("Decoded: " + decoded);
        System.out.println("Check(Encode): " + Rot13Eng.encode(decoded));
    }

    /**
     * Task: Write a program to convert an input hexadecimal string into its equivalent decimal number.
     *
     * @param input string to convert
     */
    private static void Task3(String input){
        try {
            System.out.println("HEX: " + input);
            System.out.println("DEC: " + HexToDec.convert(input));
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Task: Write methods that turn a Scanner into a stream of words, lines, integers, or double values.
     *
     * @param test_scanner Scanner to turn to a Stream
     */
    private static void Task4(Scanner test_scanner){
        Stream result_stream = ScannerToStream.getStream(test_scanner);
        System.out.println(result_stream.count());
        result_stream.forEach(System.out::println);
    }

    /**
     * Task: Unzip the src.zip file from the JDK. Using Files.walk,
     * find all Java files that contain the keywords transient and volatile.
     *
     * @param filename path to a zip file
     */
    private static void Task5(String filename) {
        try {
            List<Path> files = TransientVolatile.getFiles(filename);
            files.forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Task: Write an example that counts the number of times a particular character, such as E, appears in a file.
     * The character can be specified at the command line.
     *
     * @param filename name of the file
     * @param c character to count
     */
    private static void Task6(String filename, char c){
        try {
            System.out.println("File: " + filename);
            System.out.println("Character: " + c);
            int count = CharCounter.count(filename, c);
            System.out.println("Count: " + count);
        } catch (FileNotFoundException e){
            System.out.println("Error: File not found - " + filename);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Task: Write a program that reads a text file, specified by the first command line argument, into a List.
     * The program should then print random lines from the file, the number of lines printed to be specified
     * by the second command line argument. Write the program so that a correctly-sized collection is allocated
     * all at once, instead of being gradually expanded as the file is read in.
     *
     * @param filename path to the file
     * @param number number of random lines
     */
    private static void Task7(String filename, int number){
        try {
            List<String> output = FileToStringList.getList(filename, number);
            for (String line : output) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            System.out.println("Error: File not found - " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Task: Using Stream.iterate, make an infinite stream of random numbers—not by calling Math.random but by
     * directly implementing a linear congruential generator. In such a generator, you start with x0 = seed and then
     * produce xn + 1 = (a xn + c) % m, for appropriate values of a, c, and m. You should implement a method
     * with parameters a, c, m, and seed that yields a Stream. Try out a = 25214903917, c = 11, and m = 2^48.
     *
     * @param seed generation seed
     * @param a generator parameter a
     * @param c generator parameter c
     * @param m generator parameter m
     * @param num number of sequence elements to print
     */
    private static void Task8(Long seed, Long a, Long c, Long m, int num){
        Stream<Long> random = RandomNumbersStream.getStream(seed, a, c, m);
        random.limit(num).forEach(System.out::println);
    }

    /**
     * Task: Write a method public static Stream zip(Stream first, Stream second) that alternates elements from the
     * streams first and second, stopping when one of them runs out of elements.
     *
     * @param first_stream first stream
     * @param second_stream second stream
     */
    private static void Task9(Stream first_stream, Stream second_stream){
        Stream result = StreamZip.zip(first_stream, second_stream);
        result.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //Task1(8, -2);
        //Task2(args[0], args[1]);
        //Task3("DEADBEAF");
        //Task4(new Scanner("12 546 1427 8421"));
        Task5(System.getProperty("user.dir") + "\\test.zip");
        //Task6(System.getProperty("user.dir") + "\\test.txt", arg[0]);
        //Task7(System.getProperty("user.dir") + "\\test.txt", 5);
        //Task8(256L, 25214903917L, 11L, 2^48L, 25);
        //Task9(Stream.of(1, 3, 5, 7, 9), Stream.of(2, 4, 6, 8, 10));
    }
}
