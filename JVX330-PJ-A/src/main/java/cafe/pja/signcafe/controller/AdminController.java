package cafe.pja.signcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("controller.adminController")
public class AdminController {
	@GetMapping("/adminService/adminLogin")
	public String adminLogin() {
		return "/adminService/admin_login";
	}
}
