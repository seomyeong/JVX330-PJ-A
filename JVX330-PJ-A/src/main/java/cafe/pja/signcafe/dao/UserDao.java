package cafe.pja.signcafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cafe.pja.signcafe.domain.User;

public class UserDao {

	public JdbcTemplate jdbcTemplate;
	
	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// 로그인
	public boolean login(String phone, String passWd) {
	
		
			}
		});
	}
	
	// 회원정보 수정
	
	// 마일리지 조회
	
	//
}
