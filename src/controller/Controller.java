package controller;

import function.FunctionData;
import function.FunctionUtility;
import model.Employee;
import model.Manager;
import model.Role;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller implements FunctionData, FunctionUtility {
    @Override
    public void writeData(String fileName, ArrayList list) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList loadData(String fileName) {
        ArrayList list = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void showInformationEmployee(ArrayList<Employee> employees) {
        System.out.printf("%-10s%-18s%-15s%-15s%-25s%-15s%-15s%-10s%-10s%-10s%-10s\n",
                "personID", "fullName", "address", "datePfBirth",
                "email", "phone", "idEmployee", "role", "yearExp", "dayOfWork", "salary");
        for (var employee : employees) {
            System.out.printf("%-10s%-18s%-15s%-15s%-25s%-15s%-15s%-10s%-10s%-10s%-10s\n",
                    employee.getPersonID(), employee.getFullName(),
                    employee.getAddress(), employee.getDateOfBirth(), employee.getEmail(), employee.getPhone(),
                    employee.getIdEmployee(), employee.getRole(), employee.getYearExp(), employee.getDayOfWork(),
                    employee.getSalary()
            );
        }
    }

    @Override
    public void showInformationManager(ArrayList<Manager> managers) {
        System.out.printf("%-10s%-25s%-15s%-15s%-25s%-15s%-15s%-10s%-10s%-10s%-10s%-15s%-15s\n",
                "personID", "fullName", "address", "datePfBirth",
                "email", "phone", "idEmployee", "role", "yearExp", "dayOfWork", "salary",
                "start day for work", "end day for work");
        for (var manager : managers) {
            System.out.printf("%-10s%-25s%-15s%-15s%-25s%-15s%-15s%-10s%-10s%-10s%-10s%-15s%-15s\n",
                    manager.getPersonID(), manager.getFullName(),
                    manager.getAddress(), manager.getDateOfBirth(), manager.getEmail(), manager.getPhone(),
                    manager.getIdEmployee(), manager.getRole(), manager.getYearExp(), manager.getDayOfWork(),
                    manager.getSalary(), manager.getStartDayOfWork(), manager.getEndDayOfWork()
            );
        }
    }

    @Override
    public String getRole(int option) {
        String result = null;
        switch (option) {
            case 1: {
                result = Role.FRESHER.toString();
                break;
            }
            case 2: {
                result = Role.JUNIOR.toString();
                break;
            }
            case 3: {
                result = Role.SENIOR.toString();
                break;
            }
            case 4: {
                result = Role.LEAD.toString();
                break;
            }
            case 5: {
                result = Role.DIRECTOR.toString();
                break;
            }
            case 6: {
                result = Role.CEO.toString();
                break;
            }
        }
        return result;
    }

    @Override
    public ArrayList<Employee> SearchNameEmployee(String name, ArrayList<Employee> employees) {
        var results = new ArrayList<Employee>();
        String regex = ".*" + name.toLowerCase() + ".*";
        for (int i = 0; i < employees.size(); ++i) {
            if (employees.get(i).getFullName().toLowerCase().matches(regex) == true) {
                results.add(employees.get(i));
            }
        }
        return results;
    }

    @Override
    public ArrayList<Employee> SearchSalaryEmpoyee(float salary, ArrayList<Employee> employees) {
        var results = new ArrayList<Employee>();
        for (int i = 0; i < employees.size(); ++i) {
            if (employees.get(i).getSalary() >= salary) {
                results.add(employees.get(i));
            }
        }
        return results;
    }

    @Override
    public ArrayList<Employee> deleteAEmployeeInFile(String id, ArrayList<Employee> employees) {
        for (int i = 0; i < employees.size(); ++i) {
            if (employees.get(i).getIdEmployee().equals(id) == true) {
                employees.remove(employees.get(i));
            }
        }
        return employees;
    }

    @Override
    public boolean checkExitElement(String id, ArrayList<Employee> employees) {
        for (int i = 0; i < employees.size(); ++i) {
            if (employees.get(i).getIdEmployee().equals(id) == true) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Manager> searchNameManagerByYear(ArrayList<Manager> managers,
                                                      String startDay, String endDay) {
        ArrayList<Manager> results = new ArrayList<>();
        double time1 = parseTime(startDay);
        double time2 = parseTime(endDay);
        for (int i = 0; i < managers.size(); ++i) {
            String[] splitTime1 = managers.get(i).getStartDayOfWork().split("\\/");
            String[] splitTime2 = managers.get(i).getEndDayOfWork().split("\\/");
            if (parseTime(splitTime1[2]) >= time1
                    && parseTime(splitTime2[2]) <= time2) {
                results.add(managers.get(i));
            }
        }
        return results;
    }

    @Override
    public double parseTime(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        long resTime = 0;
        try {
            Date parseTime = simpleDateFormat.parse(time);
            resTime = parseTime.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resTime;

    }

    @Override
    public float payRoll(String id, ArrayList<Employee> employees) {
        float result = 0;
        for(int i = 0; i < employees.size(); ++i){
            if(employees.get(i).getIdEmployee().equals(id) == true){
                if(employees.get(i).getDayOfWork() > 25){
                    result = (float) (employees.get(i).getSalary()*0.05);
                }
                if(employees.get(i).getDayOfWork() < 25){
                    result = (float) (employees.get(i).getSalary()*0.01);
                }
            }
        }
        return result;
    }

    @Override
    public double parseDateOfBirth(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        long result = 0;
        try {
            Date date = simpleDateFormat.parse(time);
            result = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
