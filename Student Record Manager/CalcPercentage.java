import java.nio.file.*;
import java.util.*;

public class CalcPercentage {
    public static void calculate() throws Exception {
        Path path = Paths.get("Students.csv");

        List<String> lines = Files.readAllLines(path);
        List<String> updated = new ArrayList<>();

        updated.add(lines.get(0)); // header

        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).trim().isEmpty()) {
                continue;
            }
            String[] parts = lines.get(i).split(",");

            double sum = 0;
            for (int j = 3; j <= 7; j++) {
                sum += Double.parseDouble(parts[j]);
            }

            double avg = sum / 5;

            parts[8] = String.format("%.2f", avg);

            updated.add(String.join(",", parts));
        }

        Files.write(path, updated);

        System.out.println("Percentage calculated.");
    }
}
