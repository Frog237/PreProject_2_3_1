package web.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String home(ModelMap model) {
		return "redirect:/users";
	}

	@GetMapping(value = "/users")
	public String usersList(ModelMap model) {
		System.out.println("Controller /users called");
		List<User> users = userService.findAll();
		System.out.println("Users retrieved: " + users);
		model.addAttribute("users", users);
		return "users";
	}

	@PostMapping(value = "/users/add")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("lastName") String lastName,
			@RequestParam("age") byte age) {
		userService.add(new User(name, lastName, age));
		return "redirect:/users";
	}

	@PostMapping(value = "/users/delete")
	public String deleteUser(
			@RequestParam("id") Long id) {
		userService.delete(id);
		return "redirect:/users";
	}

	@GetMapping(value = "/users/edit")
	public String editUserForm(@RequestParam("id") Long id, ModelMap model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "user-editor";
	}

	@PostMapping(value = "/users/update")
	public String updateUser(
			@RequestParam("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("lastName") String lastName,
			@RequestParam("age") byte age) {
		User updatedUser = new User();
		updatedUser.setId(id);
		updatedUser.setName(name);
		updatedUser.setLastName(lastName);
		updatedUser.setAge(age);

		userService.update(updatedUser);
		return "redirect:/users";
	}

}