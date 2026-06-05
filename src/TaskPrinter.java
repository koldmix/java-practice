
public final class TaskPrinter {

    private TaskHandlerImpl taskHandler;

    public TaskPrinter(TaskHandlerImpl taskHandler) {
        this.taskHandler = taskHandler;
    }

    private TaskPrinter() {
        throw new UnsupportedOperationException();
    }

    public void showTasks(){
        System.out.println(taskHandler);
    }

    public static void showMenu(){
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
