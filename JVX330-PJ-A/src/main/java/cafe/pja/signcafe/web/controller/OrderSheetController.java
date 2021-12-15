package cafe.pja.signcafe.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cafe.pja.signcafe.data.DataSourceConfig;
import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.domain.OrderedList;
import cafe.pja.signcafe.domain.PaymentHistory;
import cafe.pja.signcafe.service.MenuServiceImpl;
import cafe.pja.signcafe.service.OrderedListServiceImpl;
import cafe.pja.signcafe.service.PaymentServiceImpl;
import cafe.pja.signcafe.web.command.PaymentCommand;

@Controller("controller.orderSheetController")
public class OrderSheetController {

	/*
	 * ——————————————————— 
	 * payment.jsp 페이지 버튼
	 * ———————————————————
	 */
	@GetMapping("menuService/orderSheet")
	public String orderSheetForm() {
		return "menuService/menuPage";
	}

	@PostMapping("menuService/orderSheet")
	public ModelAndView orderSheet(@ModelAttribute PaymentCommand payment, HttpServletRequest request) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		MenuServiceImpl menuService = (MenuServiceImpl) context.getBean("menuServiceImpl");
		OrderedListServiceImpl orderedListService = (OrderedListServiceImpl) context.getBean("orderedListServiceImpl");
		PaymentServiceImpl paymentService = (PaymentServiceImpl) context.getBean("paymentServiceImpl");
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		int totalNum = (int)session.getAttribute("totalNum");
		List<OrderedList> cart = (List<OrderedList>)session.getAttribute("cart");
		List<OrderedList> orderedList = new ArrayList<>();
		Cookie[] cookies = request.getCookies();
		String userPhone = null;
		double totalPrice = 0;
		
		PaymentHistory paymentHistory = new PaymentHistory();
		
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("cookieUserPhone")) {
				userPhone = cookie.getValue();
			}
		}
		
		// PAYMENT_HISTORY 테이블에 payment에서 요소 뽑아와서 넣기
		paymentHistory.setPayment_customerInfo(userPhone);
		paymentHistory.setCreditCard(payment.getCreditCard());
		paymentHistory.setCreditCardNum(payment.getCardNum());
		paymentHistory.setOrderPrice(payment.getOrderPrice());
		
		paymentService.payByCreditCard(paymentHistory);
		
		for(OrderedList c : cart) {
			OrderedList o = new OrderedList();
			MenuInfo m = new MenuInfo();
			
			m.setMenuName(c.getMenuInfo().getMenuName());
			m.setMenuNum(c.getMenuInfo().getMenuNum());
			
			o.setCustomerInfo(userPhone);
			o.setMenuInfo(m);
			o.setExtraSize_Price(c.getExtraSize_Price());
			o.setExtraTemp_Price(c.getExtraTemp_Price());
			o.setMenuCount(1); // 수량 1개로 고정
			o.setUsingMileage(payment.getAmount() / totalNum);
			o.setTotalPrice(c.getTotalPrice());
			
			
			// MENU_INFO 테이블에 menuCount, mileageCount 정산
			menuService.updateMenuInfoCount(m.getMenuName(), 1, payment.getAmount() / totalNum);
			
			totalPrice += c.getTotalPrice();
			orderedList.add(o);
		}
		
		// orderedList를 db안에 넣기
		orderedListService.order(orderedList);
		
		
		
		//////////
		// CAFE_USER 테이블에 mileage 정산
		// 마일리지 부족하면 안되게하기
		//////////
		
		// 영수증 출력
		mav.addObject("payment", payment);
		mav.addObject("totalPrice", totalPrice);
		mav.addObject("cart", cart);
		mav.setViewName("menuService/orderSheet");
		
		
		// + 예외
		// 		-. 마일리지 초과시 에러
		context.close();
		return mav;
	}

}