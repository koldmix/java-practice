
public interface TaskHandler {

     void addTask();
     void deleteTaskByNum();
     void deleteAllTask();
     void markAsComplete();
     Task getAllTasksByName(String nameForFind);

}
