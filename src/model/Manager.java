package model;

import exception.InvalidDateOfBirthException;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee implements Serializable {
    private String startDayOfWork;
    private String  endDayOfWork;

    public Manager() {
    }

    public Manager(String personID, String fullName, String address, String datePfBirth,
                   String email, String phone, String idEmployee, String role,
                   String yearExp, int dayOfWork, float salary, String startDayOfWork,
                   String  endDayOfWork) {
        super(personID, fullName, address,
                datePfBirth, email, phone, idEmployee,
                role, yearExp, dayOfWork, salary);
        this.startDayOfWork = startDayOfWork;
        this. endDayOfWork =  endDayOfWork;
    }

    public String getStartDayOfWork() {
        return startDayOfWork;
    }

    public void setStartDayOfWork(String startDayOfWork) throws InvalidDateOfBirthException {
        String regex = "[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(startDayOfWork);
        if (matcher.find()) {
            this.startDayOfWork = startDayOfWork;
        } else {
            var msg = "date is no invalid";
            throw new InvalidDateOfBirthException(msg, startDayOfWork);
        }
    }

    public String getEndDayOfWork() {
        return  endDayOfWork;
    }

    public void setEndDayOfWork(String  endDayOfWork) throws InvalidDateOfBirthException {
        String regex = "[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(startDayOfWork);
        if (matcher.find()) {
            this.endDayOfWork = endDayOfWork;
        } else {
            var msg = "date is no invalid";
            throw new InvalidDateOfBirthException(msg, endDayOfWork);
        }
    }

}
