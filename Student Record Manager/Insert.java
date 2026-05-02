import java.io.*;

public class Insert {
    public static void insert() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("Students.csv", true));

        writer.write("806,Francesca,Music,92,94,93,0,0,0\n");
        writer.write("807,Gregory,Mathematics,75,78,74,0,0,0\n");
        writer.write("808,Hyacinth,History,80,83,81,0,0,0\n");

        writer.close();

        System.out.println("Inserted 3 new students.");
    }
}