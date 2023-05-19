package ru.netology.homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TasksTest {

    @Test
    public void shouldSayTrueIfMatchInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        assertTrue(simpleTask.matches("родителям"));
    }

    @Test
    public void shouldSayFalseIfNotMatchInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(7,"Позвонить родителям");

        assertFalse(simpleTask.matches("молоко"));
    }

    @Test
    public void shouldSayTrueIfMatchInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(78, subtasks);

        assertTrue(epic.matches("Яйца"));
    }

    @Test
    public void shouldSayFalseIfNotMatchInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(78, subtasks);

        assertFalse(epic.matches("Картошка"));
    }

    @Test
    public void shouldSayTrueIfMatchInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        assertTrue(meeting.matches("Выкатка"));
    }

    @Test
    public void shouldSayFalseIfNotMatchInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        assertFalse(meeting.matches("Привет"));
    }
}
