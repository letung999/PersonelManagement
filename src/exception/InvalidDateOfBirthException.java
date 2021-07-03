package exception;

public class InvalidDateOfBirthException extends Exception {
    String dateOfBirth;

    public InvalidDateOfBirthException(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public InvalidDateOfBirthException(String message, String dateOfBirth) {
        super(message);
        this.dateOfBirth = dateOfBirth;
    }
}
