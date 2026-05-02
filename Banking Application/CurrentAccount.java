//Class representing a Current Account (inherits from Account)
public class CurrentAccount extends Account {

    //Minimum balance required for a current account
    double minimumBalance = 1000;

    //Constructor to initialize current account details
    public CurrentAccount(int accountNumber, double balance, customer customer) {
        // Call parent class constructor
        super(accountNumber, balance, customer);
    }

    //Method to check whether minimum balance is maintained
    public void checkMinimumBalance() {

        //Check if current balance is below minimum required balance
        if(balance < minimumBalance)
            System.out.println("Minimum balance not maintained");
        else
            System.out.println("Minimum balance maintained");
    }

    //Overriding withdraw method specific to CurrentAccount
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {

        //Check if withdrawal amount exceeds available balance
        if(amount > balance)
            throw new InsufficientBalanceException("Insufficient Balance");

        //Deduct amount from balance
        balance -= amount;

        //Display withdrawal message specific to current account
        System.out.println("Current Account Withdrawal: " + amount);
    }
}