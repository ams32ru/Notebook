package Notebook;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements NextDate {
    private  String nameTask;
    private  String descriptionTask;
    private final RepeatTask repeatTask;
    private final TypeTask typeTask;

    private final LocalDateTime dateTime;
    private final int id;
    private static int idCounter = 1;

    public  Task(String nameTask, String descriptionTask,TypeTask typeTas, LocalDateTime localDateTime, RepeatTask repeatTask) {
        this.setNameTask(nameTask);
        this.setDescriptionTask(descriptionTask);
        this.typeTask = typeTas;
        this.dateTime = localDateTime;
        this.repeatTask = repeatTask;

        this.id  =idCounter++;
    }

    public String getNameTask() {
        return nameTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public RepeatTask getRepeatTask() {
        return repeatTask;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Integer getId() {
        return id;
    }

    public static int getIdCounter() {
        return idCounter;
    }


    public void setNameTask(String nameTask) {
        try {
            if (nameTask == null || nameTask.isBlank()) {
                throw new NotebookException(" Не введено название задачи");
            }
        } catch (NotebookException e) {
            System.out.println(e.getMessage());
        }
        this.nameTask = nameTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        try {
            if (descriptionTask == null || descriptionTask.isBlank()) {
                throw new NotebookException(" Не введено описание задачи");
            }
        } catch (NotebookException e) {
            System.out.println(e.getMessage());
        }
        this.descriptionTask = descriptionTask;
    }

    @Override
    public void nextDate(LocalDate date) {
        switch (repeatTask) {
            case ONE_TIME:{
                System.out.println("Задача без повторения ");}
            break;
            case EVERY_DAY:{
                System.out.println("Задача повторится завтра: " + dateTime.plusDays(1));
            }
            break;
            case WEEKLY:{
                System.out.println("Задача повторится через неделю: " + dateTime.plusWeeks(1));
            }
            break;
            case MONTLY:{
                System.out.println("Задача повторится через месяц: " + dateTime.plusMonths(1));
            }
            break;
            case YEARLY:{
                System.out.println("Задача повторится через год: " + dateTime.plusYears(1));
            }
        }
    }

    @Override
    public String toString() {
        return"\n"+ "Название задачи='" + nameTask + '\'' +
                ", Описание='" + descriptionTask + '\'' +
                ", задача повторяется: " + repeatTask +
                ", тип задачи: " + typeTask +
                ", дата и время: " + dateTime +
                ", id=" + id ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(nameTask, task.nameTask) && Objects.equals(descriptionTask, task.descriptionTask) && repeatTask == task.repeatTask && typeTask == task.typeTask && Objects.equals(dateTime, task.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameTask, descriptionTask, repeatTask, typeTask, dateTime, id);
    }
}
