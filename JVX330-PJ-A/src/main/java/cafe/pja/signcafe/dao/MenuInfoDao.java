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
	
	
}

