package cafe.pja.signcafe.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderedListDao {
	private JdbcTemplate jdbcTemplate;
	
	public OrderedListDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void updatePayment() {
		
	}
}
