package cafe.pja.signcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/myPageService/myPageLogin")
public class MyPageLoginController {
	@RequestMapping(method = RequestMethod.GET)
	public String myPageLogin() {
		return "myPageService/myPageLogin";
	}
}
