package cafe.pja.signcafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cafe.pja.signcafe.domain.User;

public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 작성자 : JongSeong
	 * 
	 * 기능 - User phone 중복검사 - 중복되면 true, 중복되지 않으면 false
	 * 
	 * @param user
	 * @return
	 */
	public Boolean DuplicateCheck(User user) {
		String sql = "SELECT * FROM CAFE_USER WHERE phone=?";
		List<User> findUser = null;

		findUser = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getString("name"), rs.getString("phone"), rs.getString("passWd"));
			}


		}, user.getPhone());

		if (findUser.size() == 0) {
			return false;
		}
		
		return true;
	}

	/**
	 * 작성자 : JongSeong
	 * 
	 * 기능 - User 추가
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		String sql = "INSERT INTO CAFE_USER(name, phone, passWd) VALUES(?, ?, ?) ";
		jdbcTemplate.update(sql, user.getName(), user.getPhone(), user.getPassWd());
	}

	
	/**
	 * 작성자 : 지영
	 * 
	 * 기능 - 회원 비밀번호 중복검사 - userLogin.size() == 0, 찾는 값(passWd)이 없으면 로그인 실패, 있으면 로그인 성공. 
	 * @param passWd
	 * @return
	 */
	public boolean passWdCheck(User user) {
		String sql = "SELECT * FROM CAFE_USER WHERE passWd=?";
		List<User> pwCheck = null;
		
		pwCheck = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User(rs.getString("name"), rs.getString("phone"), rs.getString("passWd"));
				//System.out.println("dao test"+user);
				return user;
			}
		}, user.getPassWd());
	
		if(pwCheck.size() == 0) {
			//System.out.println("pwcheck"+pwCheck);
			return false;
		}	
			
			return true;
	}
	
	public User searchUserByPhone(User user) {
		String sql = "SELECT * FROM CAFE_USER WHERE phone=?";

		return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getString("name"), rs.getString("phone"), rs.getString("passWd"), rs.getDouble("mileage"));
			}


		}, user.getPhone());
	}

}
