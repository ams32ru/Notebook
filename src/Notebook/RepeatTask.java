package Notebook;

public enum RepeatTask {
    ONE_TIME("Один раз"),
    EVERY_DAY("Каждый день"),
    WEEKLY("Каждую неделю"),
    MONTLY("Каждый месяц"),
    YEARLY("Каждый год");

    private String nameRepeat;

    RepeatTask(String nameRepeat) {
        this.nameRepeat = nameRepeat;
    }

    public String getNameRepeat() {
        return nameRepeat;
    }

    @Override
    public String toString() {
        return " Эта задача выполняется " + nameRepeat;
    }




}
