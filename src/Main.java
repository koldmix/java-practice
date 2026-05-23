import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        showMenu();

        Scanner menu = new Scanner(System.in);
        int userInMenu = menu.nextInt();
        if (userInMenu != 0){
            switch (userInMenu){
                case 1 -> {
                    addTask();
                }
                case 2 -> {
                    String[] arrTasks = addTask();
                    showTasks(arrTasks);
                }
            }
        }
    }
    public static String[] addTask(){
        System.out.println("Введите описание задачи: ");
        Scanner userInTask = new Scanner(System.in);
        String userTask = userInTask.nextLine();
        String[] arrTasks = {};
        String[] newArr = Arrays.copyOf(arrTasks, arrTasks.length + 1);
        newArr[arrTasks.length] = userTask;
        System.out.println("Задача добавлена!");

        return newArr;
    }

    public static void showTasks(String[] tasks){
        System.out.println("Список задач:");
        for (String task : tasks) {
            System.out.println(task);
        }

    }

    public static void showMenu(){
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
