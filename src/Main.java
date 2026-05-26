import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int userInpMenu;
        String[] arrTasks = new String[100];
        int countTasks = 0;

        do {
            showMenu();
            Scanner scannerMenu = new Scanner(System.in);
            userInpMenu = scannerMenu.nextInt();
            if (userInpMenu != 0) {
                switch (userInpMenu) {
                    case 1 -> {
                        addTask(arrTasks, countTasks);
                        countTasks++;
                    }
                    case 2 -> showTasks(arrTasks, countTasks);
                }
            }
        } while (userInpMenu != 0);
    }

    public static void addTask(String[] arr, int realCountTasks) {
        System.out.println("Введите описание задачи: ");
        Scanner userInTask = new Scanner(System.in);
        String userTask = userInTask.nextLine();

        arr[realCountTasks] = userTask;

        System.out.println("Задача добавлена!" + "\n");
    }

    public static void showTasks(String[] strTasks, int realCountTasks) {
        System.out.println("Список задач:");

        if (realCountTasks == 0) {
            System.out.println("Задач нет" + "\n");
            return;
        }

        for (int i = 0; i < realCountTasks; i++) {
            System.out.print(i + 1 + ". " + "[ ] " + strTasks[i] + "\n");
        }
        System.out.println();
    }

    public static void deleteTask(String[] arrTasks, int realCountTasks){
        System.out.println("Введите номер задачи для удаления: ");
        Scanner userInDelete = new Scanner(System.in);
        int userDel = userInDelete.nextInt();
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
