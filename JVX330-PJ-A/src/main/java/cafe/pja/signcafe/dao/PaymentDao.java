package cafe.pja.signcafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cafe.pja.signcafe.domain.PaymentHistory;

@Repository
public class PaymentDao {
	private JdbcTemplate jdbcTemplate;
	int count = 0;
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
		String sql = "INSERT INTO PAYMENT_HISTORY(payment_customerInfo, creditCard, creditCardNum, orderPrice) VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, paymentHistory.getPayment_customerInfo(), paymentHistory.getCreditCard(), paymentHistory.getCreditCardNum(), paymentHistory.getOrderPrice());
	}

	public String selectPayRegDate(int totalPayRegDateNum) {
		String sql = "SELECT * FROM PAYMENT_HISTORY WHERE paymentList=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<String> () {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return fmt.format(rs.getTimestamp("paymentDate"));
			}
			
		}, totalPayRegDateNum);
		
		
	}

	public int totalCount() {
		String sql = "SELECT * FROM PAYMENT_HISTORY";
		
		jdbcTemplate.query(sql, new RowMapper<PaymentHistory>() {

			@Override
			public PaymentHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
				count++;
				return null;
			}
			
		});
		return this.count;
	}
}
