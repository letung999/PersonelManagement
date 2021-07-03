package function;

import model.Employee;
import model.Manager;

import java.util.ArrayList;

public interface FunctionData {
    /**
     *
     * @param fileName
     * @param list
     */
    public void writeData(String fileName, ArrayList list);

    /**
     *
     * @param fileName
     * @return
     */
    public ArrayList loadData(String fileName);

    /**
     *
     * @param employees
     */
    public void showInformationEmployee(ArrayList<Employee> employees);

    /**
     *
     * @param managers
     */
    public void showInformationManager(ArrayList<Manager> managers);

    /**
     *
     * @param option
     * @return
     */
    public String getRole(int option);

    /**
     *
     * @param name
     * @param employees
     * @return
     */

    public ArrayList<Employee> SearchNameEmployee(String name, ArrayList<Employee> employees);

    /**
     *
     * @param salary
     * @param employee
     * @return
     */


    public ArrayList<Employee> SearchSalaryEmpoyee(float salary, ArrayList<Employee> employee);

    /**
     *
     * @param id
     * @param employees
     * @return
     */

    public ArrayList<Employee> deleteAEmployeeInFile(String id, ArrayList<Employee> employees);

    /**
     *
     * @param id
     * @param employees
     * @return
     */

    public boolean checkExitElement(String id, ArrayList<Employee> employees);

    /**
     *
     * @param managers
     * @param startDay
     * @param endDay
     * @return
     */

    public ArrayList<Manager> searchNameManagerByYear(ArrayList<Manager> managers, String startDay, String endDay);

}
