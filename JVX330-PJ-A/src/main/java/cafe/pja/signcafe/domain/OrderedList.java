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
}
