package cafe.pja.signcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("controller.AddUserController")
public class AddUserController {
	@GetMapping("addUserService/addUser")
	public String addUserForm() {
		return "addUserService/add_user";
	}
	@PostMapping("addUserService/addUser")
	public String addUser(@ModelAttribute UserCommand user) {
		return "addUserService/add_user";
	}
}
