import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] arrTasks = new String[100];
    private static int countTasks = 0;

    public static void main(String[] args) {

        int userInpMenu = -1;

        do {
            showMenu();
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
                    case 1 -> {
                        addTask();
                        countTasks++;
                    }
                    case 2 -> showTasks();
                    case 3 -> countTasks = deleteTask();
                    case 4 -> markAsComplete();
                }
            }
        } while (userInpMenu != 0);
    }

    private static void addTask() {
        if (countTasks >= 99) {
            System.out.println("Список задач заполнен.");
            return;
        }

        System.out.println("Введите описание задачи: ");
        String userTask = scanner.nextLine();

        arrTasks[countTasks] = "[ ]" + userTask;

        System.out.println("Задача добавлена!" + "\n");
    }

    private static void showTasks() {
        if (countTasks == 0) {
            System.out.println("Задач нет" + "\n");
            return;
        }
        System.out.println("Список задач:");

        for (int i = 0; i < countTasks; i++) {
            if (arrTasks[i] != null)
                System.out.print(i + 1 + ". " + arrTasks[i] + "\n");
        }
        System.out.println();
    }

    private static int deleteTask() {
        try {
            System.out.println("Введите номер задачи для удаления: ");
            int userDel = scanner.nextInt();

            if (arrTasks[userDel - 1] != null) {
                for (int i = userDel - 1; i < countTasks; i++) {
                    arrTasks[i] = arrTasks[i + 1];
                }
            } else {
                System.out.println("Такой задачи не существует");
            }
            System.out.println("Задача " + "\"" + arrTasks[userDel - 1] + "\"" + " удалена!");
        } catch (Exception e) {
            System.out.println("Такой задачи не существует");
        }
        return countTasks - 1;
    }

    private static void markAsComplete() {
        try {

            System.out.println("Введите номер задачи для отметки: ");
            int userMark = scanner.nextInt();

            if (userMark == 0) {
                System.out.println("Такой задачи нет");
            }

            if (arrTasks[userMark - 1] != null) {
                arrTasks[userMark - 1] = arrTasks[userMark - 1].replace("[ ]", "[x]");
                System.out.println("Задача " + "\"" + arrTasks[userMark - 1] + "\"" + " отмечена как выполненная!");
            } else
                System.out.println("Такой задачи нет");
        } catch (Exception e) {
            System.out.println("Такой задачи не существует");
        }
    }

    private static void showMenu() {
        System.out.println("""
                >>> Меню:\s
                1. Добавить задачу
                2. Показать все задачи
                3. Удалить задачу (по номеру)
                4. Отметить задачу как выполненную
                0. Выход
                
                Выберите пункт меню:
                """);
    }
}
