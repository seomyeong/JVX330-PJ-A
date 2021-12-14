package cafe.pja.signcafe.domain;

import java.util.Date;

public class CreditCard {
	
	private String card;		//카드사
	private String cardNum;		//카드번호
	private double supplyPrice; //판매가
	private double vat;			//부가세
	private double totalPrice;	//총합
	private Date regDate;		//결제일시
	
	public CreditCard () {}
	
	public CreditCard(String card, String cardNum, double supplyPrice, double vat, double totalPrice, Date regDate) {
		super();
		this.card = card;
		this.cardNum = cardNum;
		this.supplyPrice = supplyPrice;
		this.vat = vat;
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
	
	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
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
