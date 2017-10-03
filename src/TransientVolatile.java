import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class that unzips a file and then finds every .java file that contains "transient" or "volatile"
 * @author Betehtin Artem
 * @see ZipUtils
 */
class TransientVolatile {

    /**
     * Extract a zip file into a folder with the same name but without ".zip"
     *
     * @param filename path to file to unzip
     */
    private static void unzip(String filename){
        File zipfile = new File(filename);
        String absolute_path = zipfile.getAbsolutePath();
        //get path to a parent directory of a zip file
        String folder_path = absolute_path.substring(0,absolute_path.lastIndexOf(File.separator));
        ZipUtils.extract(zipfile, new File(folder_path));
    }

    /**
     * Get files that contain keywords "transient" and "volatile" from a zip file
     *
     * @param filename path to a zip file
     * @return list of path to files containing "transient" and "volatile'
     * @throws IOException
     */
    static List<Path> getFiles(String filename) throws IOException {

        List<Path> result = new ArrayList<>(); //initialize result list
        unzip(filename);
        Path path = Paths.get(filename.substring(0, filename.lastIndexOf('.'))); //get path to unzipped files
        Stream<Path> file_stream = Files.walk(path).filter(x -> x.toString().endsWith(".java")); //get java files

        //iterate through java files
        file_stream.forEach((Path file) -> {
            try {
                Stream<String> fileLinesStream = Files.lines(file); //get stream of lines of the file
                //iterate through lines to find keywords
                if (fileLinesStream.anyMatch(line -> line.contains("transient") || line.contains("volatile"))) {
                    result.add(file);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        });

        return result;
    }
}

