import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseTaskHandler implements TaskHandler {
    private List<Task> taskList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy");
    private TaskHandlerImpl thi = new TaskHandlerImpl();
    private int countTask = 1;
    private final int userId;

    public DatabaseTaskHandler(int userId) {
        this.userId = userId;
    }

    @Override
    public void addTask() {
        thi.addTask();

        String sql = "INSERT INTO tasks (title, description, status, priority, user_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, task.getName());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus().name());
            ps.setString(4, task.getPriority().name());
            ps.setInt(5, userId);

            ps.executeUpdate();
            System.out.println("Задача успешно сохранена в базу данных!");

        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении задачи: " + e.getMessage());
        }
    }

    @Override
    public void deleteTaskByNum() {
        String deleteByUserId = "DELETE * FROM tasks where id = ?";
        try (Connection con = DatabaseManager.getConnection();
            PreparedStatement ps = con.prepareStatement(deleteByUserId)) {

            ps.setInt(1, userId);
            ps.executeUpdate();
            System.out.println("Задача успешно удалена!");

        } catch (SQLException e) {
            System.err.println("Ошибка при удалении задачи: " + e.getMessage());
        }
    }

    @Override
    public void deleteAllTask() {
        String deleteAll = "DELETE * FROM tasks";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteAll)) {

            ps.executeUpdate();
            System.out.println("Задачи успешно удалены!");

        } catch (SQLException e) {
            System.err.println("Ошибка при удалении задач: " + e.getMessage());
        }
    }

    @Override
    public void markAsComplete() {

    }

    @Override
    public void getAllTasksByName(String nameForFind) {

    }
}
