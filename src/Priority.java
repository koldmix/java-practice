public enum Priority {
    IMPORTANT(1),
    NOT_IMPORTANT(2),
    STANDARD(3);

    private final int priority;

    Priority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static Priority fromInt(int value) {
        Priority priority1 = null;

        for (Priority priority : Priority.values()) {
            if (priority.getPriority() == value) {
                priority1 = priority;
            }
        }
        return priority1;
    }
}
