package app.moneylover.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
    public static Connection connection;

    static {
        try {
            connection = getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        String hostName = "localhost";
        String dbName = "moneylover_db";
        String userName = "root";
        String password = "";
        return getConnection(hostName, dbName, userName, password);
    }

    public static Connection getConnection
    (
        String hostName,
        String dbName,
        String userName,
        String password
    )
        throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection connection = DriverManager.getConnection(connectionURL, userName, password);

        return connection;
    }
}
