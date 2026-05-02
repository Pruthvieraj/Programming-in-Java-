// Custom exception for invalid employee data
class InvalidEmployeeException extends Exception {

    // Constructor to pass error message
    InvalidEmployeeException(String msg) {
        super(msg);
    }
}
