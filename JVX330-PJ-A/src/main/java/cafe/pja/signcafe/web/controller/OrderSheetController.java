package cafe.pja.signcafe.web.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cafe.pja.signcafe.data.DataSourceConfig;
import cafe.pja.signcafe.service.PaymentServiceImpl;
import cafe.pja.signcafe.web.command.PaymentCommand;

/*
 * ——————————————————— 
 * payment.jsp 페이지 버튼
 * ———————————————————
 */

@Controller("controller.orderSheetController")
public class OrderSheetController {
	
	@GetMapping("menuService/payment")
	public String paymentForm() {
		
		mav("");
		
		return "menuService/payment";
	}
	
	@PostMapping("menuService/payment")
	public ModelAndView payment(@ModelAttribute PaymentCommand paymentCommand) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		PaymentServiceImpl service = (PaymentServiceImpl) context.getBean("paymentImpl");
		
		ModelAndView mav = new ModelAndView();
		
		
		return mav;
		
	}

	
	

	


}
