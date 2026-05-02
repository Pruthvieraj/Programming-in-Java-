//Class representing a Savings Account
public class SavingsAccount extends Account {

    double interestRate = 0.04; //interest rate

    //Constructor to initialize savings account
    public SavingsAccount(int accountNumber, double balance, customer customer) {
        super(accountNumber, balance, customer);
    }

    //Calculates and displays interest earned
    public void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Interest Earned: " + interest);
    }

    //Withdraw with minimum balance restriction
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {

        //Ensure minimum balance of 500 is maintained
        if(balance - amount < 500)
            throw new InsufficientBalanceException("Minimum balance 500 required");

        balance -= amount;
        System.out.println("Savings Withdrawal: " + amount);
    }
}