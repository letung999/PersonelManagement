package dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Connect {
    public static final String NAME_SERVER = "DESKTOP-8UI3VBN\\SQLEXPRESS";
    public static final String NAME_DB = "USER_MANAGERMENT";
    public static final String NAME_USER = "sa";
    public static final String PASSWORD = "123";
    public static final int PORT = 1433;


    public SQLServerDataSource config() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName(NAME_SERVER);
        ds.setDatabaseName(NAME_DB);
        ds.setUser(NAME_USER);
        ds.setPassword(PASSWORD);
        ds.setPortNumber(PORT);
        return ds;
    }


}
