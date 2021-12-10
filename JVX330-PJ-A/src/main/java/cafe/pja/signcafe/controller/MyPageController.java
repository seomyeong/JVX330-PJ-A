package cafe.pja.signcafe.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@Controller("controller.myPageController")
public class MyPageController {
	@GetMapping("myPageService/myPage") // jsp주소에 들어가면 바로 일어나는 일. input 버튼 누르면 서블릿 넘어가기 전에
	public String myPageForm(HttpServletResponse response) {
		// 기존에 'connectUserPhone'의 이름을 가지는 쿠키의 값을 null로 만든다.
		Cookie cookie = new Cookie("connectUserPhone", null);

		// 쿠키의 유효기간을 0으로 설정한다.
		cookie.setMaxAge(0);

		// 적용시켜 해당 쿠키를 없앤다.
		response.addCookie(cookie);

		return "myPageService/myPage";
	}

	@PostMapping("myPageService/myPage")
	public ModelAndView myPage(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		UserServiceImpl service = (UserServiceImpl) context.getBean("userServiceImpl");
		ModelAndView mav = new ModelAndView();

		// 쿠키정보를 들고온다.
		Cookie[] getCookies = request.getCookies();
		String connectUserPhone = null;

		// 쿠키들 중에서 connectUserPhone이라는 이름의 쿠키를 찾는다.
		for (Cookie c : getCookies) {
			if (c.getName().equals("connectUserPhone")) {
				// 그것을 찾으면 해당 value 값을 connectUserPhone 변수에 넣어준다.
				connectUserPhone = c.getValue();
			}
		}

		// service에 connectUserPhone 의 정보를 넘겨준다.
		if (!(service.updateUserInfo(user, connectUserPhone))) {
			mav.addObject("errormsg", "해당 전화번호로 가입된 아이디가 있습니다.");
			mav.setViewName("myPageService/myPage");
			
			context.close();

			return mav;
		}

		// 기존에 'connectUserPhone'의 이름을 가지는 쿠키의 값을 null로 만든다.
		Cookie cookie = new Cookie("connectUserPhone", null);

		// 쿠키의 유효기간을 0으로 설정한다.
		cookie.setMaxAge(0);

		// 적용시켜 해당 쿠키를 없앤다.
		response.addCookie(cookie);

		mav.setViewName("myPageService/successModifyMyPage");
		
		context.close();

		return mav;
	}

}
