package cafe.pja.signcafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cafe.pja.signcafe.domain.MenuInfo;

@Repository
public class MenuInfoDao {
	private JdbcTemplate jdbcTemplate;

	public MenuInfoDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//전체 메뉴 불러오기 - menuNum, menuName, menuPrice, menuimgPath
	public List<MenuInfo> allMenu(){
		String sql = "SELECT * FROM MENU_INFO";
		
		return jdbcTemplate.query(sql, new RowMapper<MenuInfo>() {

			@Override
			public MenuInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new MenuInfo(rs.getLong("menuNum"), rs.getString("category"),rs.getString("menuName"),rs.getDouble("menuPrice"),rs.getString("menuImgPath"));
			}
			
		});
	}//end of Method
	
	public String findCategoryByName(String menuName) {
		String sql = "SELECT * FROM MENU_INFO WHERE menuName=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("category");
			}
		}, menuName);
	}
	
	public Long findMenuNumByName(String menuName) {
		String sql = "SELECT * FROM MENU_INFO WHERE menuName=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Long>() {

			@Override
			public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getLong("menuNum");
			}
		}, menuName);
	}
	
	public MenuInfo findMenuInfoByName(String menuName) {
		String sql = "SELECT * FROM MENU_INFO WHERE menuName=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<MenuInfo>() {

			@Override
			public MenuInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuInfo m = new MenuInfo(rs.getLong("menuNum"), rs.getString("category"), rs.getString("menuName"), rs.getDouble("menuPrice"), rs.getLong("menuCount"), rs.getDouble("mileageCount"), rs.getString("menuImgPath"));
				
				return m;
			}
			
		}, menuName);
	}
	
	public void updateMenuInfoCount(String menuName, long menuCount, double mileageCount) {
		String sql = "UPDATE MENU_INFO SET menuCount=?, mileageCount=? WHERE menuName=?";
		jdbcTemplate.update(sql, menuCount, mileageCount, menuName);
	}
	
	
}

