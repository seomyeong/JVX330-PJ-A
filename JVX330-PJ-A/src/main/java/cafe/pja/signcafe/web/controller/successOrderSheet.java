package cafe.pja.signcafe.web.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cafe.pja.signcafe.data.DataSourceConfig;
import cafe.pja.signcafe.service.MenuServiceImpl;

public class successOrderSheet {
	
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
