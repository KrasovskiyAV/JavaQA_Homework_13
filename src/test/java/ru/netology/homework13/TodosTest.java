package ru.netology.homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям; купить Хлеб");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryIfMatchInSimpleTask() {

        todos.search("Позвонить");

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryIfMatchInEpic() {

        todos.search("Молоко");

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryIfMatchInMeeting() {

        todos.search("версии");

        Task[] expected = {meeting};
        Task[] actual = todos.search("версии");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchIfInvalidQuery() {

        todos.search("сметана");

        Task[] expected = {};
        Task[] actual = todos.search("сметана");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchIfNotOneMatches() {

        todos.search("Хлеб");

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Хлеб");

        assertArrayEquals(expected, actual);
    }
}
