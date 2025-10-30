package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToBase {
    private static final String userName = "postgres";
    private static final String password = "1234";
    private static final String connectionsURL  = "jdbc:postgresql://localhost:5432/testdb";

    public void connection() throws SQLException {
        try(Connection conn = DriverManager.getConnection(connectionsURL, userName, password)) {
            System.out.println("Connection to PostgresSQL successful");
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionsURL, userName, password);
    }
}
