package cafe.pja.signcafe.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cafe.pja.signcafe.data.DataSourceConfig;
import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.domain.OrderedList;
import cafe.pja.signcafe.service.MenuServiceImpl;

@Controller("controller.checkUserController")
public class CheckUserController {
	
	
	/*
	 * ———————————————————
	 * checkUser
	 * ———————————————————
	 */
	@PostMapping("menuService/checkUser")
	public ModelAndView checkUser(HttpServletRequest request) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		MenuServiceImpl menuService = (MenuServiceImpl) context.getBean("menuServiceImpl");
		HttpSession session = request.getSession();
		List<OrderedList> orderList = new ArrayList<>();
		ModelAndView mav = new ModelAndView();
		// 총 상품의 개수를 받아온다.
		int totalNum = Integer.parseInt(request.getParameter("totalNum"));
		for (int i = 1; i <= totalNum; i++) {
			MenuInfo m = new MenuInfo();
			OrderedList o = new OrderedList();
			
			m.setMenuNum(menuService.findMenuNum(request.getParameter("name" + i)));
			m.setMenuName(request.getParameter("name" + i));
			m.setCategory(menuService.findCategory(request.getParameter("name" + i)));
			
			System.out.println(menuService.findCategory(request.getParameter("name" + i)));
			
			o.setMenuInfo(m);
			o.setExtraTemp_Price(Double.parseDouble(request.getParameter("temp" + i)));
			o.setExtraSize_Price(Double.parseDouble(request.getParameter("size" + i)));
			o.setTotalPrice(Double.parseDouble(request.getParameter("price" + i)));

			orderList.add(o);
		}

		// 현재 장바구니 리스트를 세션으로 넘김
		if (totalNum == 0) {
			List<MenuInfo> menuInfoList = menuService.allMenu();
			mav.addObject("menuInfoList", menuInfoList);
			mav.addObject("errorMsg", "메뉴를 선택하세요");
			mav.setViewName("menuService/menu_Page");
		} else {
			session.setMaxInactiveInterval(30*60);
			session.setAttribute("cart", orderList);
			session.setAttribute("totalNum", totalNum);
			mav.setViewName("menuService/check_user");
		}
		
		return mav;
		
		
	}
	
	

}
