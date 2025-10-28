import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new ConnectionToBase().connection();
        User user = new User();
        user.addUserName("Gavrilov", "Ivan", "Sidorenkov");
        user.updateUser(4, "Alekseev", "Igor", "Vitalievich");
        user.deleteUser("Gavrilov", "Ivan", "Sidorenkov");
    }
}
