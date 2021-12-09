package cafe.pja.signcafe.service;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.AdminDao;
import cafe.pja.signcafe.domain.User;

public class AdminServiceImpl {
	private AdminDao adminDao;

	public AdminServiceImpl(JdbcTemplate jdbcTemplate) {
		adminDao = new AdminDao(jdbcTemplate);
	}

	public boolean adminLogin(User user) {
		if (user.getName().equals("admin") && user.getPassWd().equals("admin")) {
			return true;
		}
		return false;
	}
}
