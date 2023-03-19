package Notebook;

public enum TypeTask {
    PERSONAL("Личная задача"),
    WORK("Рабочая задача");
    private String typeTask;

    TypeTask(String typeTask) {
        this.typeTask = typeTask;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(String typeTask) {
        this.typeTask = typeTask;
    }

    @Override
    public String toString() {
        return typeTask;
    }
}
