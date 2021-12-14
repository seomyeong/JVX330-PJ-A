package cafe.pja.signcafe.service;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.PaymentDao;
import cafe.pja.signcafe.web.command.PaymentCommand;

public class PaymentServiceImpl {

	private PaymentDao paymentDao;
	
	public PaymentServiceImpl(JdbcTemplate jdbcTemplate) {
		paymentDao = new PaymentDao(jdbcTemplate);
	}
	
	public boolean payByCreditCard(PaymentCommand paymentCommand) {
		if(paymentDao.getCreditCardInfo(paymentCommand)) {
			return true;
		}
	}
}
