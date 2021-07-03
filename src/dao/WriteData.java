package dao;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class WriteData {
    public int insertData(ArrayList<Employee> employees) {
        var connect = new Connect();
        var ds = connect.config();
        try {
            var conn = ds.getConnection();
            var sql = "INSERT INTO dbo.EMPLOYEE VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            var ps = conn.prepareStatement(sql);
            for (var employee : employees) {
                ps.setString(1, employee.getPersonID());
                ps.setString(2, employee.getFullName());
                ps.setString(3, employee.getAddress());
                ps.setString(4, employee.getDateOfBirth());
                ps.setString(5, employee.getEmail());
                ps.setString(6, employee.getPhone());
                ps.setString(7, employee.getIdEmployee());
                ps.setString(8, employee.getRole());
                ps.setString(9, employee.getYearExp());
                ps.setInt(10, employee.getDayOfWork());
                ps.setFloat(11, employee.getSalary());
                ps.executeUpdate();
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
            return -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
        return 0;
    }
}
