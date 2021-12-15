package cafe.pja.signcafe.service;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.OrderedListDao;
import cafe.pja.signcafe.domain.OrderedList;

public class OrderedListServiceImpl {
	private OrderedListDao orderedListDao;
	
	public OrderedListServiceImpl(JdbcTemplate jdbcTemplate) {
		orderedListDao = new OrderedListDao(jdbcTemplate);
	}
	
	//MenuInfo테이블에 주문갯수 update
	public void updateMenuCount(OrderedList orderedList) {
		orderedListDao.updateMenuCount(orderedList);
	}
	
	
	//MenuInfo테이블에 usingMileage update
	public void updateMenuMileage(OrderedList orderedList) {
		orderedListDao.updateMenuMileage(orderedList);
	}
}
