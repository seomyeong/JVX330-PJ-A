package cafe.pja.signcafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cafe.pja.signcafe.domain.MenuInfo;

public class MenuInfoDao {
	private JdbcTemplate jdbcTemplate;

	public MenuInfoDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//메뉴불러오기
//	public List<MenuInfo> AllMenu(){
//		String sql = "SELECT * FROM MENU_INFO";
//		
//		return jdbcTemplate.query(sql, new RowMapper<MenuInfo>() {
//
//			@Override
//			public MenuInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return new MenuInfo(rs.getLong("menuNum"), rs.getString("category"), rs.getString("menuName"),rs.getDouble("menuPrice"));
//			}
//		});
//	}
	
	public List<MenuInfo> AllMenu(){
		String sql = "SELECT * FROM MENU_INFO";
		
		return jdbcTemplate.query(sql, new RowMapper<MenuInfo>() {

			@Override
			public MenuInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new MenuInfo(rs.getLong("menuNum"), rs.getString("category"),rs.getString("menuName"),rs.getDouble("menuPrice"));
			}
			
		});
	}//end of Method
	
}

