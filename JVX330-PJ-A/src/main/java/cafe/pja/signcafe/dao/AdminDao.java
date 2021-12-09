package cafe.pja.signcafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.domain.OrderedList;
import cafe.pja.signcafe.domain.User;

public class AdminDao {
private JdbcTemplate jdbcTemplate;
	
	public AdminDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<MenuInfo> AllInquiryMenuInfo() {
		String sql = "SELECT * FROM MENU_INFO";
		
		return jdbcTemplate.query(sql, new RowMapper<MenuInfo>() {

			@Override
			public MenuInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new MenuInfo(rs.getLong("menuNum"), rs.getString("category"), rs.getString("menuName"), rs.getDouble("menuPrice"), rs.getLong("menuCount"), rs.getDouble("mileageCount"), rs.getString("menuImgPath"));
			}
			
		});
	}
	
	public List<User> AllInquiryUserInfo() {
		String sql = "SELECT * FROM CAFE_USER";
		
		return jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getLong("id"), rs.getString("name"), rs.getString("phone"), rs.getString("passWd"), rs.getDouble("mileage"), rs.getDate("regDate"));
			}
			
		});
	}
	
	public List<OrderedList> AllInquiryOrderedListInfo() {
		String sql = "SELECT * FROM ORDERED";
		
		return jdbcTemplate.query(sql, new RowMapper<OrderedList>() {

			@Override
			public OrderedList mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuInfo menuInfo = new MenuInfo();
				menuInfo.setMenuNum(rs.getLong("ordered_MenuNum"));
				return new OrderedList(rs.getLong("orderedList"), rs.getString("ordered_customerInfo"), menuInfo, rs.getDouble("ordered_extraSize_Price"), rs.getDouble("ordered_extraTemp_Price"), rs.getInt("ordered_menuCount"), rs.getDouble("ordered_usingMileage"), rs.getDouble("ordered_totalPrice"), rs.getDate("ordered_orderedDate") );
			}
			
		});
	}
	
}
