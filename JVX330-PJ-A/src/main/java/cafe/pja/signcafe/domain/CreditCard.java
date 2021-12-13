package cafe.pja.signcafe.domain;

import java.util.Date;

public class CreditCard {
	
	private String card;
	private String cardNum;
	private double supplyPrice;
	private double vAT;
	private double totalPrice;
	private Date regDate;
	
	public CreditCard () {}
	
	public CreditCard(String card, String cardNum, double supplyPrice, double vAT, double totalPrice, Date regDate) {
		super();
		this.card = card;
		this.cardNum = cardNum;
		this.supplyPrice = supplyPrice;
		this.vAT = vAT;
		this.totalPrice = totalPrice;
		this.regDate = regDate;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
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

	public double getvAT() {
		return vAT;
	}

	public void setvAT(double vAT) {
		this.vAT = vAT;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
