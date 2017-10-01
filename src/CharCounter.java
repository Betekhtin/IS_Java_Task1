import java.io.*;
import java.nio.charset.Charset;

/**
 * Class to count specific character in given file
 * @author Betehtin Artem
 */
class CharCounter {

    /**
     * Count number of instances of a specific character in a file
     *
     * @param filename name of the input file
     * @param E character to count
     * @return number of instances of E in the file
     * @throws IOException if something is wrong with BufferReader
     */
    static int count(String filename, char E) throws IOException {

        int count = 0; // Initialize counter

        // Turn FileInputStream into a BufferReader
        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(
                                new FileInputStream(filename),
                                Charset.forName("UTF-8")));

        // Reading reader char by char and count instances of E
        int c;
        while ((c = reader.read()) != -1) {
            char character = (char) c;
            if (character == E) ++count;
        }

        return count;
    }

}
