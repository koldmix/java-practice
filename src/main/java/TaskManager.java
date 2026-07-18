import java.util.Scanner;

public class TaskManager {

    private static final Scanner scanner = new Scanner(System.in);
    private final TaskHandlerImpl taskHandlerImpl = new TaskHandlerImpl();
    private final UserService userService = new UserService();
    private final DatabaseTaskHandler databaseTaskHandler = new DatabaseTaskHandler(Integer.parseInt(userService.saveUser()));
    private final TaskPrinter taskPrinter = new TaskPrinter(taskHandlerImpl, databaseTaskHandler);
    String choice = scanner.nextLine();
    int userInpMenu = -1;

    public void saveInMemory() {

        do {
            TaskPrinter.showMenu();
            String input = scanner.nextLine();

            try {
                userInpMenu = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
                continue;
            }

            if (userInpMenu > 4 || userInpMenu < 0) {
                System.out.println("Такого пункта меню нет");
            }
            if (userInpMenu != 0) {
                switch (userInpMenu) {
                    case 1 -> taskHandlerImpl.addTask();
                    case 2 -> taskPrinter.showTasks();
                    case 3 -> taskHandlerImpl.deleteTaskByNum();
                    case 4 -> taskHandlerImpl.markAsComplete();
                }
            }
        } while (userInpMenu != 0);
    }

    public void saveInDB() {
        do {
            TaskPrinter.showMenu();
            String input = scanner.nextLine();

            try {
                userInpMenu = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
                continue;
            }

            if (userInpMenu > 4 || userInpMenu < 0) {
                System.out.println("Такого пункта меню нет");
            }
            if (userInpMenu != 0) {
                switch (userInpMenu) {
                    case 1 -> databaseTaskHandler.addTask();
                    case 2 -> taskPrinter.showTaskByDB();
                    case 3 -> databaseTaskHandler.deleteTaskByNum();
                    case 4 -> databaseTaskHandler.markAsComplete();
                }
            }
        } while (userInpMenu != 0);
    }


    public void start() {
        System.out.println("""
                Выберите как вы хотите сохранять задачи:
                1 - В память.
                2 - В базу данных.
                """);

        if ("1".equals(choice)) {
            saveInMemory();
        } else if ("2".equals(choice)) {
            saveInDB();
        }
    }
}
