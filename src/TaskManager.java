import java.util.List;
import java.util.Scanner;

public class TaskManager {

    private static Scanner scanner = new Scanner(System.in);
    private TaskHandlerImpl taskHandlerImpl = new TaskHandlerImpl();
    private TaskPrinter taskPrinter = new TaskPrinter(taskHandlerImpl);

    public void start() {
        int userInpMenu = -1;

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
}
