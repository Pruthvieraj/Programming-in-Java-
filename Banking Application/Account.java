//Class representing a bank account
public class Account {

    //Unique account number
    protected int accountNumber;

    //Current balance in the account
    protected double balance;

    //Customer associated with this account
    protected customer customer;

    //Constructor to initialize account details
    public Account(int accountNumber, double balance, customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    //Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount; // Add amount to balance
        System.out.println("Amount Deposited: " + amount);
        System.out.println("Balance: " + balance);
    }

    //Method to withdraw money from the account
    //Throws InsufficientBalanceException if balance is not enough
    public void withdraw(double amount) throws InsufficientBalanceException {

        //Check if withdrawal amount exceeds current balance
        if(amount > balance)
            throw new InsufficientBalanceException("Insufficient Balance");

        balance -= amount; // Deduct amount from balance
        System.out.println("Amount Withdrawn: " + amount);
        System.out.println("Balance: " + balance);
    }

    //Method to display account and customer details
    public void displayAccount() {
        customer.displayCustomer(); // Display customer details
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}