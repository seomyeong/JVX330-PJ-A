package cafe.pja.signcafe.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cafe.pja.signcafe.data.DataSourceConfig;
import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.domain.User;
import cafe.pja.signcafe.service.MenuServiceImpl;
import cafe.pja.signcafe.service.UserServiceImpl;

@Controller("controller.menuController")
public class MenuController {
	@GetMapping("menuService/menuPage")
	public ModelAndView menuPageGet() {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		MenuServiceImpl menuService = (MenuServiceImpl) context.getBean("menuServiceImpl");

		ModelAndView mav = new ModelAndView();

		List<MenuInfo> menuInfoList = menuService.allMenu();
		mav.addObject("menuInfoList", menuInfoList);

		mav.setViewName("menuService/menu_Page");

		context.close();
		return mav;
	}

	@PostMapping("menuService/menuPage")
	public ModelAndView menuPage() {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		MenuServiceImpl menuService = (MenuServiceImpl) context.getBean("menuServiceImpl");

		ModelAndView mav = new ModelAndView();

		List<MenuInfo> menuInfoList = menuService.allMenu();
		mav.addObject("menuInfoList", menuInfoList);

		mav.setViewName("menuService/menu_Page");

		context.close();
		return mav;
	}

	@PostMapping("menuService/checkUser")
	public String checkUser() {
		return "menuService/checkUser";
	}

	// chechUser.jsp에서 적립하지않고 바로결제 누를 경우 이동
	@GetMapping("menuService/payment")
	public String payment() {
		return "menuService/payment";
	}

	// chechUser.jsp에서 결제버튼 클릭 시 폰번호 검사
	@PostMapping("menuService/payment")
	public ModelAndView paymentbySeoMyeong(@ModelAttribute User user, HttpServletResponse response) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
		ModelAndView mav = new ModelAndView();

		// 유저의 폰번호와 일치하지 않으면 error, 일치하면 payment 이동
		if (userService.checkUserbyPhone(user)) {
			User userInfo = userService.userInfoByPhone(user);

			Cookie cookie = new Cookie("cookieUserPhone", user.getPhone());
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			
			mav.addObject("user", userInfo);
			mav.setViewName("menuService/payment");
			context.close();
			return mav;
		} else {
			mav.addObject("errorMsg", "입력하신 정보와 일치하는 회원정보가 없습니다.");
			mav.setViewName("menuService/checkUser");
			context.close();
			return mav;
		}
	}

	@PostMapping("menuService/orderSheet")
	public String orderSheet() {
		return "menuService/orderSheet";
	}

}
