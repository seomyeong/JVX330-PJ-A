package cafe.pja.signcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.pja.signcafe.domain.User;

@Controller("controller.myPageController")
public class MyPageController {
	@GetMapping("myPageService/myPage") // jsp주소에 들어가면 바로 일어나는 일. input 버튼 누르면 서블릿 넘어가기 전에
	public String myPageForm() {
		return "myPageService/myPage";
	}
	@PostMapping("myPageService.myPage")
	public String myPage(@ModelAttribute User user) {
		return "myPageService/myPage";
}
	
}
                                                                                                                                                                                                                                          