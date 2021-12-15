package cafe.pja.signcafe.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cafe.pja.signcafe.web.command.PaymentCommand;

@Repository
public class PaymentDao {
	private JdbcTemplate jdbcTemplate;

	public PaymentDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @author 정지영
	 * 기능 : payment.jsp의 폼에 입력된 정보를 데이터테이블에 저장하는 기능.
	 * @param paymentCommand
	 * 
	 */
	public void insertCreditCardInfo(PaymentCommand paymentCommand) {
		String sql = "INSERT INTO PAYMENT_HISTORY(creditCard, cardNum, mileage, amount, orderPrice) VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, paymentCommand.getCreditCard(), paymentCommand.getCardNum(), paymentCommand.getMileage(),
				paymentCommand.getAmount(), paymentCommand.getOrderPrice());
	}
}
