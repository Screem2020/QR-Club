package process;

import connect.ConnectionToBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserOperations {

    public void insert(String surname, String firstName, String patronymic) throws SQLException {
        String sql = "INSERT INTO users_club (surname, first_name, patronymic) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionToBase.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, surname);
            statement.setString(2, firstName);
            statement.setString(3, patronymic);
            statement.executeUpdate();
        }
    }

    public int delete(int uuid) throws SQLException {
        String sql = "DELETE FROM users_club WHERE uuid = ?";
        try (Connection conn = ConnectionToBase.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, uuid);
            int quantity = statement.executeUpdate();
            if (quantity > 0) {
                return 1;
            } else {
                System.out.println("User " + uuid + ", " + "not exist");
                return -1;
            }
        }
    }

    public void update(int uuid, String surname, String firstName, String patronymic) throws SQLException {
        String sql = "UPDATE users_club SET surname = ?, first_name = ?, patronymic = ? WHERE uuid = ?";
        try (Connection conn = ConnectionToBase.getConnection();
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

    public User select(int uuid) throws SQLException {
        String sql = "SELECT * FROM users_club WHERE uuid = ?";
        try (Connection conn = ConnectionToBase.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, uuid);
            try (ResultSet resultSet = statement.executeQuery()) {
                String surname = "";
                String firstName = "";
                String patronymic = "";
                while (resultSet.next()) {
                    surname = resultSet.getString("surname");
                    firstName = resultSet.getString("first_name");
                    patronymic = resultSet.getString("patronymic");
                }
                return new User(surname, firstName, patronymic);
            }
        }
    }

    public List<User> selectAll() throws SQLException {
        List<User> listUsers = new ArrayList<>();
        try (Connection conn = ConnectionToBase.getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users_club");
            while (resultSet.next()) {
                int uuid = resultSet.getInt("uuid");
                String surname = resultSet.getString("surname");
                String firstName = resultSet.getString("first_name");
                String patronymic = resultSet.getString("patronymic");
                listUsers.add(new User(uuid, surname, firstName, patronymic));
            }
            return listUsers;
        }
    }
}
