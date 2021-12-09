package cafe.pja.signcafe.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDao {
private JdbcTemplate jdbcTemplate;
	
	public AdminDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
