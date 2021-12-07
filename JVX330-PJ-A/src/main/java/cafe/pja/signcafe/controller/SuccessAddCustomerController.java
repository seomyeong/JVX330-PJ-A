package cafe.pja.signcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/addUserService/successCustomer")
public class SuccessAddCustomerController {
	@RequestMapping(method = RequestMethod.GET)
	public String AddCustomer() {
		return "addUserService/success_add_customer";
	}
}