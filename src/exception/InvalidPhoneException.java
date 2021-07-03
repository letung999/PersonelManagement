package exception;

public class InvalidPhoneException extends Exception{
    String phoneNumber;

    public InvalidPhoneException(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public InvalidPhoneException(String message, String phoneNumber) {
        super(message);
        this.phoneNumber = phoneNumber;
    }
}
