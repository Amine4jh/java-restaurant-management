import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {

    public static List<String[]> readFile (String fileName) {
        List<String[]> allRows = new ArrayList<>();
        Path filePath = Paths.get(fileName);

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            boolean isHeader = true;

            while((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");
                allRows.add(columns);
            }
        }
        catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }

        return allRows;

    }

    public static void writeInFile (String fileName, String content) {
        Path filePath = Paths.get(fileName);
        boolean needsLeadingNewline = false;

        try {
            if (Files.exists(filePath) && Files.size(filePath) > 0) {
                String fileContent = Files.readString(filePath);
                if (!fileContent.endsWith("\n") && !fileContent.endsWith("\r")) {
                    needsLeadingNewline = true;
                }
            }
        }
        catch (IOException e) {
            System.err.println("Could not check file ending: " + e.getMessage());
        }


        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            if (needsLeadingNewline) {
                writer.newLine();
            }

            writer.write(content);
            writer.newLine();
            System.out.println("Successfully wrote to " + fileName);
        }
        catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    public static List<String[]> searchInFile (String fileName, String criteria) {
        List<String[]> matchingRows = new ArrayList<>();
        Path filePath = Paths.get(fileName);

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                boolean foundMatch = false;
                for (String cell : columns) {
                    if (cell.trim().equalsIgnoreCase(criteria.trim())) {
                        foundMatch = true;
                        break;
                    }
                }

                if (foundMatch) {
                    matchingRows.add(columns);
                }
            }
        }
        catch (IOException e) {
            System.err.println("Error reading the file during search: " + e.getMessage());
        }

        return matchingRows;
    }

    // USAGE
    public static void main(String[] args) {
        // Call the method

        List<String[]> data = readFile("user.csv");

        // Loop through the nested structure to print or process the data
        for (int i = 0; i < data.size(); i++) {
            String[] row = data.get(i);
            System.out.print("Row " + i + ": ");
            for (String cell : row) {
                System.out.print("[" + cell + "] ");
            }
            System.out.println();
        }

        System.out.println("---");

        // Search for "Alice" inside users.csv
        List<String[]> results = searchInFile("user.csv", "alice");

        System.out.println("Search Results:");
        if (results.isEmpty()) {
            System.out.println("No matching records found.");
        } else {
            for (String[] row : results) {
                System.out.println("Found match: ID = " + row[0] + ", Name = " + row[1] + ", Password = " + row[2]);
            }
        }
    }

}
