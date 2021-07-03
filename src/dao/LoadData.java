package dao;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoadData {
    public ArrayList<Employee> getData() {
        var list = new ArrayList<Employee>();
        var connect = new Connect();
        var ds = connect.config();
        try {
            var conn = ds.getConnection();
            var sql = "SELECT * FROM dbo.EMPLOYEE";
            var ps = conn.prepareStatement(sql);
            var result = ps.executeQuery();
            while (result.next()) {
                String personID = result.getString(1);
                String fullName = result.getString(2);
                String address = result.getString(3);
                String datePfBirth = result.getString(4);
                String email = result.getString(5);
                String phone = result.getString(6);
                String idEmployee = result.getString(7);
                String role = result.getString(8);
                String yearExp = result.getString(9);
                int dayOfWork = result.getInt(10);
                float salary = result.getFloat(11);
                var employee = new Employee(personID, fullName, address, datePfBirth, email, phone, idEmployee, role,
                        yearExp, dayOfWork, salary);
                list.add(employee);
            }

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

}
