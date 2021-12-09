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
import cafe.pja.signcafe.service.AdminServiceImpl;

@Controller("controller.adminController")
public class AdminController {
	@GetMapping("adminService/adminLogin")
	public String adminLogin() {
		return "adminService/admin_login";
	}
	
	@PostMapping("adminService/adminLogin")
	public ModelAndView adminLogin(@ModelAttribute User user) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AdminServiceImpl service = (AdminServiceImpl)context.getBean("adminServiceImpl");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminService/admin_login");
		
		if(service.adminLogin(user)) {
			System.out.println("로그인성공");
			context.close();
			return mav;
		}
		
		System.out.println("로그인실패");
		
		context.close();
		return mav;
	}
}
