import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class DatabaseTaskHandler implements TaskHandler {
    private Scanner scanner = new Scanner(System.in);
    private TaskHandlerImpl thi = new TaskHandlerImpl();
    private int userId;

    public DatabaseTaskHandler(int userId) {
        this.userId = userId;
    }

    @Override
    public void addTask() {
        thi.addTask();
        Task task = thi.returnAddedTask();

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
        String deleteByUserId = "DELETE FROM tasks where id = ?";
        System.out.println("Введите id задачи для удаления");
        int numForDelete = scanner.nextInt();

        try (Connection con = DatabaseManager.getConnection();
            PreparedStatement ps = con.prepareStatement(deleteByUserId)) {

            ps.setInt(1, numForDelete);
            ps.executeUpdate();
            System.out.println("Задача успешно удалена!");
             userId --;
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении задачи: " + e.getMessage());
        }
    }

    @Override
    public void deleteAllTask() {
        String deleteAll = "DELETE FROM tasks";
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
        String updStatus = "UPDATE tasks SET status = 'COMPLETED' where id = ?";

        int numForMark = ConsoleParser.readDeleteNumFromConsole();

        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(updStatus)) {

            ps.setInt(1, numForMark);
            ps.executeUpdate();
            System.out.println("Статус задачи обновлён!");
        }catch (SQLException e) {
            System.err.println("Ошибка при изменении статуса задач: " + e.getMessage());
        }
    }

    @Override
    public void getAllTasks() {
      String getAllTasks = "SELECT * FROM tasks";

        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(getAllTasks)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String title = rs.getString("title");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String priority = rs.getString("priority");
                int user_id = rs.getInt("id");

                System.out.println("Название: " + title +
                                    " Описание: " + description +
                                    " Статус: " + status +
                                    " Приоритет: " + priority +
                                    " id: " + user_id);
            }
            System.out.println("Вывод списка задач завершён");
        }catch (SQLException e) {
            System.err.println("Ошибка при выводе списка задач: " + e.getMessage());
        }
    }
}
