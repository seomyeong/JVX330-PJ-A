package cafe.pja.signcafe.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.AdminDao;
import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.domain.OrderedList;
import cafe.pja.signcafe.domain.User;
import cafe.pja.signcafe.service.command.Info;

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
	
	public Info allInquiryInfo() {
		List<MenuInfo> m = adminDao.allInquiryMenuInfo();
		List<User> u = adminDao.AllInquiryUserInfo();
		List<OrderedList> o = adminDao.AllInquiryOrderedListInfo();
		
		return new Info(m, u, o);
	}
}
