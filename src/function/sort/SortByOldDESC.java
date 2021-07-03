package function.sort;

import controller.Controller;
import model.Employee;

import java.util.ArrayList;

public class SortByOldDESC {
    public void sortOldASC(ArrayList<Employee> employees) {
        var controller = new Controller();
        for (int i = 0; i < employees.size(); ++i) {
            for (int j = employees.size() - 1; j > i; j--) {
                Employee bj = employees.get(j);
                Employee bbj = employees.get(j-1);
                long resTime1 = (long) controller.parseTime(bj.getDateOfBirth());
                long resTime2 = (long) controller.parseTime(bbj.getDateOfBirth());
                if(resTime2 < resTime1){
                    employees.set(j, bbj);
                    employees.set(j-1, bj);
                }
            }
        }
    }
}
