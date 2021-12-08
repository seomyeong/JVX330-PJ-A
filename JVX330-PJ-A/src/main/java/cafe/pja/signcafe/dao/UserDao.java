package cafe.pja.signcafe.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.domain.User;


public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * JongSeong
	 * 
	 * - User phone 중복검사 - 중복되면 true, 중복되지 않으면 false
	 * 
	 * @param user
	 * @return
	 */
	public Boolean DuplicateCheck(User user) {
		String sql = "SELECT * FROM User WHERE phone=?";
		System.out.println(sql);

		return false;
	}

	public void addUser(User user) {
		String sql = "INSERT INTO User() ";
		System.out.println("UserDao에서 addUser 메소드 호출");
	}
}
