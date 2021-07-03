package function.sort;

import model.Employee;

import java.util.ArrayList;

public class SortByNameEmpASC {
    public void sortByNameEmpASC(ArrayList<Employee> employees) {
        for (int i = 0; i < employees.size(); ++i) {
            for (int j = employees.size()-1; j > i; j--) {
                Employee bj = employees.get(j);
                Employee bbj = employees.get(j - 1);
                if (bj.getFullName().substring(bj.getFullName().lastIndexOf(" ")).
                        compareTo(bbj.getFullName().substring(bbj.getFullName().lastIndexOf(" "))) < 0) {
                    employees.set(j, bbj);
                    employees.set(j - 1, bj);
                }
            }
        }
    }
}
