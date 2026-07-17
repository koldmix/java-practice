import java.util.Scanner;

public class TaskManager {

    private static Scanner scanner = new Scanner(System.in);
    private TaskHandlerImpl taskHandlerImpl = new TaskHandlerImpl();
    UserService userService = new UserService();
    DatabaseTaskHandler databaseTaskHandler = new DatabaseTaskHandler(Integer.parseInt(userService.saveUser()));
    private TaskPrinter taskPrinter = new TaskPrinter(taskHandlerImpl, databaseTaskHandler);

    public void start() {
        System.out.println("""
                Выберите как вы хотите сохранять задачи:
                1 - В память.
                2 - В базу данных.
                """);
        String choice = scanner.nextLine();
        int userInpMenu = -1;

        if (choice.equals("1")){

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
        }else if (choice.equals("2")){

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
    }
}
