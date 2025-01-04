package tutorial.java.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReadOperation {
    // Method to filter strings of a given length and
    // convert them to uppercase
    private static List<String> filterAndConvertToUpper(Stream<String> stream,
                            int length)
    {
        return stream.filter(s -> s.length() == length)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static void main(String[] args)
    {
        // Replace with the
        // actual file path
        String fileName = "myFile.txt";

        // Step 1: Create a Stream of lines from the
        // file
        try (Stream<String> lines
                     = Files.lines(Paths.get(fileName))) {

            List<String> filteredStrings
                    = filterAndConvertToUpper(lines, 5);
            System.out.println(
                    "Filtered strings with length 5 (converted to uppercase): "
                            + filteredStrings);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


