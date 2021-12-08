package cafe.pja.signcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/myPageService/successModifyMyPage")
public class SuccussModifyMyPageController {
	@RequestMapping(method = RequestMethod.GET)
	public String successModifyMyPage() {
		return "/myPageService/successModifyMyPage";
	}
}
