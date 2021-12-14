package cafe.pja.signcafe.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("controller.indexController")
public class IndexController {
	@GetMapping("Index")
	public String mainPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "../../index";
	}
}
