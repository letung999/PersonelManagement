package function;

import model.Employee;

import java.util.ArrayList;

public interface FunctionUtility {
    /**
     *
     * @param time
     * @return
     */
    public double parseTime(String time);

    /**
     *
     * @param id
     * @param employees
     * @return
     */
    public float payRoll(String id,ArrayList<Employee> employees);

    /**
     *
     * @param time
     * @return
     */

    public double parseDateOfBirth(String time);

}
