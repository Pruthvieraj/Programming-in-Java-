//Class representing a Loan
public class Loan {

    double loanAmount;
    int months;
    double emi; //monthly installment

    //Constructor to initialize loan and calculate EMI
    public Loan(double loanAmount, int months) {

        this.loanAmount = loanAmount;
        this.months = months;
        this.emi = loanAmount / months; //simple EMI calc
    }

    //Pays EMI from given account
    public void payEMI(Account acc) throws InsufficientBalanceException {

        //Check if account has enough balance
        if(acc.balance < emi)
            throw new InsufficientBalanceException("Not enough balance to pay EMI");

        acc.balance -= emi;

        System.out.println("EMI Paid: " + emi);
        System.out.println("Remaining Balance: " + acc.balance);
    }

    //Displays loan details
    public void displayLoan() {
        System.out.println("Loan Amount: " + loanAmount);
        System.out.println("Monthly EMI: " + emi);
    }
}