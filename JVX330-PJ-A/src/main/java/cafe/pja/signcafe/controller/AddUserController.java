package cafe.pja.signcafe.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.pja.signcafe.data.DataSourceConfig;
import cafe.pja.signcafe.domain.User;
import cafe.pja.signcafe.service.UserServiceImpl;

@Controller("controller.AddUserController")
public class AddUserController {
	@GetMapping("addUserService/addUser")
	public String addUserForm() {
		return "addUserService/add_user";
	}

	@PostMapping("addUserService/addUser")
	public String addUser(@ModelAttribute User user) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		UserServiceImpl service = (UserServiceImpl) context.getBean("userServiceImpl");

		System.out.println(user.getName());

		service.addUser(user);
		context.close();

		return "addUserService/add_user";
	}
}
