package com.todo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

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

	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);

//		List<Todo> updatedTodos = (List<Todo>) todos.stream().filter(todoEl -> todoEl.getId() != id)
//				.collect(Collectors.toList());
//		todos.clear();
//		todos.addAll(updatedTodos);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo matchingTodo = todos.stream().filter(predicate).findFirst().get();
		return matchingTodo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
