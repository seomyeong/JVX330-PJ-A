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
import cafe.pja.signcafe.service.command.Info;

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
		
		// 접속 성공시 
		if(service.adminLogin(user)) {
			Info info = service.allInquiryInfo();
			mav.addObject("info", info);
			mav.setViewName("adminService/signCafe_INFO");			
			context.close();
			return mav;
		}
		
		mav.addObject("errorMsg", "관리자 정보와 일치하지 않습니다.");
		mav.setViewName("adminService/admin_login");
		context.close();
		return mav;
	}
}
