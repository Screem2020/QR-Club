import com.example.repository.UserRepository;
import com.example.service.QrCodeService;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println(new QrCodeService().qrTouch("b95a570d-b6e5-4bea-bc1e-651cb6408d7a", new UserRepository()));
    }
}
