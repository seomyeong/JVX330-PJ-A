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

@Controller("controller.paymentController")
public class PaymentController {
	
	@GetMapping("menuService/payment")
	public String paymentForm() {
		return "menuService/payment";
	}
	
	@PostMapping("menuService/payment")
	public ModelAndView payment(@ModelAttribute PaymentCommand paymentCommand) {
		GenericApplicationContext context = AnnotationConfigApplicationContext(DataSourceConfig.class);
		PaymentServiceImpl service = (PaymentServiceImpl) context.getBean("paymentImpl");
		
		
		return null;
	}

}
