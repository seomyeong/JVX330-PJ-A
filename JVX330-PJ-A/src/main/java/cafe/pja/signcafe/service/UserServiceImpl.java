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
	
	public boolean login(User user) {
		if(userDao.login(user)) {
			System.out.println("입력하신 정보와 일치하는 회원정보가 없습니다.");
			return false;
		} else {
			System.out.println("로그인에 성공했습니다.");
			return true;
		}
		
		
	}
}
