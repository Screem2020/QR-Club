import process.UserOperations;
import qr.QrProgram;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println(new QrProgram().qrTouch("6fc840e3-a8d3-44bf-823c-f3b901b5326d", new UserOperations()));
    }
}
