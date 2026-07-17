import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    public String saveUser (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя пользователя: ");
        String userName = sc.nextLine();
        String insertSql = "INSERT INTO users (name) VALUES (?)";
        String selectSql = "SELECT id FROM users WHERE name = ?";

        try (Connection connect = DatabaseManager.getConnection();
             PreparedStatement insertPs = connect.prepareStatement(insertSql);
             PreparedStatement selectPs = connect.prepareStatement(selectSql)) {

            insertPs.setString(1, userName);
            insertPs.executeUpdate();

            selectPs.setString(1, userName);
            ResultSet rs = selectPs.executeQuery();
            if (rs.next())
                return String.valueOf(rs.getInt("id"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userName;
    }
}
