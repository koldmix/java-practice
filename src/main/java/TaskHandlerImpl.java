import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskHandlerImpl implements TaskHandler {

    private List<Task> taskList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy");
    private int countTask = 1;

    @Override
    public void addTask() {
        Task task = new Task();

        ConsoleParser.readPriorityFromConcole(TaskPrinter.PRIORITY_MENU_TEXT, task::setPriority);
        ConsoleParser.readDateFromConcole(dtf, task::setDeadLine);
        ConsoleParser.readFromConsole("описание задачи: ", task::setDescription);
        ConsoleParser.readFromConsole("название задачи: ", task::setName);

        task.setId(countTask);

        taskList.add(task);
        System.out.println("Задача добавлена!");
        countTask++;
    }

    @Override
    public void deleteTaskByNum() {
        try {
            taskList.remove(ConsoleParser.readDeleteNumFromConsole() - 1);
            countTask--;
            System.out.println("Задача успешно удалена!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: Задачи с таким номером не существует!");
        }
    }

    @Override
    public void deleteAllTask() {
        taskList.clear();
    }

    @Override
    public void markAsComplete() {
        boolean mark = true;
        do {
            try {
                System.out.println("Введите номер задачи: ");
                int uI = Integer.parseInt(scanner.nextLine());
                taskList.get(uI - 1).setStatus(Status.COMPLETED);
                mark = false;
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }
        } while (mark);
    }

    @Override
    public void getAllTasksByName(String nameForFind) {
        taskList.stream()
                .filter(t -> t.getName().equals(nameForFind))
                .forEach(System.out::println);
    }

    public void getAllTasks() {
        if (countTask > 1) {
            taskList.stream()
                    .map(task -> taskList.indexOf(task) + 1 + "." + task)
                    .forEach(System.out::println);
        } else
            System.out.println("Список задач пуст!");
    }
}
