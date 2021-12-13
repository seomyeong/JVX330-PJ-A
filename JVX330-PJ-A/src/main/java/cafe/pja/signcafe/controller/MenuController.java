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
		//카트 내용 쿠키로 보내기
		ModelAndView mav = new ModelAndView();
		mav.addObject("ordered", ordered);
		System.out.println(mav);
		//mav.setViewName("example4/checkUser");
		
		return mav;
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
