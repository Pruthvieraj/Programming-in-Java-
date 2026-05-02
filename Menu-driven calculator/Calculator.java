import java.util.Scanner;

public class Calculator {

    int num1, num2, op;

    public int addNums(int n1, int n2) {
        return n1 + n2;
    }

    public int subtractNums(int n1, int n2) {
        return n1 - n2;
    }

    public int multiplyNums(int n1, int n2) {
        return n1 * n2;
    }

    public float divideNums(int n1, int n2) {
        if (n2 == 0) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
        return (float) n1 / n2;
    }

    public int calcMod(int n1, int n2) {
        return n1 % n2;
    }

    public static void main(String[] args) {

        Calculator c = new Calculator();
        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            System.out.print("\nEnter first number: ");
            c.num1 = scan.nextInt();

            System.out.print("Enter second number: ");
            c.num2 = scan.nextInt();

            System.out.println("\nChoose operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.print("Enter choice: ");
            c.op = scan.nextInt();

            switch (c.op) {
                case 1:
                    System.out.println("Sum: " + c.addNums(c.num1, c.num2));
                    break;

                case 2:
                    System.out.println(
                        "Difference: " + c.subtractNums(c.num1, c.num2)
                    );
                    break;

                case 3:
                    System.out.println(
                        "Product: " + c.multiplyNums(c.num1, c.num2)
                    );
                    break;

                case 4:
                    System.out.println(
                        "Division: " + c.divideNums(c.num1, c.num2)
                    );
                    break;

                case 5:
                    System.out.println(
                        "Remainder: " + c.calcMod(c.num1, c.num2)
                    );
                    break;

                default:
                    System.out.println("Invalid operation choice!");
            }

            System.out.print(
                "\nDo you want to continue? (1 = Yes, 0 = No): "
            );
            int choice = scan.nextInt();

            if (choice == 0) {
                flag = false;
            }
        }

        System.out.println("\nCalculator program terminated.");
        scan.close();
    }
}
