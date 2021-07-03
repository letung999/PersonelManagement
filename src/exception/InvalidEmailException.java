package exception;

public class InvalidEmailException extends Exception {
    String email;

    public InvalidEmailException(String email) {
        this.email = email;
    }

    public InvalidEmailException(String message, String email) {
        super(message);
        this.email = email;
    }
}
