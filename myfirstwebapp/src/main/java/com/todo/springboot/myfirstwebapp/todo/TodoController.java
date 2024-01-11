package com.todo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("todos")
	public String fetchTodoPage(ModelMap model) {
		List<Todo> matchingTodos = todoService.findTodosByUsername("oybek");
		model.addAttribute("todos", matchingTodos);
		return "todos";
	}

	@RequestMapping(value = "todo", method = RequestMethod.GET)
	public String fetchAddTodoPage(ModelMap model) {
		String username = (String) model.get("name");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "todo", method = RequestMethod.POST)
	public String addTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo";
		String username = (String) model.get("name");
		todoService.addNewTodo(username, todo.getDescription(), LocalDate.now(), false);
		return "redirect:todos ";
	}

	@RequestMapping(value = "delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String fetchUpdateTodoPage(ModelMap model, @RequestParam int id) {
		Todo matchingTodo = todoService.findById(id);
		model.addAttribute("todo", matchingTodo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors())
			return "todo";
		String username = (String) model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:todos";
	}
}
