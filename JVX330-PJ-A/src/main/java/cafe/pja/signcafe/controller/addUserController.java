package cafe.pja.signcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/addUserService/addUser")
public class addUserController {
	@RequestMapping(method = RequestMethod.GET)
	public String addUser() {
		return "addUserService/add_user";
		
	}
}
