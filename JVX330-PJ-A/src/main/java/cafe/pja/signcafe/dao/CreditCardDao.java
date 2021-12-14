package cafe.pja.signcafe.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreditCardDao {
	private JdbcTemplate jdbcTemplate;


	public CreditCardDao(JdbcTemplate jdbcTemplate) {
//		this.
	}


	public void addPayment() {
		String sql = "INSERT INTO PAYMENT_HISTORY(paymenList, payment_customerInfo, creditCard, creditCardNum, payment_totalPrice, paymentDate) VALUES(?, ?, ?, ?, ?, ?)";
	}
}
