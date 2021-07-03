package function.sort;

import model.Employee;

import java.util.Comparator;

public class SortByYearExDESC implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getYearExp().compareTo(o1.getYearExp());
    }
}
