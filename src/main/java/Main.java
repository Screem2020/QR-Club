import connect.ConnectionToBase;
import qr.QrProgram;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new ConnectionToBase().connection();
        System.out.println(new QrProgram().qrTouch(48));
    }
}
