//Custom exception for insufficient balance
public class InsufficientBalanceException extends Exception {

    //Constructor passing message to parent
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}