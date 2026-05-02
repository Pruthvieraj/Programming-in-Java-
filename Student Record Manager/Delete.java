import java.io.*;
import java.nio.file.*;

public class Delete {
    public static void delete(int id) throws IOException {
        File inputFile = new File("Students.csv");
        File tempFile = new File("temp.csv");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        // Header
        if ((currentLine = reader.readLine()) != null) {
            writer.write(currentLine + "\n");
        }

        while ((currentLine = reader.readLine()) != null) {
            String[] parts = currentLine.split(",", -1);

            if (!parts[0].equals(String.valueOf(id))) {
                writer.write(currentLine + "\n");
            }
        }

        reader.close();
        writer.close();

        Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Deleted student with ID: " + id);
    }
}
