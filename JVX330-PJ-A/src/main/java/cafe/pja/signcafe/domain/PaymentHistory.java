package cafe.pja.signcafe.domain;

import java.util.Date;

public class PaymentHistory {
	private Long paymentList;
	private String payment_customerInfo;
	private String creditCard;
	private String creditCardNum;
	private double orderPrice;
	private Date paymentDate;
	
	public PaymentHistory() {}
	
	public Long getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(Long paymentList) {
		this.paymentList = paymentList;
	}
	public String getPayment_customerInfo() {
		return payment_customerInfo;
	}
	public void setPayment_customerInfo(String payment_customerInfo) {
		this.payment_customerInfo = payment_customerInfo;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getCreditCardNum() {
		return creditCardNum;
	}
	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
