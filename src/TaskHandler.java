
public interface TaskHandler {

     boolean addTask();
     boolean deleteTaskByNum();
     void deleteAllTask();
     void markAsComplete();
     Task getAllTasksByName(String nameForFind);
}
