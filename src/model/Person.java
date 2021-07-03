package model;

import exception.InvalidDateOfBirthException;
import exception.InvalidEmailException;
import exception.InvalidFullNameException;
import exception.InvalidPhoneException;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements Serializable {

    private String personID;
    private String fullName;
    private String address;
    private String dateOfBirth;
    private String email;
    private String phone;

    public Person() {
    }

    public Person(String personID, String fullName,
                  String address, String dateOfBirth, String email, String phone) {
        this.personID = personID;
        this.fullName = fullName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws InvalidFullNameException {
        String regex = "^[a-zA-z\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fullName);
        if (matcher.find()) {
            this.fullName = fullName;
        } else {
            String msg = "FullName is not invalid";
            throw new InvalidFullNameException(msg, fullName);
        }


    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws InvalidDateOfBirthException {
        String regex = "[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateOfBirth);
        if (matcher.find()) {
            this.dateOfBirth = dateOfBirth;
        } else {
            var msg = "date of Birth is no invalid";
            throw new InvalidDateOfBirthException(msg, dateOfBirth);
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        do {
            String regex = "^[a-zA-Z0-9\\s]+@gmail.com$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                this.email = email;
                break;
            } else {
                var msg = "email is not invalid";
                throw new InvalidEmailException(msg, email);
            }
        } while (true);

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws InvalidPhoneException {
        String regex = "\\d{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        if(matcher.find()){
            this.phone = phone;
        }
        else{
            var msg ="Phone is not invlid";
            throw new InvalidPhoneException(msg, phone);
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "personID='" + personID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
