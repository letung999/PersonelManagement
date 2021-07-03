package view;

import controller.Controller;
import dao.DeleteData;
import dao.LoadData;
import dao.UpdateData;
import dao.WriteData;
import exception.InvalidDateOfBirthException;
import exception.InvalidEmailException;
import exception.InvalidFullNameException;
import exception.InvalidPhoneException;
import function.sort.*;
import model.Employee;
import model.Manager;
import random.IDEmployee;
import random.IDPerson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var employeeFileName = "EMPLOYEE.DAT";
        var managerFileName = "MANAGER.DAT";
        var controller = new Controller();
        var listEmployee = new ArrayList<Employee>();
        var listManager = new ArrayList<Manager>();
        var idPerson = new IDPerson();
        var idEmp = new IDEmployee();
        var sortNameASC = new SortByNameEmpASC();
        var sortNameDESC = new SortByNameEmpDESC();
        var sortOldAsc = new SortByOldASC();
        var sortOldDesc = new SortByOldDESC();
        var loadDataBase = new LoadData();
        var addDataBase = new WriteData();
        var setDataBase = new UpdateData();
        var deleteDataBase = new DeleteData();
        int option;
        do {
            System.out.println("**************************MENU**************************");
            System.out.println("1.Add a Employee in List");
            System.out.println("2.Show Information Employee In List");
            System.out.println("3.Add a Manager in List");
            System.out.println("4.Show a Manager in List");
            System.out.println("5.Search Employee By Name ");
            System.out.println("6.Search Employee By Salary");
            System.out.println("7.Delete Employee By IdEmployee");
            System.out.println("8.Search Name Manager By Year of Work");
            System.out.println("9.Show Salary Bonus for a Employee");
            System.out.println("10.Sort Information");
            System.out.println("11.Connect DataBase");
            System.out.println("0.break");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0: {
                    break;
                }
                case 1: {
                    Employee employee = new Employee();
                    String personID, fullName, address, datePfBirth,
                            email, phone, idEmployee, role, yearExp;
                    int dayOfWork;
                    float salary;
                    int optionRole;
                    personID = idPerson.getId();
                    employee.setPersonID(personID);
                    do {
                        System.out.println("Enter FullName:");
                        fullName = scanner.nextLine();
                        try {
                            employee.setFullName(fullName);
                            break;
                        } catch (InvalidFullNameException e) {
                            System.out.println("Occur InvalidFullNameException");
                            System.out.println(e.getMessage());
                        }
                    } while (true);

                    System.out.println("Enter Address");
                    address = scanner.nextLine();
                    employee.setAddress(address);
                    do {
                        System.out.println("Enter Date Of Birth");
                        datePfBirth = scanner.nextLine();
                        try {
                            employee.setDateOfBirth(datePfBirth);
                            break;
                        } catch (InvalidDateOfBirthException e) {
                            System.out.println("Occur InvalidDateOfBirthException");
                            System.out.println(e.getMessage());
                        }
                    } while (true);

                    do {
                        System.out.println("Enter Email");
                        email = scanner.nextLine();
                        try {
                            employee.setEmail(email);
                            break;
                        } catch (InvalidEmailException e) {
                            System.out.println("Occur InvalidEmailException");
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    do {
                        System.out.println("Enter Phone Number");
                        phone = scanner.nextLine();
                        try {
                            employee.setPhone(phone);
                            break;
                        } catch (InvalidPhoneException e) {
                            System.out.println("occur InvalidPhoneException");
                            System.out.println(e.getMessage());
                        }
                    }while (true);

                    idEmployee = idEmp.getId();
                    employee.setIdEmployee(idEmployee);
                    do {
                        System.out.println("Enter Role");
                        System.out.println("1.FRESHER\n2.JUNIOR\n3.SENIOR\n3.LEAD\n4.CEO");
                        System.out.println("your option?");
                        option = scanner.nextInt();
                        if (option >= 1 && option <= 4) {
                            role = controller.getRole(option);
                            employee.setRole(role);
                            break;
                        }
                    } while (true);
                    System.out.println("Enter Year Experiences ");
                    scanner.nextLine();
                    yearExp = scanner.nextLine();
                    employee.setYearExp(yearExp);
                    System.out.println("Enter Day Of Work");
                    dayOfWork = scanner.nextInt();
                    employee.setDayOfWork(dayOfWork);
                    System.out.println("Enter Salary");
                    salary = scanner.nextFloat();
                    employee.setSalary(salary);
                    listEmployee.add(employee);
                    controller.writeData(employeeFileName, listEmployee);
                    break;
                }
                case 2: {
                    System.out.println("**********************Information**********************");
                    listEmployee = controller.loadData(employeeFileName);
                    controller.showInformationEmployee(listEmployee);
                    break;
                }
                case 3: {
                    Manager manager = new Manager();
                    String personID, fullName, address, datePfBirth,
                            email, phone, idEmployee, role, yearExp;
                    int dayOfWork;
                    float salary;
                    int optionRole;
                    String startDayOfWork, endDayOfWork;
                    personID = idPerson.getId();
                    manager.setPersonID(personID);
                    do {
                        System.out.println("Enter FullName:");
                        fullName = scanner.nextLine();
                        try {
                            manager.setFullName(fullName);
                            break;
                        } catch (InvalidFullNameException e) {
                            System.out.println("Occur InvalidFullNameException");
                            System.out.println(e.getMessage());
                        }
                    } while (true);

                    System.out.println("Enter Address");
                    address = scanner.nextLine();
                    manager.setAddress(address);
                    do {
                        System.out.println("Enter Date Of Birth(dd/mm/yyyy)");
                        datePfBirth = scanner.nextLine();
                        try {
                            manager.setDateOfBirth(datePfBirth);
                            break;
                        } catch (InvalidDateOfBirthException e) {
                            System.out.println("Occur InvalidDateOfBirthException");
                            System.out.println(e.getMessage());
                        }
                    } while (true);

                    do {
                        System.out.println("Enter Email");
                        email = scanner.nextLine();
                        try {
                            manager.setEmail(email);
                            break;
                        } catch (InvalidEmailException e) {
                            System.out.println("Occur InvalidEmailException");
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    do {
                        System.out.println("Enter Phone Number");
                        phone = scanner.nextLine();
                        try {
                            manager.setPhone(phone);
                            break;
                        } catch (InvalidPhoneException e) {
                            System.out.println("occur InvalidPhoneException");
                            System.out.println(e.getMessage());
                        }
                    }while (true);

                    idEmployee = idEmp.getId();
                    manager.setIdEmployee(idEmployee);
                    do {
                        System.out.println("Enter Role");
                        System.out.println("1.FRESHER\n2.JUNIOR\n3.SENIOR\n4.LEAD\n5.DIRECTOR\n6.CEO");
                        System.out.println("your option?");
                        option = scanner.nextInt();
                        if (option >= 1 && option <= 6) {
                            role = controller.getRole(option);
                            manager.setRole(role);
                            break;
                        }
                    } while (true);
                    System.out.println("Enter Year Experiences ");
                    scanner.nextLine();
                    yearExp = scanner.nextLine();
                    manager.setYearExp(yearExp);
                    System.out.println("Enter Number Days Of Work");
                    dayOfWork = scanner.nextInt();
                    manager.setDayOfWork(dayOfWork);
                    System.out.println("Enter Salary");
                    salary = scanner.nextFloat();
                    manager.setSalary(salary);
                    scanner.nextLine();
                    do {
                        System.out.println("Enter start Day for Work(dd/MM/yyyy)");
                        startDayOfWork = scanner.nextLine();
                        try {
                            manager.setStartDayOfWork(startDayOfWork);
                            break;
                        } catch (InvalidDateOfBirthException e) {
                            System.out.println("Occur InvalidDateException");
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    do {
                        System.out.println("Enter End Day for Work(dd/MM/yyyy)");
                        endDayOfWork = scanner.nextLine();
                        try {
                            manager.setEndDayOfWork(endDayOfWork);
                            break;
                        } catch (InvalidDateOfBirthException e) {
                            System.out.println("Occur InvalidDateException");
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    listManager.add(manager);
                    controller.writeData(managerFileName, listManager);
                    break;
                }
                case 4: {
                    System.out.println("**********************Information**********************");
                    listManager = controller.loadData(managerFileName);
                    controller.showInformationManager(listManager);
                    break;
                }
                case 5: {
                    System.out.println("**********************Information**********************");
                    listEmployee = controller.loadData(employeeFileName);
                    controller.showInformationEmployee(listEmployee);
                    String name;
                    System.out.println("Enter Name To Search");
                    name = scanner.nextLine();
                    var result = controller.SearchNameEmployee(name, listEmployee);
                    if (result.size() > 0) {
                        controller.showInformationEmployee(result);
                    } else {
                        System.out.println("No Information to Search");
                    }
                    break;
                }
                case 6: {
                    System.out.println("**********************Information**********************");
                    listEmployee = controller.loadData(employeeFileName);
                    controller.showInformationEmployee(listEmployee);
                    float salary;
                    System.out.println("Enter salary To Search");
                    salary = scanner.nextFloat();
                    var result = controller.SearchSalaryEmpoyee(salary, listEmployee);
                    if (result.size() > 0) {
                        controller.showInformationEmployee(result);
                    } else {
                        System.out.println("No Information to Search");
                    }
                    break;
                }
                case 7: {
                    System.out.println("**********************Information**********************");
                    listEmployee = controller.loadData(employeeFileName);
                    controller.showInformationEmployee(listEmployee);
                    String id;
                    System.out.println("Enter IdEmployee To Delete");
                    id = scanner.nextLine();
                    if (controller.checkExitElement(id, listEmployee) == false) {
                        System.out.println("Employee no exits in File");
                        break;
                    }
                    var result = controller.deleteAEmployeeInFile(id, listEmployee);
                    controller.showInformationEmployee(result);
                    break;
                }
                case 8: {
                    String startTime, endTime;
                    System.out.println("**********************Information**********************");
                    listManager = controller.loadData(managerFileName);
                    controller.showInformationManager(listManager);
                    System.out.println("Enter start Time");
                    startTime = scanner.nextLine();
                    System.out.println("Enter end Time");
                    endTime = scanner.nextLine();
                    var result =
                            controller.searchNameManagerByYear(listManager, startTime, endTime);
                    if (result.size() < 0) {
                        System.out.println("No Information to in list");
                    }
                    controller.showInformationManager(result);
                    break;
                }
                case 9: {
                    System.out.println("**********************Information**********************");
                    listEmployee = controller.loadData(employeeFileName);
                    controller.showInformationEmployee(listEmployee);
                    String id;
                    float pay;
                    System.out.println("Enter Id Employee");
                    id = scanner.nextLine();
                    if (controller.checkExitElement(id, listEmployee) == false) {
                        System.out.println("Employee not exits in System");
                        break;
                    }
                    pay = controller.payRoll(id, listEmployee);
                    System.out.println("salary bonus:" + pay);
                    break;
                }
                case 10: {
                    int choose;
                    do {
                        System.out.println("***********************SORT***********************");
                        System.out.println("1.Sort By Name Employee ASC");
                        System.out.println("2.Sort By Name Employee DESC");
                        System.out.println("3.Sort By old Employee ASC");
                        System.out.println("4.Sort By old Employee DESC");
                        System.out.println("5.Sort By Salary Employee ASC");
                        System.out.println("6.Sort By Salary Employee DESC");
                        System.out.println("7.Sort By Year Experiences Employee ASC");
                        System.out.println("8.Sort By Year Experiences Employee DESC");
                        System.out.println("0.return main menu");
                        System.out.println("your option?");
                        choose = scanner.nextInt();
                        switch (choose) {
                            case 0: {
                                System.out.println("exit");
                                break;
                            }
                            case 1: {
                                listEmployee = controller.loadData(employeeFileName);
                                sortNameASC.sortByNameEmpASC(listEmployee);
                                controller.showInformationEmployee(listEmployee);
                                break;
                            }
                            case 2: {
                                listEmployee = controller.loadData(employeeFileName);
                                sortNameDESC.sortByNameEmpASC(listEmployee);
                                controller.showInformationEmployee(listEmployee);
                                break;
                            }
                            case 3: {
                                listEmployee = controller.loadData(employeeFileName);
                                sortOldAsc.sortOldASC(listEmployee);
                                controller.showInformationEmployee(listEmployee);
                                break;
                            }
                            case 4: {
                                listEmployee = controller.loadData(employeeFileName);
                                sortOldDesc.sortOldASC(listEmployee);
                                controller.showInformationEmployee(listEmployee);
                                break;
                            }
                            case 5: {
                                listEmployee = controller.loadData(employeeFileName);
                                Collections.sort(listEmployee, new SortBySalaryASC());
                                controller.showInformationEmployee(listEmployee);
                                break;
                            }
                            case 6: {
                                listEmployee = controller.loadData(employeeFileName);
                                Collections.sort(listEmployee, new SortBySalaryDESC());
                                controller.showInformationEmployee(listEmployee);
                                break;
                            }
                            case 7: {
                                listEmployee = controller.loadData(employeeFileName);
                                Collections.sort(listEmployee, new SortByYearExASC());
                                controller.showInformationEmployee(listEmployee);
                                break;
                            }
                            case 8: {
                                listEmployee = controller.loadData(employeeFileName);
                                Collections.sort(listEmployee, new SortByYearExDESC());
                                controller.showInformationEmployee(listEmployee);
                                break;
                            }

                        }

                    } while (choose != 0);
                }
                case 11: {
                    int options;
                    do {

                        System.out.println("********************ConnectDataBase********************");
                        System.out.println("1.Add Data Employees in DataBase");
                        System.out.println("2.Load Data Employees in DataBase");
                        System.out.println("3.Update Data Employees in DataBase");
                        System.out.println("4.Delete a Data ");
                        System.out.println("0.return main menu");
                        options = scanner.nextInt();
                        switch (options) {
                            case 0: {
                                System.out.println("exits");
                                break;
                            }
                            case 1: {
                                /*list employess load from file*/
                                listEmployee = controller.loadData(employeeFileName);
                                /*list employees load from database*/
                                var listEmpDb = loadDataBase.getData();
                                /*list result*/
                                var results = new ArrayList<Employee>();
                                for (int i = 0; i < listEmployee.size(); ++i) {
                                    if (controller.checkExitElement
                                            (listEmployee.get(i).getIdEmployee(), listEmpDb) == false) {
                                        results.add(listEmployee.get(i));
                                    }
                                }
                                int check = addDataBase.insertData(results);
                                if (check != -1) {
                                    System.out.println("INSERT SUCCESS");
                                } else System.out.println("FAIL");
                                break;
                            }
                            case 2: {
                                listEmployee = loadDataBase.getData();
                                controller.showInformationEmployee(listEmployee);
                                break;
                            }
                            case 3: {
                                int choose;
                                String newRole;
                                String id;
                                System.out.println("**********************Information**********************");
                                listEmployee = loadDataBase.getData();
                                controller.showInformationEmployee(listEmployee);
                                System.out.println("Enter ID Employee to update");
                                scanner.nextLine();
                                id = scanner.nextLine();
                                if (controller.checkExitElement(id, listEmployee) == false) {
                                    System.out.println("Employee no exits in File");
                                    break;
                                }
                                do {
                                    System.out.println("Enter Role");
                                    System.out.println("1.FRESHER\n2.JUNIOR\n3.SENIOR\n4.LEAD\n5.DIRECTOR\n6.CEO");
                                    System.out.println("your option?");
                                    choose = scanner.nextInt();
                                    if (choose >= 1 && choose <= 6) {
                                        newRole = controller.getRole(choose);
                                        break;
                                    }
                                } while (true);
                                int check = setDataBase.updateData(id, newRole);
                                if (check != -1) {
                                    System.out.println("INSERT SUCCESS");
                                } else System.out.println("FAIL");
                                break;

                            }
                            case 4: {
                                String id;
                                listEmployee = loadDataBase.getData();
                                System.out.println("Enter ID Employee to Delete");
                                scanner.nextLine();
                                id = scanner.nextLine();
                                if (controller.checkExitElement(id, listEmployee) == false) {
                                    System.out.println("ID Employee not exits in DataBase");
                                }
                                deleteDataBase.deleteData(id);
                                System.out.println("********************RESULT********************");
                                var results = loadDataBase.getData();
                                controller.showInformationEmployee(results);
                                break;
                            }
                        }
                    } while (options != 0);

                }

            }

        } while (option != 0);

    }
}
