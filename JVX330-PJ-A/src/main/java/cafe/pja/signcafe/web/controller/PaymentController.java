package cafe.pja.signcafe.web.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cafe.pja.signcafe.data.DataSourceConfig;
import cafe.pja.signcafe.domain.OrderedList;
import cafe.pja.signcafe.domain.User;
import cafe.pja.signcafe.service.UserServiceImpl;

@Controller("controller.paymentController")
public class PaymentController {
	

	//chechUser.jsp에서 적립하지않고 바로결제 누를 경우 이동
	@GetMapping("menuService/payment")
	public ModelAndView paymentForm(HttpServletRequest request) {
		double orderPrice = this.orderPrice(request);
		ModelAndView mav = new ModelAndView();
		User user = new User();
		
		user.setMileage(0);
		
		mav.addObject("user", user);
		mav.addObject("orderPrice", orderPrice);
		mav.setViewName("menuService/payment");
		return mav;
	}

	//chechUser.jsp에서 결제버튼 클릭 시 폰번호 검사
	@PostMapping("menuService/payment")
	public ModelAndView paymentbySeoMyeong(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
		ModelAndView mav = new ModelAndView();
		
		double orderPrice = this.orderPrice(request);

		// 유저의 폰번호와 일치하지 않으면 error, 일치하면 payment 이동
		if (userService.checkUserbyPhone(user)) {
			User userInfo = userService.userInfoByPhone(user);

			Cookie cookie = new Cookie("cookieUserPhone", user.getPhone());
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
			
			mav.addObject("orderPrice", orderPrice);
			mav.addObject("user", userInfo);
			mav.setViewName("menuService/payment_Page");
			context.close();
			return mav;
		} else {
			mav.addObject("errorMsg", "입력하신 정보와 일치하는 회원정보가 없습니다.");
			mav.setViewName("menuService/checkUser");
			context.close();
			return mav;
		}
	}
	
	private double orderPrice(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<OrderedList> cart = (List<OrderedList>)session.getAttribute("cart");
		double total = 0;
		
		for(OrderedList o : cart) {
			total += o.getTotalPrice();
		}
		return total;
		
	}
	
	
}
