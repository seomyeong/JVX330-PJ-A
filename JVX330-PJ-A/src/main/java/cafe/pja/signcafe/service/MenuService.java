package cafe.pja.signcafe.service;

import java.util.List;

import cafe.pja.signcafe.domain.Cart;
import cafe.pja.signcafe.domain.User;

public interface MenuService {

	/*
	 *	1. menuPage
	 *		1-1. menuPage.jsp에서 checkBox 클릭한 품목 선택
	 *		1-2. 선택한 품목을 카트에 담기 (addCart)
	 */
	public void addCart(Cart cart);  
	
	
	/*
	 *  2. 회원여부확인
	 *  	2-1. 회원일 경우 DB값과 일치하면 결제이동 : UserService의 login서비스 재활용?
	 *  	2-2. 비회원일 경우 회원가입창 안내 + 바로결제 안내
	 *  	2-3. 취소버튼 누를 경우 트랜잭션
	 */
	public void checkUser(String phone); //UserService의 login서비스 재활용?
	
	public void payment();
	
	
	/*
	 *  3. 카트에 담긴 품목을 결제
	 *  	3-1. ORDER_LIST_userCartOrder_FK를 찾아올 메소드 필요
	 *  	3-2. 결제버튼 누를 경우 회원이면 적립 + CART테이블은 DELETE, ORDER_LIST 테이블은 INSERT ?
	 *  	3-3. 취소버튼 누를 경우 트랜잭션
	 */
	public void addMileage(User user);
	public List<Cart> addOrderList(Cart cart);
	public void deleteCart(Cart cart);
}
