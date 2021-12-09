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
import cafe.pja.signcafe.service.UserServiceImpl;

@Controller("controller.AddUserController")
public class AddUserController {
	@GetMapping("addUserService/addUser")
	public String addUserForm() {
		return "addUserService/add_user";
	}

	@PostMapping("addUserService/addUser")
	public ModelAndView addUser(@ModelAttribute User user) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		UserServiceImpl service = (UserServiceImpl) context.getBean("userServiceImpl");

		System.out.println("Input user Name : " + user.getName());
		System.out.println("Input user Phone : " + user.getPhone());
		System.out.println("Input user passWd : " + user.getPassWd());

		ModelAndView mav = new ModelAndView();

		if (service.addUser(user)) {
			context.close();
			mav.setViewName("/addUserService/successAddUser");
			return mav;
		}

		context.close();
		mav.addObject("errormsg", "해당 전화번호로 가입된 아이디가 있습니다.");
		mav.setViewName("/addUserService/add_user");
		return mav;
	}
}
