import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskHandlerImpl implements TaskHandler{

    private List<Task> taskList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy");
    private int countTask = 1;

    @Override
    public void addTask() {
        boolean dedline = true;
        boolean priority = true;
        Task task = new Task();
        do {
            System.out.println("Введите приоритет: " +
                    " 1 - IMPORTANT," +
                    " 2 - NOT_IMPORTANT," +
                    " 3 - STANDARD.");
            try {
                int uI = Integer.parseInt(scanner.nextLine());
                if (uI < 1 || uI > 3){
                    System.out.println("Введите число от 1 до 3");
                }else {
                    switch (uI){
                        case 1 -> task.setPriorityTask(Priority.IMPORTANT);
                        case 2 -> task.setPriorityTask(Priority.NOT_IMPORTANT);
                        case 3 -> task.setPriorityTask(Priority.STANDARD);
                    }
                    priority = false;
                }
            }catch (NumberFormatException e){
                System.out.println("Введите число");
            }
        }while (priority);

        do {
            System.out.println("Введите дедлайн в формате dd.MM.yy: ");
            String date = scanner.nextLine();
            try {
                LocalDate localDate = LocalDate.parse(date, dtf);
                String deadLine = localDate.format(dtf);
                task.setDeadLineTask(deadLine);
                dedline = false;
            } catch (DateTimeException e) {
                System.out.println("Введена неверная дата");
            }
        }while (dedline);

        System.out.println("Введите Описание : ");
        String description = scanner.nextLine();
        task.setDescriptionTask(description);

        System.out.println("Введите название задачи : ");
        String nameOfTask = scanner.nextLine();
        task.setNameTask(nameOfTask);

        task.setIdTask(countTask);

        taskList.add(task);
        System.out.println("Задача добавлена!");
        countTask++;
    }

    @Override
    public void deleteTaskByNum() {
        boolean delete = true;
        do {
            try {
                System.out.println("Введите номер задачи: ");
                int uI = Integer.parseInt(scanner.nextLine());
                taskList.remove(taskList.get(uI - 1));
                delete = false;
            }catch (NumberFormatException e){
                System.out.println("Введите число");
            }
        }while (delete);
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
                taskList.get(uI - 1).setStatusTask(Status.COMPLETED);
                mark = false;
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }
        }while (mark);
    }

    @Override
    public Task getAllTasksByName(String nameForFind) {
        Task findedTask = null;
        for (Task task : taskList) {
            if (task.getNameTask().equals(nameForFind))
                findedTask = task;
        }
        return findedTask;
    }

    public String getAllTasks(){
        if (countTask > 1){
            for (Task task1 : taskList) {
                System.out.println((taskList.indexOf(task1) + 1) + "." + task1);
            }
        }
        return "Список задач пуст!";
    }
}
