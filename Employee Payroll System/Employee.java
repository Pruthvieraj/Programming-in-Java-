// Base abstract class
abstract class Employee {

    String empName;
    String panNumber;
    String joinDate;
    String jobTitle;
    int employeeId;

    Employee(String empName, String panNumber, String joinDate, String jobTitle, int employeeId) throws InvalidEmployeeException {

        if (empName == null || empName.isEmpty()) {
            throw new InvalidEmployeeException("Employee name required");
        }

        if (employeeId <= 0) {
            throw new InvalidEmployeeException("Employee ID must be positive");
        }

        this.empName = empName;
        this.panNumber = panNumber;
        this.joinDate = joinDate;
        this.jobTitle = jobTitle;
        this.employeeId = employeeId;
    }

    abstract double calculateCTC();

    abstract String getType();
    abstract double getSalary();
    abstract double getInsurance();
    abstract double getIncentive();
    abstract double getStock();
}
