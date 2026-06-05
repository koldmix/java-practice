import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskHandlerImpl implements TaskHandler{

    private List<Task> taskList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

//    public TaskHandlerImpl(List<Task> taskList) {
//        this.taskList = taskList;
//    }

    @Override
    public boolean addTask() {
        Task task = new Task();
        System.out.println("Введите приоритет: " +
                "1 - IMPORTANT" +
                "2 - NOT_IMPORTANT" +
                "3 - STANDARD");
        int uI = Integer.parseInt(scanner.nextLine());
        switch (uI){
            case 1 -> task.setPriorityTask(Priority.IMPORTANT);
            case 2 -> task.setPriorityTask(Priority.NOT_IMPORTANT);
            case 3 -> task.setPriorityTask(Priority.STANDARD);
        }

        System.out.println("Введите дедлайн: ");
        String deadLine = scanner.nextLine();
        task.setDeadLineTask(deadLine);

        System.out.println("Введите Описание : ");
        String description = scanner.nextLine();
        task.setDescriptionTask(description);

        System.out.println("Введите название задачи : ");
        String nameOfTask = scanner.nextLine();
        task.setNameTask(nameOfTask);

        System.out.println("Введите номер id задачи : ");
        int idTask = Integer.parseInt(scanner.nextLine());
        task.setIdTask(idTask);
        if (taskList.add(task))
            return true;
        return false;
    }

    @Override
    public boolean deleteTaskByNum() {
        System.out.println("Введите номер задачи: ");
        int uI = Integer.parseInt(scanner.nextLine());
        if (taskList.remove(taskList.get(uI)))
            return true;
        return false;
    }

    @Override
    public void deleteAllTask() {
        taskList.clear();
    }

    @Override
    public void markAsComplete() {
        System.out.println("Введите номер задачи: ");
        int uI = Integer.parseInt(scanner.nextLine());
        taskList.get(uI).setStatusTask(Status.COMPLETED);
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

    @Override
    public String toString() {
        return "taskList = " + taskList;
    }
}
