package cafe.pja.signcafe.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.domain.OrderedList;

public class OrderedListDao {
	private JdbcTemplate jdbcTemplate;

	
	public OrderedListDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	//MenuInfo테이블에 주문갯수 update
	public void updateMenuCount(OrderedList ordered) {
		String sql = "UPDATE MENU_INFO SET MENUCOUNT=? WHERE ordered_MenuNum=? AND orderedList=?";
		jdbcTemplate.update(sql, (Long)ordered.getMenuInfo().getMenuCount() + ordered.getMenuCount(), ordered.getMenuInfo().getMenuNum(), ordered.getOrderedList());
	}

	//MenuInfo테이블에 usingMileage update
	public void updateMenuMileage(OrderedList ordered) {
		String sql = "UPDATE MENU_INFO SET mileageCount=? WHERE ordered_MenuNum=?";
		jdbcTemplate.update(sql, ordered.getMenuCount(), ordered.getMenuInfo().getMenuNum());
	}
	
	public void updatePayment() {
		
	}
}
