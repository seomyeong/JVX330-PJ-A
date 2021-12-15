package cafe.pja.signcafe.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cafe.pja.signcafe.domain.PaymentHistory;

@Repository
public class PaymentDao {
	private JdbcTemplate jdbcTemplate;
	/* public boolean insertCreditCardInfo; */

	public PaymentDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @author 정지영
	 * 기능 : payment.jsp의 폼에 입력된 정보를 데이터테이블에 저장하는 기능.
	 * @param paymentCommand
	 * 
	 */
	public void insertCreditCardInfo(PaymentHistory paymentHistory) {
		String sql = "INSERT INTO PAYMENT_HISTORY(payment_customerInfo, creditCard, cardNum, orderPrice) VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, paymentHistory.getPayment_customerInfo(), paymentHistory.getCreditCard(), paymentHistory.getCreditCardNum(), paymentHistory.getOrderPrice());
	}
}
