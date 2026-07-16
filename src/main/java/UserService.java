import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    public int saveUser (String name){
        String insertSql = "INSERT INTO users (name) VALUES (?)";
        String selectSql = "SELECT id FROM users WHERE name = ?";

        try (Connection connect = DatabaseManager.getConnection();
             PreparedStatement insertPs = connect.prepareStatement(insertSql);
             PreparedStatement selectPs = connect.prepareStatement(selectSql)) {

            insertPs.setString(1, name);
            insertPs.executeUpdate();

            selectPs.setString(1, name);
            ResultSet rs = selectPs.executeQuery();
            if (rs.next())
                return rs.getInt("id");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
}
