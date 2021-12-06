package cafe.pja.signcafe.domain;

import java.util.List;

public class Cart {
	private long cartNum; // PK
	private String category;
	private String menuName;
	private double menuPrice;
	private long count;
	private char size; // S, M, L
	private char temp; // HOT or ICE
	
	
	public Cart(String category, String menuName, double menuPrice, long count, char size, char temp) {
		this.category = category;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.count = count;
		this.size = size;
		this.temp = temp;
	}
	
	
	
	
	//  private List<Menu> menuList;
	//	private String cart_menuName;
	//	private double cart_menuPrice;
	//	private String cart_size;
	//	private double cart_temp;
	
	
	
	
	
	
}
