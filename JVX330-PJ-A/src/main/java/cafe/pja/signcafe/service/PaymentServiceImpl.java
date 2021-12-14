package cafe.pja.signcafe.service;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.CreditCardDao;
import cafe.pja.signcafe.domain.CreditCard;

public class PaymentServiceImpl {

	private CreditCardDao creditCardDao;
	
	public PaymentServiceImpl(JdbcTemplate jdbcTemplate) {
		creditCardDao = new CreditCardDao(jdbcTemplate);
	}
}
