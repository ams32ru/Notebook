package Notebook;

import java.time.LocalDate;
import java.util.*;

public class TaskHashMap {
    private final Map<Integer, Task> map = new LinkedHashMap<>();

    public Map<Integer, Task> getMap() {
        return map;
    }

    public void addTask(Task task) {
        map.put(task.getId(), task);
    }

    public void deleteTask(Integer id) {
            map.remove(id);
    }

public void checkTackFoDay(LocalDate localDate) {
    for (Task value : map.values()) {
        if (value.getDateTime().toLocalDate().equals(localDate)) {
            System.out.println(value);
        }
    }
}

    @Override
    public String toString() {
        return "TaskHashMap{" +
                "notebook=" + map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskHashMap that = (TaskHashMap) o;
        return Objects.equals(map, that.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
