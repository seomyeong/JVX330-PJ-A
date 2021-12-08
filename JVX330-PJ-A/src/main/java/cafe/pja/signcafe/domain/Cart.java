package cafe.pja.signcafe.domain;

import java.util.List;

public class Cart {
	private long cartNum; // PK
	private CartId cartId;
	private String cart_menuName;
	private double cart_menuPrice;
	private long cart_menuCount;
	private double cart_totalPrice;
	private Extra extra;
	
}
