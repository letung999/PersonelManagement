package function.sort;

import model.Employee;

import java.util.Comparator;

public class SortBySalaryASC implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        float result = o1.getSalary() - o2.getSalary();
        if (result > 0) return 1;
        if (result < 0) return -1;
        return 0;
    }
}
