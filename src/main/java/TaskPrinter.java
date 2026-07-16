
public final class TaskPrinter {

    private TaskHandlerImpl taskHandlerImpl;

    public TaskPrinter(TaskHandlerImpl taskHandlerImpl) {
        this.taskHandlerImpl = taskHandlerImpl;
    }

    private TaskPrinter() {
        throw new UnsupportedOperationException();
    }

    public void showTasks() {
        taskHandlerImpl.getAllTasks();
    }

    public static final String PRIORITY_MENU_TEXT = """
            Введите приоритет:\s
            1 - IMPORTANT,
            2 - NOT_IMPORTANT,
            3 - STANDARD.""";

    public static void showMenu() {
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
