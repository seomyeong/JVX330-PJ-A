package cafe.pja.signcafe.web.command;

import java.util.Date;

public class PaymentCommand {
	private String creditCard; //카드사
	private String cardNum; //카드번호
	private double supplyPrice; //판매가
	private double vat;			//부가세
	private double mileage; // 보유 마일리지
	private double amount; // 사용 마일리지
	private double orderPrice; // 주문 금액
	private Date regDate;		//결제일시
	
	
	public PaymentCommand() {}

	public PaymentCommand(String creditCard, String cardNum, double supplyPrice, double vat, double mileage,
			double amount, double orderPrice, Date regDate) {
		super();
		this.creditCard = creditCard;
		this.cardNum = cardNum;
		this.supplyPrice = supplyPrice;
		this.vat = vat;
		this.mileage = mileage;
		this.amount = amount;
		this.orderPrice = orderPrice;
		this.regDate = regDate;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public double getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(double supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


}
