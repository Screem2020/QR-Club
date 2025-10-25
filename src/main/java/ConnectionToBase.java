import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToBase {
    private final String name = "postgres";
    private final String password = "1234";
    private final String connectionsURL  = "jdbc:postgresql://localhost:5432/testdb";

    public void connection() throws SQLException {
        try(Connection conn = DriverManager.getConnection(connectionsURL, name, password)) {
            System.out.println("Connection to PostgresSQL successfully");
        }
    }
}
