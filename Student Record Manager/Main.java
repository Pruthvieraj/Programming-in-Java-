import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("--- ORIGINAL DATA ---");
            readAndPrint();

            System.out.println("\n--- INSERT OPERATION ---");
            Insert.insert();
            readAndPrint();

            System.out.println("\n--- UPDATE OPERATION ---");
            Update.update();
            readAndPrint();

            System.out.println("\n--- CALCULATE PERCENTAGE ---");
            CalcPercentage.calculate();
            readAndPrint();

            System.out.println("\n--- DELETE OPERATION ---");
            Delete.delete(803);
            readAndPrint();

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Exception demo
        try {
            FileReader fr = new FileReader("WrongFile.csv");
        } catch (Exception e) {
            System.out.println("\nException demo: " + e.getMessage());
        }
    }

    public static void readAndPrint() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Students.csv"));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}
