package cafe.pja.signcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("controller.myPageController")
public class MyPageController {
	@GetMapping("myPageService/myPage")
	public String myPageForm() {
		return "myPageService/myPage";
	}
	@PostMapping("myPageService.myPage")
	public String myPage(@ModelAttribute UserCommand user) {
		return "myPageService/myPage";
}
	
}
                                                                                                                                                                                                                                                