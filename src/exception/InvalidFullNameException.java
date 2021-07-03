package exception;

public class InvalidFullNameException extends Exception{
    private  String fullName;

    public InvalidFullNameException() {
    }

    public InvalidFullNameException(String message, String fullName) {
        super(message);
        this.fullName = fullName;
    }

}
