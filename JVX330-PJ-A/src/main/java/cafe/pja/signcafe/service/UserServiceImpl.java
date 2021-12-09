package cafe.pja.signcafe.service;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.UserDao;
import cafe.pja.signcafe.domain.User;

public class UserServiceImpl {
	private UserDao userDao;

	public UserServiceImpl(JdbcTemplate jdbcTemplate) {
		userDao = new UserDao(jdbcTemplate);
	}

	public boolean addUser(User user) {
		if(userDao.DuplicateCheck(user)) {
			System.out.println("해당 번호로 가입된 아이디가 있습니다.");
			return false;
		} else {
			userDao.addUser(user);
			System.out.println("가입에 성공했습니다.");
			return true;
		}
	}
	
	public void login(String phone, String passWd) {
		System.out.println("UserService에서 login 메소드 호출");
		
	}
}
