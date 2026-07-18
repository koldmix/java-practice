import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream
                ("src/main/resources/application.properties")){
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {

        String URL = properties.getProperty("db.url");
        String USER = properties.getProperty("db.username");
        String PASSWORD = properties.getProperty("db.password");

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
