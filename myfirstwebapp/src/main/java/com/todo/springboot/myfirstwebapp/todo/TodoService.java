package com.todo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 0;
	static {
		todos.add(new Todo(++todoCount, "Oybek", "Learn Spring boot", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "Oybek", "Learn AWS", LocalDate.now().plusMonths(1), false));
		todos.add(new Todo(++todoCount, "Oybek", "Learn Data Science", LocalDate.now().plusYears(1), false));
	}

	public List<Todo> findTodosByUsername(String username) {
		return todos;
	}

	public void addNewTodo(String username, String description, LocalDate localDate, boolean isDone) {
		Todo todo = new Todo(++todoCount, username, description, localDate, isDone);
		todos.add(todo);
	}
}
