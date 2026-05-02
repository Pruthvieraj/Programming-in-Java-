//Custom exception for invalid account
public class InvalidAccountException extends Exception {

    //Constructor passing message to parent
    public InvalidAccountException(String msg) {
        super(msg);
    }
}