package cafe.pja.signcafe.controller;

import java.util.ArrayList;
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
import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.domain.OrderedList;
<<<<<<< HEAD

=======
>>>>>>> branch 'main' of https://github.com/seomyeong/JVX330-PJ-A.git
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

	
	
	/*
	 * ---------------------------------------
	 * checkUser
	 * ---------------------------------------
	 */
	@PostMapping("menuService/checkUser")
	public String checkUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<OrderedList> orderList = new ArrayList<>();
		// 총 상품의 개수를 받아온다.
		int totalNum = Integer.parseInt(request.getParameter("totalNum"));
		for (int i = 1; i <= totalNum; i++) {
			MenuInfo m = new MenuInfo();
			OrderedList o = new OrderedList();
			m.setMenuName(request.getParameter("name" + i));

			o.setMenuInfo(m);
			o.setExtraTemp_Price(Double.parseDouble(request.getParameter("temp" + i)));
			o.setExtraSize_Price(Double.parseDouble(request.getParameter("size" + i)));
			o.setTotalPrice(Double.parseDouble(request.getParameter("price" + i)));

			orderList.add(o);
		}

		// 현재 장바구니 리스트를 세션으로 넘김
		if (totalNum != 0) {
			session.setAttribute("cart", orderList);
			session.setAttribute("totalNum", totalNum);
			return "menuService/checkUser";
		} else {
			session.setAttribute("errorMsg", "메뉴를 선택하세요");
			return "menuService/menu_Page";
		}
	}
	
	@GetMapping("menuService/checkUser")
	public String checkUserForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<OrderedList> orderList = new ArrayList<>();
		// 총 상품의 개수를 받아온다.
		int totalNum = Integer.parseInt(request.getParameter("totalNum"));
		for (int i = 1; i <= totalNum; i++) {
			MenuInfo m = new MenuInfo();
			OrderedList o = new OrderedList();
			m.setMenuName(request.getParameter("name" + i));

			o.setMenuInfo(m);
			o.setExtraTemp_Price(Double.parseDouble(request.getParameter("temp" + i)));
			o.setExtraSize_Price(Double.parseDouble(request.getParameter("size" + i)));
			o.setTotalPrice(Double.parseDouble(request.getParameter("price" + i)));

			orderList.add(o);
		}

		// 현재 장바구니 리스트를 세션으로 넘김
//		if (totalNum != 0) {
			session.setAttribute("cart", orderList);
			session.setAttribute("totalNum", totalNum);
			return "menuService/checkUser";
//		} else {
//			session.setAttribute("errorMsg", "메뉴를 선택하세요");
//			return "menuService/menu_Page";
//		}
	}

	
	
	
	
	/*
	 * payment.jsp
	 */
	//chechUser.jsp에서 적립하지않고 바로결제 누를 경우 이동
	@GetMapping("menuService/payment")
	public String paymentForm() {
		return "menuService/payment";
	}

	//chechUser.jsp에서 결제버튼 클릭 시 폰번호 검사
	@PostMapping("menuService/payment")
	public ModelAndView paymentbySeoMyeong(@ModelAttribute User user, HttpServletResponse response) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
		ModelAndView mav = new ModelAndView();

		// 유저의 폰번호와 일치하지 않으면 error, 일치하면 payment 이동
		if (userService.checkUserbyPhone(user)) {
			User userInfo = userService.userInfoByPhone(user);

			Cookie cookie = new Cookie("cookieUserPhone", user.getPhone());
			cookie.setMaxAge(60 * 60 * 24);
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

	/*
	 * -------------------------------------- 
	 * payment.jsp 페이지 버튼
	 * --------------------------------------
	 */
	@GetMapping("menuService/orderSheet")
	public String orderSheetForm() {
		return "menuService/menuPage";
	}

	@PostMapping("menuService/orderSheet")
	public String orderSheet() {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		MenuServiceImpl menuService = (MenuServiceImpl) context.getBean("menuServiceImpl");

		ModelAndView mav = new ModelAndView();

		return "menuService/orderSheet";
	}

}
