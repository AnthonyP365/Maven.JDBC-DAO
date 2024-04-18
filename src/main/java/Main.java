import service.Database;
import javax.xml.crypto.Data;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection connection = Database.getConnection(); // test connection
    }
}
