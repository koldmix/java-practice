import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int userInpMenu;
        do {
            showMenu();
            Scanner scannerMenu = new Scanner(System.in);
            userInpMenu = scannerMenu.nextInt();
            if (userInpMenu != 0){
                switch (userInpMenu){
                    case 1 -> addTask();
                    case 2 -> showTasks();
                }
            }
        }while (userInpMenu != 0);
    }

    public static void addTask() {
        System.out.println("Введите описание задачи: ");
        Scanner userInTask = new Scanner(System.in);
        String userTask = userInTask.nextLine();

        String[] addTask = Arrays.copyOf(showTasks(), showTasks().length + 1);
        addTask[showTasks().length] = userTask;

        System.out.println("Задача добавлена!" + "\n");
    }

    public static String[] showTasks(String[] strTasks) {
        System.out.println("Список задач:");
        if (strTasks.length == 0){
            System.out.println("Задач нет" + "\n");
        }
        for (String arrTask : strTasks) {
            System.out.println(arrTask);
        }
        return strTasks;
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

//    public static String[] arr(){
//        String[] arr = {};
//        return arr;
//    }
}
