package cafe.pja.signcafe.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import cafe.pja.signcafe.web.command.PaymentCommand;

@SpringJUnitConfig(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class PaymentDaoTest {
	@Autowired
	private PaymentDao dao;

	@Test
	public void getCreditCardInfo(PaymentCommand paymentCommand) {
		dao.getCreditCardInfo(new PaymentCommand("삼성카드", "1111222233334444", 0, 0, 6000.0));

		//	String sql = "INSERT INTO PAYMENT_HISTORY(creditCard, cardNum, mileage, amount, orderPrice) VALUES(?, ?, ?, ?, ?)";
		//	jdbcTemplate.update(sql, paymentCommand.getCreditCard(), paymentCommand.getCardNum(), paymentCommand.getMileage(),
		//			paymentCommand.getAmount(), paymentCommand.getOrderPrice());
		//	}

	}
}