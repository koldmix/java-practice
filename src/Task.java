import java.util.Objects;

public class Task {
    private Priority priorityTask;
    private String deadLineTask;
    private String descriptionTask;
    private String nameTask;
    private int idTask;
    private Status statusTask = Status.NOT_COMPLETED;

//    public Task(Priority priorityTask, String deadLineTask, String descriptionTask, String nameTask, int idTask) {
//        this.priorityTask = priorityTask;
//        this.deadLineTask = deadLineTask;
//        this.descriptionTask = descriptionTask;
//        this.nameTask = nameTask;
//        this.idTask = idTask;
//        this.statusTask = Status.NOT_COMPLETED;
//    }


    public void setPriorityTask(Priority priorityTask) {
        this.priorityTask = priorityTask;
    }

    public void setDeadLineTask(String deadLineTask) {
        this.deadLineTask = deadLineTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public void setStatusTask(Status statusTask) {
        this.statusTask = Status.COMPLETED;
    }

    public Priority getPriorityTask() {
        return priorityTask;
    }

    public String getDeadLineTask() {
        return deadLineTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public int getIdTask() {
        return idTask;
    }

    public Status getStatusTask() {
        return statusTask;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Task task)) return false;
        return idTask == task.idTask && priorityTask == task.priorityTask && Objects.equals(deadLineTask, task.deadLineTask) && Objects.equals(descriptionTask, task.descriptionTask) && Objects.equals(nameTask, task.nameTask) && statusTask == task.statusTask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priorityTask, deadLineTask, descriptionTask, nameTask, idTask, statusTask);
    }

    @Override
    public String toString() {
        return "Task{" +
                "priorityTask=" + priorityTask +
                ", deadLineTask='" + deadLineTask + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", nameTask='" + nameTask + '\'' +
                ", idTask=" + idTask +
                ", statusTask=" + statusTask +
                '}';
    }
}
