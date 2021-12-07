package cafe.pja.signcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/myPageService/myPage")
public class MyPageController {
	@RequestMapping(method = RequestMethod.GET)
	public String myPage() {
		return "myPageService/myPage";
	}
}
                                                                                                                                                                                                                                                