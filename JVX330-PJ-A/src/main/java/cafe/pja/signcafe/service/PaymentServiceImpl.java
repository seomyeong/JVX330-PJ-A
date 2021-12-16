package cafe.pja.signcafe.service;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.PaymentDao;
import cafe.pja.signcafe.domain.PaymentHistory;

public class PaymentServiceImpl {

	private PaymentDao paymentDao;
	
	public PaymentServiceImpl(JdbcTemplate jdbcTemplate) {
		paymentDao = new PaymentDao(jdbcTemplate);
	}
	
	public void payByCreditCard(PaymentHistory paymentHistory) {
		paymentDao.insertCreditCardInfo(paymentHistory);
	}

	public String getPayRegDate(int totalPayRegDateNum) {
		return paymentDao.selectPayRegDate(totalPayRegDateNum);
	}

	public int totalCount() {
		return paymentDao.totalCount();
	}
}
