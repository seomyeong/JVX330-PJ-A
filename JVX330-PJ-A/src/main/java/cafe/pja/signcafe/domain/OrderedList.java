package cafe.pja.signcafe.domain;

import java.util.Date;

public class OrderedList {
	private long orderedList; // PK
	private String customerInfo;
	private MenuInfo menuInfo;
	private double extraSize_Price;
	private double extraTemp_Price;
	private int menuCount;
	private double usingMileage;
	private double totalPrice;
	private Date orderedDate;
	
	public OrderedList() {}
	
	public OrderedList(String customerInfo, MenuInfo menuInfo, double extraSize_Price, double extraTemp_Price,
			int menuCount, double usingMileage, double totalPrice) {
		super();
		this.customerInfo = customerInfo;
		this.menuInfo = menuInfo;
		this.extraSize_Price = extraSize_Price;
		this.extraTemp_Price = extraTemp_Price;
		this.menuCount = menuCount;
		this.usingMileage = usingMileage;
		this.totalPrice = totalPrice;
	}


	public OrderedList(long orderedList, String customerInfo, MenuInfo menuInfo, double extraSize_Price,
			double extraTemp_Price, int menuCount, double usingMileage, double totalPrice, Date orderedDate) {
		super();
		this.orderedList = orderedList;
		this.customerInfo = customerInfo;
		this.menuInfo = menuInfo;
		this.extraSize_Price = extraSize_Price;
		this.extraTemp_Price = extraTemp_Price;
		this.menuCount = menuCount;
		this.usingMileage = usingMileage;
		this.totalPrice = totalPrice;
		this.orderedDate = orderedDate;
	}
	
	
	public long getOrderedList() {
		return orderedList;
	}
	public void setOrderedList(long orderedList) {
		this.orderedList = orderedList;
	}
	public String getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}
	public MenuInfo getMenuInfo() {
		return menuInfo;
	}
	public void setMenuInfo(MenuInfo menuInfo) {
		this.menuInfo = menuInfo;
	}
	public double getExtraSize_Price() {
		return extraSize_Price;
	}
	public void setExtraSize_Price(double extraSize_Price) {
		this.extraSize_Price = extraSize_Price;
	}
	public double getExtraTemp_Price() {
		return extraTemp_Price;
	}
	public void setExtraTemp_Price(double extraTemp_Price) {
		this.extraTemp_Price = extraTemp_Price;
	}
	public int getMenuCount() {
		return menuCount;
	}
	public void setMenuCount(int menuCount) {
		this.menuCount = menuCount;
	}
	public double getUsingMileage() {
		return usingMileage;
	}
	public void setUsingMileage(double usingMileage) {
		this.usingMileage = usingMileage;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}
	
	
}
