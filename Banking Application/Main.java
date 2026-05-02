import java.util.ArrayList;

//Main class
public class Main {

    public static void main(String[] args) {

        try {
            //List of customers
            ArrayList<customer> customers = new ArrayList<>();
            
            //Creating customers
            customer c1 = new customer(
                    "082","Kashish","Chelwani",
                    "kashish811@gmail.com","9309813833",
                    "Nagpur","99999999999","ABCDEFGHIJK"
            );
            
            customer c2 = new customer(
                    "091","Akansha","Choudhary",
                    "Akansha.Choudhary@gmail.com","8237664844",
                    "Mumbai","Choudhary9","XYZABCDEFGH"
            );
            
            customer c3 = new customer(
                    "088","Nayra","Chelwani",
                    "nayra.chelwani@gmail.com","9960695130",
                    "Delhi","11111111111","KKKKKKKKKKK"
            );
            
            customers.add(c1);
            customers.add(c2);
            customers.add(c3);
            
            //List of accounts
            ArrayList<Account> accounts = new ArrayList<>();
            
            SavingsAccount sa1 = new SavingsAccount(9001, 5000, c1);
            CurrentAccount ca1 = new CurrentAccount(8001, 10000, c1);
            
            SavingsAccount sa2 = new SavingsAccount(5002, 8000, c2);
            CurrentAccount ca2 = new CurrentAccount(3002, 15000, c2);
            
            SavingsAccount sa3 = new SavingsAccount(3001, 3000, c3);
            
            accounts.add(sa1);
            accounts.add(ca1);
            accounts.add(sa2);
            accounts.add(ca2);
            accounts.add(sa3);

            //Display summary
            displayInfo(customers, accounts);

            // ---------------- EXCEPTIONS PART ----------------
            System.out.println("\nPerforming Transactions\n");

            try {
                sa1.deposit(2000);     //5000 → 7000
                sa1.withdraw(1000);    //7000 → 6000
                sa1.calculateInterest(); //interest ~ 240

                System.out.println();

                //Large loan to trigger EMI exception
                Loan loan = new Loan(5552000, 12);
                loan.displayLoan();
                loan.payEMI(sa1); //Exception 1

            } catch (InsufficientBalanceException e) {
                System.out.println("Exception: " + e.getMessage());
            }

            //Second exception block
            System.out.println("\nPerforming Transactions\n");

            try {
                sa1.withdraw(6000); //will break min balance rule → Exception 2
            } catch (InsufficientBalanceException e) {
                System.out.println("Exception: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    //Display customers with accounts
    public static void displayInfo(ArrayList<customer> customers, ArrayList<Account> accounts) {

        System.out.println("Customer and Account summary:\n");

        for (customer cust : customers) {

            System.out.println("---- CUSTOMER DETAILS ----");
            System.out.println("Customer ID: " + cust.customerID);
            System.out.println("Name: " + cust.firstName + " " + cust.lastName);
            System.out.println("Email: " + cust.email);
            System.out.println("Phone: " + cust.phoneNumber);
            System.out.println("Address: " + cust.address);
            System.out.println("Aadhar ID: " + cust.aadharID);
            System.out.println("PAN ID: " + cust.panID);

            System.out.println("\n---- ACCOUNTS ----");

            double totalBalance = 0;
            int accountCount = 0;

            for (Account acc : accounts) {
                if (acc.customer.customerID.equals(cust.customerID)) {

                    System.out.println("Account Number: " + acc.accountNumber);
                    System.out.println("Account Type: " + acc.getClass().getSimpleName());
                    System.out.println("Balance: Rs. " + acc.balance);
                    System.out.println();

                    totalBalance += acc.balance;
                    accountCount++;
                }
            }

            System.out.println("Total Accounts: " + accountCount);
            System.out.println("Total Balance Across All Accounts: Rs. " + totalBalance);
            System.out.println();
        }
    }
}