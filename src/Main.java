import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
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
     * @param x first number
     * @param y second number
     */
    private static void Task1(int x, int y) {
        TestPair[] test_pairs = TestPair.generatePairs(x, y);
        for (TestPair pair: test_pairs) {
            int a = pair.getFirst();
            int b = pair.getSecond();
            System.out.println("-----------------------------------------");
            System.out.println("Input: a = " + a + ", b = " + b);
            System.out.println("%: " + EuclidGCD.gcd_perc(a, b));
            System.out.println("FloorMod: " + EuclidGCD.gcd_floorMod(a, b));
            System.out.println("Rem: " + EuclidGCD.gcd_rem(a, b));
            System.out.println("-----------------------------------------");
        }
    }

    /**
     * Task: Implement a bidirectional Rot13 algorithm.
     * Encode/decode a string from the command line argument.
     *
     * @param to_encode string to encode
     * @param to_decode string to decode
     */
    private static void Task2(String to_encode, String to_decode) {
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
    private static void Task3(String input) {
        try {
            System.out.println("HEX: " + input);
            Long resultStandard = HexToDec.convertStandard(input);
            System.out.println("Convert using standard methods: " + resultStandard);
            Long result = HexToDec.convert(input);
            System.out.println("Convert using iteration through string: " + result);
            System.out.println("First result equals second result: " + resultStandard.equals(result));
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Task: Write methods that turn a Scanner into a stream of words, lines, integers, or double values.
     *
     * @param test_string string to make Scanners of
     */
    private static void Task4(String test_string) {
        //Generate multiple scanners for a same string to test all the methods
        Scanner scanner1 = new Scanner(test_string);
        Stream<Integer> integer_stream = ScannerToStream.getIntStream(scanner1);
        Scanner scanner2 = new Scanner(test_string);
        Stream<Double> double_stream = ScannerToStream.getDoubleStream(scanner2);
        Scanner scanner3 = new Scanner(test_string);
        Stream<String> word_stream = ScannerToStream.getWordStream(scanner3);
        Scanner scanner4 = new Scanner(test_string);
        Stream<String> line_stream = ScannerToStream.getLineStream(scanner4);
        System.out.println("Integers:");
        integer_stream.forEach(System.out::println);
        System.out.println("Doubles:");
        double_stream.forEach(System.out::println);
        System.out.println("Words:");
        word_stream.forEach(System.out::println);
        System.out.println("Lines:");
        line_stream.forEach(System.out::println);
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
    private static void Task6(String filename, char c) {
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
    private static void Task7(String filename, int number) {
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
    private static void Task8(Long seed, Long a, Long c, Long m, int num) {
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
    private static void Task9(Stream first_stream, Stream second_stream) {
        Stream result = StreamMerge.merge(first_stream, second_stream);
        result.forEach(System.out::println);
    }

    /**
     * Task:  Online palindrome detection. Read in characters one at a time. Report at each instant if the current
     * string is a palindrome. Use the Rabin-Karp hashing algorithm.
     *
     * @param input input string
     */
    private static void Task10(String input){
        ArrayList<Pair<String, Integer>> palindromes = PalindromeDetector.getPalindromes(input);
        System.out.println("Palindromes: ");
        for (Pair<String, Integer> palindrome : palindromes) {
            System.out.println(palindrome.getKey() + " : [0, " + palindrome.getValue() + "]");
        }
    }

    public static void main(String[] args) {
        //Task1(8, 2);
        //Task2(args[0], args[1]);
        //Task3("DEADBEAF");
        //Task4("12 546 3.5 8421" + System.lineSeparator() + "hello world 33.01");
        //Task5(System.getProperty("user.dir") + "\\test.zip");
        //Task6(System.getProperty("user.dir") + "\\test.txt", 'e');
        //Task7(System.getProperty("user.dir") + "\\test.txt", 5);
        //Task8(256L, 25214903917L, 11L, 2^48L, 25);
        //Task9(RandomNumbersStream.getStream(1,1,2,256).limit(50), RandomNumbersStream.getStream(2,1,2,256).limit(50));
        Task10("qwewqwewq");
    }
}
