package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping("/")
	//@RequestMapping(value = "", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		String messages = "Welcome dear customers !!!";
		model.addAttribute("messages", messages);
		return "homePage";
	}

	@GetMapping("/users")
	public String printUsers(Model model) {
		model.addAttribute("user", userService.listUsers());
		return "/users";
	}

	@GetMapping("/users/{id}")
	public String show(@PathVariable("id") long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "/user";
	}
}