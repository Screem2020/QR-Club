import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {

    public void addUserName(String surname, String firstName, String patronymic) throws SQLException {
        String sql = "INSERT INTO users_club (surname, first_name, patronymic) VALUES (?, ?, ?)";
        try(Connection conn = ConnectionToBase.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1,surname);
            statement.setString(2,firstName);
            statement.setString(3,patronymic);
            statement.executeUpdate();
            System.out.println("User added " + surname + " " + firstName +" " + patronymic);
        }
    }
    public void deleteUser(String surname, String firstName, String patronymic) throws SQLException {
        String sql = "DELETE FROM users_club WHERE surname = ? AND first_name  = ? AND patronymic = ?";
        try(Connection conn = ConnectionToBase.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, surname);
            statement.setString(2, firstName);
            statement.setString(3, patronymic);
            int quantity = statement.executeUpdate();
            if (quantity > 0) {
                System.out.println();
                System.out.println("User delete " + surname + " " + firstName +
                        " " + patronymic);
            } else {
                System.out.println("Error");
            }
        }
    }

    public void updateUser(int uuid, String surname, String firstName, String patronymic) throws SQLException {
        String sql = "UPDATE users_club SET surname = ?, first_name = ?, patronymic = ? WHERE uuid = ?";
        try(Connection conn = ConnectionToBase.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, surname);
            statement.setString(2, firstName);
            statement.setString(3, patronymic);
            statement.setInt(4, uuid);
            int quantity = statement.executeUpdate();
            if (quantity > 0) {
                System.out.println("User update " + surname + " " + firstName +
                        " " + patronymic);
            } else {
                System.out.println("Error");
            }
        }
    }
}
