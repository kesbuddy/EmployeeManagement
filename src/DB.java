import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    static Connection connect = null;
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost/";
            String db = "employee";
            String username = "root";
            String password = "priyanshu";
            // establishing a connection 
            Connection connect = DriverManager.getConnection(url+db, username, password);
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
