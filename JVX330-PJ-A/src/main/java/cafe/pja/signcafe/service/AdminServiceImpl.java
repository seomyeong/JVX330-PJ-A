package cafe.pja.signcafe.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.AdminDao;
import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.domain.OrderedList;
import cafe.pja.signcafe.domain.User;
import cafe.pja.signcafe.web.command.Info;

public class AdminServiceImpl implements AdminService {
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
		List<User> u = adminDao.allInquiryUserInfo();
		List<OrderedList> o = adminDao.allInquiryOrderedListInfo();
		
		
		return new Info(m, u, o);
	}
}
