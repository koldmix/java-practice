import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int userInpMenu = -1;
        String[] arrTasks = new String[100];
        int countTasks = 0;

        Scanner scannerMenu = new Scanner(System.in);

        do {
            showMenu();
            String input = scannerMenu.nextLine();

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
                        addTask(arrTasks, countTasks);
                        countTasks++;
                    }
                    case 2 -> showTasks(arrTasks, countTasks);
                    case 3 -> countTasks = deleteTask(arrTasks, countTasks);
                    case 4 -> markAsComplete(arrTasks);
                }
            }
        } while (userInpMenu != 0);
    }

    public static void addTask(String[] arr, int realCountTasks) {
        if (realCountTasks >= 99){
            System.out.println("Список задач заполнен.");
            return;
        }

        System.out.println("Введите описание задачи: ");
        Scanner userInTask = new Scanner(System.in);
        String userTask = userInTask.nextLine();

        arr[realCountTasks] = "[ ]" + userTask;

        System.out.println("Задача добавлена!" + "\n");
    }

    public static void showTasks(String[] strTasks, int realCountTasks) {
        if (realCountTasks == 0) {
            System.out.println("Задач нет" + "\n");
            return;
        }
        System.out.println("Список задач:");

        for (int i = 0; i < realCountTasks; i++) {
            if (strTasks[i] != null)
                System.out.print(i + 1 + ". " + strTasks[i] + "\n");
        }
        System.out.println();
    }

    public static int deleteTask(String[] arrTasks, int realCountTasks){
        try {
            System.out.println("Введите номер задачи для удаления: ");
            Scanner userInDelete = new Scanner(System.in);
            int userDel = userInDelete.nextInt();

            if (arrTasks[userDel - 1] != null){
                for (int i = userDel - 1; i < realCountTasks; i++) {
                    arrTasks[i] = arrTasks[i + 1];
                }
            }else {
                System.out.println("Такой задачи не существует");
            }
            System.out.println("Задача " + "\"" + arrTasks[userDel - 1] + "\"" + " удалена!");
        } catch (Exception e) {
            System.out.println("Такой задачи не существует");
        }
        return realCountTasks - 1;
    }

    public static void markAsComplete(String[] arrTask){
        try {

            System.out.println("Введите номер задачи для отметки: ");
            Scanner userMarkCompetition = new Scanner(System.in);
            int userMark = userMarkCompetition.nextInt();

            if (userMark == 0) {
                System.out.println("Такой задачи нет");
            }

            if (arrTask[userMark - 1] != null) {
                arrTask[userMark - 1] = arrTask[userMark - 1].replace("[ ]", "[x]");
                System.out.println("Задача " + "\"" + arrTask[userMark - 1] + "\"" + " отмечена как выполненная!");
            }else
                System.out.println("Такой задачи нет");
        } catch (Exception e) {
            System.out.println("Такой задачи не существует");
        }
    }

    public static void showMenu() {
        System.out.println(">>> Меню:\n" +
                "1. Добавить задачу\n" +
                "2. Показать все задачи\n" +
                "3. Удалить задачу (по номеру)\n" +
                "4. Отметить задачу как выполненную\n" +
                "0. Выход\n" +
                "\n" +
                "Выберите пункт меню:\n");
    }

}
