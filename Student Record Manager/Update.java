import java.io.*;
import java.nio.file.*;

public class Update {
    public static void update() throws IOException {
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

            int m4 = parts[6].equals("0") ? 80 : Integer.parseInt(parts[6]);
            int m5 = parts[7].equals("0") ? 85 : Integer.parseInt(parts[7]);

            parts[6] = String.valueOf(m4);
            parts[7] = String.valueOf(m5);

            writer.write(String.join(",", parts) + "\n");
        }

        reader.close();
        writer.close();

        Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Updated missing marks.");
    }
}
