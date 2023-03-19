import Notebook.RepeatTask;
import Notebook.Task;
import Notebook.TaskHashMap;
import Notebook.TypeTask;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Notebook.TypeTask.PERSONAL;
import static Notebook.TypeTask.WORK;

public class Main {
   private static TaskHashMap taskHashMap = new TaskHashMap();
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            removeTask(scanner);
                            break;
                        case 3:
                            checkTaskDate(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String nameTask = scanner.useDelimiter("\n").next();
        System.out.print("Введите описание задачи: ");
        String descriptionTask = scanner.useDelimiter("\n").next();
        System.out.print("Выберите тип задачи: 1 - личная, 2- рабочая ");
        int t = scanner.nextInt();
        TypeTask typeTask = null;
        if (t == 1) {
            typeTask = PERSONAL;
        } else if (t == 2) {
            typeTask = WORK;
        }else System.out.println("Нет такого типа задачи");
        System.out.println("Введите дату yyyy-MM-dd;HH:mm :");
        String date = scanner.next();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd;HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(date,format);
        System.out.println("Введите повторяемость задачи: \n 1-выполнить один раз \n 2- повторять каждый день  \n 3- повторить каждую неделю" +
                "\n 4- повторять каждый месяц \n 5- повторять каждый год ");
        int r = scanner.nextInt();
        RepeatTask repeatTask = null;
        switch (r) {
            case 1:
                repeatTask = RepeatTask.ONE_TIME;
                break;
            case 2:
                repeatTask = RepeatTask.EVERY_DAY;
                break;
            case 3:
                repeatTask = RepeatTask.WEEKLY;
                break;
            case 4:
                repeatTask = RepeatTask.MONTLY;
                break;
            case 5:
                repeatTask = RepeatTask.YEARLY;
                break;
        }
        Task task = new Task(nameTask, descriptionTask, typeTask, localDateTime, repeatTask);
        taskHashMap.addTask(task);
        System.out.println("taskHashMap.toString() = " + taskHashMap.toString());
    }
    private static void removeTask(Scanner scanner) {
        System.out.println("Введите id задачи которую необходимо удалить ");
        int id = scanner.nextInt();
        taskHashMap.deleteTask(id);
    }

    private static void checkTaskDate(Scanner scanner) {
        System.out.println("Введите дату в формате yyyy-MM-dd что бы получить задачи");
        LocalDate dateTask = LocalDate.parse(scanner.next());
        taskHashMap.checkTackFoDay(dateTask);

    }
    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу " +
                "2. Удалить задачу " +
                "3. Получить задачу на указанный день " +
                "0. Выход "
        );
    }
}