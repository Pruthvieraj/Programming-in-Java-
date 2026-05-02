// Contract-based employee
class ContractEmployee extends Employee {

    int hoursWorked;
    double ratePerHour;

    // Constructor with validation
    ContractEmployee(String empName, String panNumber, String joinDate, String jobTitle, int employeeId, int hoursWorked, double ratePerHour)
            throws InvalidEmployeeException {

        super(empName, panNumber, joinDate, jobTitle, employeeId);

        // Validate contract details
        if (hoursWorked < 0 || ratePerHour < 0) {
            throw new IllegalArgumentException("Invalid contract values");
        }

        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    // CTC = hours worked * rate per hour
    @Override
    double calculateCTC() {
        return hoursWorked * ratePerHour;
    }

    @Override
    String getType() { return "CON"; }

    // Contract employee has no fixed components
    @Override
    double getSalary() { return 0; }

    @Override
    double getInsurance() { return 0; }

    @Override
    double getIncentive() { return 0; }

    @Override
    double getStock() { return 0; }
}