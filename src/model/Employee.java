package model;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    private String idEmployee;
    private String role;
    private String yearExp;
    private int dayOfWork;
    private float salary;

    public Employee() {

    }

    public Employee(String personID, String fullName, String address, String datePfBirth,
                    String email, String phone,
                    String idEmployee, String role, String yearExp, int dayOfWork, float salary) {
        super(personID, fullName, address, datePfBirth, email, phone);
        this.idEmployee = idEmployee;
        this.role = role;
        this.yearExp = yearExp;
        this.dayOfWork = dayOfWork;
        this.salary = salary;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getYearExp() {
        return yearExp;
    }

    public void setYearExp(String yearExp) {
        this.yearExp = yearExp;
    }

    public int getDayOfWork() {
        return dayOfWork;
    }

    public void setDayOfWork(int dayOfWork) {
        this.dayOfWork = dayOfWork;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee='" + idEmployee + '\'' +
                ", role='" + role + '\'' +
                ", yearExp='" + yearExp + '\'' +
                ", dayOfWork=" + dayOfWork +
                ", salary=" + salary +
                '}';
    }
}
