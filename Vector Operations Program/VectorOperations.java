import java.util.Scanner;

public class VectorOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            //Vector 1
            System.out.print("Enter dimension of Vector 1 (2 or 3): ");
            int d1 = sc.nextInt();

            //Validate BEFORE creating array
            if (d1 != 2 && d1 != 3) {
                throw new VectorException("Vector 1 must be 2D or 3D only.");
            }

            double[] comp1 = new double[d1];

            System.out.println("Enter components of Vector 1:");
            for (int i = 0; i < d1; i++) {
                comp1[i] = sc.nextDouble();
            }

            Vector v1 = new Vector(comp1);

            //Vector 2 
            System.out.print("Enter dimension of Vector 2 (2 or 3): ");
            int d2 = sc.nextInt();

            //Validate BEFORE creating array
            if (d2 != 2 && d2 != 3) {
                throw new VectorException("Vector 2 must be 2D or 3D only.");
            }

            double[] comp2 = new double[d2];

            System.out.println("Enter components of Vector 2:");
            for (int i = 0; i < d2; i++) {
                comp2[i] = sc.nextDouble();
            }

            Vector v2 = new Vector(comp2);

            //Operations
            Vector sum = v1.add(v2);
            Vector diff = v1.subtract(v2);
            double dot = v1.dotProduct(v2);

            //Output 
            System.out.print("Addition: ");
            sum.printVector();

            System.out.print("Subtraction: ");
            diff.printVector();

            System.out.println("Dot Product: " + dot);

        }
        catch (VectorException e) {
            System.out.println("Vector Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values only.");
        }

        sc.close();
    }
}