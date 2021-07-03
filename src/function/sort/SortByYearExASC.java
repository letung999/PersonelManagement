package function.sort;

import model.Employee;

import java.util.Comparator;

public class SortByYearExASC implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getYearExp().compareTo(o2.getYearExp());
    }
}
