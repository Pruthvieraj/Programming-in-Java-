// Full-time employee
class FullTimeEmployee extends Employee {

    double salary;
    double insurance;
    double bonus;
    double stockOptions;
    String dept;

    // Constructor with validation
    FullTimeEmployee(String empName, String panNumber, String joinDate, String jobTitle, int employeeId, double salary, double insurance, double bonus, double stockOptions, String dept)
            throws InvalidEmployeeException {

        super(empName, panNumber, joinDate, jobTitle, employeeId);

        // Validate salary components
        if (salary < 0 || insurance < 0 || bonus < 0 || stockOptions < 0) {
            throw new IllegalArgumentException("Invalid salary details");
        }

        this.salary = salary;
        this.insurance = insurance;
        this.bonus = bonus;
        this.stockOptions = stockOptions;
        this.dept = dept;
    }

    // CTC calculation based on department
    @Override
    double calculateCTC() {
        if (dept.equalsIgnoreCase("DEV")) {
            return salary + bonus;
        } else if (dept.equalsIgnoreCase("HR")) {
            return salary + 15000;
        }
        return salary;
    }

    @Override
    String getType() { return "FT"; }

    @Override
    double getSalary() { return salary; }

    @Override
    double getInsurance() { return insurance; }

    @Override
    double getIncentive() { return bonus; }

    @Override
    double getStock() { return stockOptions; }
}