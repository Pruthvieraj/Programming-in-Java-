public class Main {
    public static void main(String[] args) {

        try {
            // 1. FullTimeEmployee (DEV)
            Employee e1 = new FullTimeEmployee(
                    "Karan", "PAN111", "12-02-2021", "Developer",
                    201, 350000, 90000, 50000, 10000, "DEV"
            );

            // 2. FullTimeEmployee (HR)
            Employee e2 = new FullTimeEmployee(
                    "Rohit", "PAN222", "05-06-2020", "HR",
                    202, 300000, 80000, 20000, 5000, "HR"
            );

            // 3. ContractEmployee
            Employee e3 = new ContractEmployee(
                    "Sneha", "PAN333", "08-07-2022", "Consultant",
                    203, 120, 60
            );

            // 4. Manager
            Employee e4 = new Manager(
                    "Ritika", "PAN444", "15-09-2019", "Team Lead",
                    204, 600000, 150000, 100000, 30000,
                    40000, 25000
            );

            Employee[] list = {e1, e2, e3, e4};

            // Table header
            System.out.printf("%-15s %-12s %-18s %-10s %-10s %-12s\n",
                    "Employee Type", "Base Salary", "Health Insurance", "Bonus", "Stock", "CTC");

            System.out.println("-------------------------------------------------------------------------------");

            // Display data
            for (Employee emp : list) {
                System.out.printf("%-15s %-12.2f %-18.2f %-10.2f %-10.2f %-12.2f\n",
                        emp.getType(),
                        emp.getSalary(),
                        emp.getInsurance(),
                        emp.getIncentive(),
                        emp.getStock(),
                        emp.calculateCTC()
                );
            }

            // 5. Invalid case (to test exception)
            System.out.println("\nTesting invalid input:");
            Employee e5 = new FullTimeEmployee(
                    "", "PAN555", "01-01-2023", "Tester",
                    -1, -1000, 0, 0, 0, "DEV"
            );

        } catch (InvalidEmployeeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }
    }
}