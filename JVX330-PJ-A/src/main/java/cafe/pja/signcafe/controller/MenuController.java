package cafe.pja.signcafe.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cafe.pja.signcafe.data.DataSourceConfig;
import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.service.MenuServiceImpl;
import cafe.pja.signcafe.service.command.OrderedCommand;

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
	public ModelAndView checkUser(@ModelAttribute OrderedCommand ordered) {
		public String checkUser(HttpServletRequest request) {
			HttpSession session = request.getSession();
			List<OrderedList> orderList = new ArrayList<>();
			
			// 총 상품의 개수를 받아온다.
			int totalNum = Integer.parseInt(request.getParameter("totalNum"));
			
			for(int i = 1; i <= totalNum; i++) {
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
			session.setAttribute("cart", orderList);
			session.setAttribute("totalNum", totalNum);
			return "menuService/checkUser";
		}
	}
	
	
	@PostMapping("menuService/payment")
	public String payment() {
		return "menuService/payment";
	}
	
	
	@PostMapping("menuService/orderSheet")
	public String orderSheet() {
		return "menuService/orderSheet";
	}
	
}
