import java.util.Objects;

public class Task {
    private Priority priority;
    private String deadLine;
    private String description;
    private String name;
    private int id;
    private Status status = Status.NOT_COMPLETED;

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = Status.COMPLETED;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Task task)) return false;
        return id == task.id && priority == task.priority && Objects.equals(deadLine, task.deadLine) && Objects.equals(description, task.description) && Objects.equals(name, task.name) && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority, deadLine, description, name, id, status);
    }

    @Override
    public String toString() {
        String statusTask = status == Status.NOT_COMPLETED ? "[ ]" : "[X]";
        return statusTask + " Приоритет: " + priority +
                ", Дедлайн: '" + deadLine + '\'' +
                ", Описание: '" + description + '\'' +
                ", Название: '" + name + '\'' +
                ", id: " + id;

    }
}
