package cafe.pja.signcafe.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cafe.pja.signcafe.data.DataSourceConfig;
import cafe.pja.signcafe.domain.User;
import cafe.pja.signcafe.service.UserServiceImpl;

@Controller("controller.myPageLoginController")
public class MyPageLoginController {
	
	@GetMapping("myPageService/myPageLogin")
	public String myPageLoginForm() {
		return "myPageService/myPageLogin";
	}
	
	@PostMapping("myPageService/myPageLogin")
	public ModelAndView myPageLogin(@ModelAttribute User user) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		UserServiceImpl service = (UserServiceImpl) context.getBean("userServiceImpl");
		
		ModelAndView mav = new ModelAndView();
		
		if(service.myPageLogin(user)) { // 로그인에 성공한 경우, 마이페이지로 이동
			context.close();	
			mav.setViewName("/myPageService/myPage");
			System.out.println("성공!");
			return mav;
		} 

			context.close();
			mav.addObject("errormsg", "입력하신 정보와 일치하는 회원정보가 없습니다.");
			mav.setViewName("/myPageService/myPageLogin");
			return mav;
	}
}
