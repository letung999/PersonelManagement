package dao;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;


public class UpdateData {
    public int updateData(String id, String newRole) {
        var connect = new Connect();
        var ds = connect.config();
        try {
            var conn = ds.getConnection();
            var sql = "UPDATE dbo.EMPLOYEE SET role='" + newRole + "'" + "WHERE idEmployee ='" + id + "'";
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
