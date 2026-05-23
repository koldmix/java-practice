import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int userInpMenu;
        int countTasks = 1;
        String[] arrTasks = new String[countTasks];
        String[] afterAdd = {};

        do {
            showMenu();
            Scanner scannerMenu = new Scanner(System.in);
            userInpMenu = scannerMenu.nextInt();
            if (userInpMenu != 0) {
                switch (userInpMenu) {
                    case 1 -> {
                        addTask(arrTasks);
                        countTasks++;
                        afterAdd = new String[]{Arrays.toString(arrTasks)};
                    }
                    case 2 -> showTasks(afterAdd);
                }
            }
        } while (userInpMenu != 0);
    }

    public static String[] addTask(String[] arr) {
        System.out.println("Введите описание задачи: ");
        Scanner userInTask = new Scanner(System.in);
        String userTask = userInTask.nextLine();

        String[] addTask = new String[arr.length];
        addTask[arr.length - 1] = userTask;

        System.out.println("Задача добавлена!" + "\n");
        return addTask;
    }

    public static void showTasks(String[] strTasks) {
        System.out.println("Список задач:");
        if (strTasks.length == 0) {
            System.out.println("Задач нет" + "\n");
        }
        for (String arrTask : strTasks) {
            System.out.println(arrTask + "\n");
        }
//        return strTasks;
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
