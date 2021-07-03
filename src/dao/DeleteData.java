package dao;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;


public class DeleteData {
    public int deleteData(String employeeID) {
        var connect = new Connect();
        var ds = connect.config();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            var sql = "DELETE FROM dbo.EMPLOYEE WHERE idEmployee ='" + employeeID + "'";
            var ps = conn.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
            return -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }

    }
}
