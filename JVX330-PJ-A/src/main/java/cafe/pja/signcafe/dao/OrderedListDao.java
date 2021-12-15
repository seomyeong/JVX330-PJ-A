package cafe.pja.signcafe.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.domain.OrderedList;
import cafe.pja.signcafe.domain.User;

public class OrderedListDao {
	private JdbcTemplate jdbcTemplate;

	
	public OrderedListDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	//MenuInfo테이블에 주문갯수 update
	public void updateMenuCount(OrderedList ordered) {
		String sql = "UPDATE MENU_INFO SET MENUCOUNT=? WHERE ordered_MenuNum=? AND orderedList=?";
		jdbcTemplate.update(sql, (Long)ordered.getMenuInfo().getMenuCount() + ordered.getMenuCount(),
				ordered.getMenuInfo().getMenuNum(),
				ordered.getOrderedList());
	}

	//MenuInfo테이블에 usingMileage update
	public void updateMenuMileage(OrderedList ordered) {
		String sql = "UPDATE MENU_INFO SET mileageCount=? WHERE ordered_MenuNum=?";
		jdbcTemplate.update(sql, ordered.getMenuCount(), ordered.getMenuInfo().getMenuNum());
	}
	
	//USER_INFO테이블에 usingMileage 0.03% update
	public void updateUserMileage(User user, double usingMileage, String connectUserPhone) {
		String sql = "UPDATE CAFE_USER SET mileage=? WHERE phone=?";
		jdbcTemplate.update(sql, user.getMileage()+usingMileage, connectUserPhone);
	}
	
	
	public void updatePayment() {
		
	}
	
	public void updateOrderedTable(List<OrderedList> orderedList) {
		String sql = "INSERT INTO ORDERED(ordered_customerInfo, ordered_MenuName, ordered_extraSize_Price, ordered_extraTemp_Price, ordered_menuCount, ordered_usingMileage, ordered_totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		for(OrderedList o : orderedList) {
			jdbcTemplate.update(sql, o.getCustomerInfo(), o.getMenuInfo().getMenuName(), o.getExtraSize_Price(), o.getExtraTemp_Price(), o.getMenuCount(), o.getUsingMileage(), o.getTotalPrice());			
		}
	}
}
