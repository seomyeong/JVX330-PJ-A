package cafe.pja.signcafe.service;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.UserDao;
import cafe.pja.signcafe.domain.User;

public class UserServiceImpl {
	private UserDao userDao;

	public UserServiceImpl(JdbcTemplate jdbcTemplate) {
		userDao = new UserDao(jdbcTemplate);
	}

	public void addUser(User user) {
		if(userDao.DuplicateCheck(user)) {
			System.out.println("해당 번호로 가입된 아이디가 있습니다.");
		} else {
			System.out.println("가입에 성공했습니다.");
			userDao.addUser(user);			
		}
	}
}
