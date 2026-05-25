import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int userInpMenu;
        String[] afterAdd = {};
        String[] arrTasks = new String[100];
        int countTasks = 1;

        do {
            showMenu();
            Scanner scannerMenu = new Scanner(System.in);
            userInpMenu = scannerMenu.nextInt();
            if (userInpMenu != 0) {
                switch (userInpMenu) {
                    case 1 -> {
                        afterAdd = addTask(arrTasks, countTasks);
                        countTasks++;
                    }
                    case 2 -> showTasks(afterAdd);
                }
            }
        } while (userInpMenu != 0);
    }

    public static String[] addTask(String[] arr, int realCountTasks) {
        System.out.println("Введите описание задачи: ");
        Scanner userInTask = new Scanner(System.in);
        String userTask = userInTask.nextLine();

        arr[realCountTasks] = userTask;

        System.out.println("Задача добавлена!" + "\n");
        return arr;
    }

    public static void showTasks(String[] strTasks) {
        System.out.println("Список задач:");
        if (strTasks.length == 0) {
            System.out.println("Задач нет" + "\n");
        }
//        for (String arrTask : strTasks) {
//            if (arrTask != null)
//            System.out.print("[ ] " + arrTask + "\n");
//        }
        for (int i = 0; i < strTasks.length; i++) {
            if (strTasks[i] != null)
                System.out.print(i + ". " + "[ ] " + strTasks[i] + "\n");
        }
        System.out.println("");
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
