import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class to get a list of random lines from a text file.
 * @author Betehtin Artem
 */
class FileToStringList {

    /**
     * Returns list of random lines from a text file.
     * Number of lines is specified in the input argument.
     *
     * @param filename path to the file
     * @param num number of randim lines
     * @return list of the random lines from the file
     * @throws IOException if something went wrong with BufferReader
     */
    static List<String> getList(String filename, int num) throws IOException{

        if (num < 0) throw new IllegalArgumentException("Number of lines must be positive");

        int lineLength = 80; // Assuming line length
        File file = new File(filename);

        // Allocating memory for lines
        List<String> fileList =
                new ArrayList<String>((int) (file.length() / lineLength) * 2);

        // Reading lines from file
        int lineCount = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            fileList.add(line);
            lineCount++;
        }
        reader.close();

        // Choosing random lines from the list
        List<String> output = new ArrayList<String>(num);
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            output.add(fileList.get(random.nextInt(lineCount - 1)));
        }

        return output;

    }
}