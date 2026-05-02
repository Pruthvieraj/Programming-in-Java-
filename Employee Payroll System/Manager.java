// Manager class (inherits full-time employee)
class Manager extends FullTimeEmployee {

    double travelAllowance;
    double learningAllowance;

    // Constructor with validation
    Manager(String empName, String panNumber, String joinDate,
            String jobTitle, int employeeId,
            double salary, double insurance,
            double bonus, double stockOptions,
            double travelAllowance, double learningAllowance)
            throws InvalidEmployeeException {

        super(empName, panNumber, joinDate, jobTitle, employeeId, salary, insurance, bonus, stockOptions, "Manager");

        // Validate allowances
        if (travelAllowance < 0 || learningAllowance < 0) {
            throw new IllegalArgumentException("Invalid allowances");
        }

        this.travelAllowance = travelAllowance;
        this.learningAllowance = learningAllowance;
    }

    // Manager CTC calculation
    @Override
    double calculateCTC() {
        return salary + bonus + travelAllowance + learningAllowance;
    }

    @Override
    String getType() { return "MGR"; }
}