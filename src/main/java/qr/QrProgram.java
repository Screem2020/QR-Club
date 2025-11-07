package qr;

import process.User;
import process.UserOperations;
import java.sql.SQLException;
import java.util.UUID;

public class QrProgram {
    public String qrTouch(String uuid, UserOperations userOperations) throws SQLException {
        UUID uuidUser = UUID.fromString(uuid);
        User findUser = userOperations.checkQrCode(uuidUser);
        userOperations.updateQrCode(findUser);
        return findUser.toString();
    }
}
