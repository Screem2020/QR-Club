package qr;

import process.User;
import process.UserOperations;
import java.sql.SQLException;
import java.util.UUID;

public class QrProgram {
    public String qrTouch(String uuid) throws SQLException {
        UUID uuidUser = UUID.fromString(uuid);
        UserOperations userOperations = new UserOperations();
        User findUser = userOperations.checkQrCode(uuidUser);
        if (findUser != null) {
            userOperations.updateQrCode(findUser);
            return findUser.toString();
        }
        return "";
    }
}
