package com.todo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	public String fetchAddTodoPage() {
		return "todo";
	}

	@RequestMapping(value = "todo", method = RequestMethod.POST)
	public String addTodoPage(@RequestParam String description, ModelMap model) {
		String username = (String) model.get("name");
		String emptyDescriptionFieldMessage = "Please enter the description";
		if (description != "") {
			todoService.addNewTodo(username, description, LocalDate.now(), false);
			return "redirect:todos ";
		}
		model.put("emptyDescriptionFieldMessage", emptyDescriptionFieldMessage);
		return "todo";
	}
}
