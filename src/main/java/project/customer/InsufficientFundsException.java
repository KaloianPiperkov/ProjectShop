package project.customer;

//class that represents an exception that is thrown when a customer does not have enough funds
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
