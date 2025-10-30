package qr;

import process.User;
import process.UserOperations;
import java.sql.SQLException;

public class QrProgram {

    public String qrTouch(int uuid) throws SQLException {
        UserOperations userOperations = new UserOperations();
        User selectUser = userOperations.select(uuid);
        if (userOperations.delete(uuid) > 0) {
            userOperations.insert(selectUser.getSurname(), selectUser.getFirstName(), selectUser.getPatronymic());
        }
        return selectUser.format();
    }
}
