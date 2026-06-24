public enum Status {
    COMPLETED(1),
    NOT_COMPLETED(2);

    private final int index;

    Status(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static Status getFromInt(int index){
        Status status = null;
        for (Status status1 : Status.values()) {
            if (status1.getIndex() == index){
                status = status1;
            }
        }
        return status;
    }
}
