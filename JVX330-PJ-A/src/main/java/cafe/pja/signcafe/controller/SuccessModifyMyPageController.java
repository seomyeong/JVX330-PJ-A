package cafe.pja.signcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("controller.successModifyMyPageController")
public class SuccessModifyMyPageController {
	
	@GetMapping("myPageService/successModifyMyPage")
	public String successModifyMyPageForm() {
		return "myPageService/successModifyMyPage";
	}
	
	@PostMapping("myPageService/successModifyMyPage")
	public String successModifyMyPage(@ModelAttribute UserCommand user) {
		return "myPageService/successModifyMyPage";
	}
}
