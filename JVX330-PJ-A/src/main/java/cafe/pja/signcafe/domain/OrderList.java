package cafe.pja.signcafe.domain;

public class OrderList {
	private long orderNum; // PK
	private long userCartOrder; // CART의 cartNum - FK
	private String order_category;
	private String order_menuName;
	private double order_menuPrice;
	private long order_menuCount;
	private char order_size; // S, M, L
	private char order_temp; // HOT or ICE
	private double order_totalPrice;

	
	
}
