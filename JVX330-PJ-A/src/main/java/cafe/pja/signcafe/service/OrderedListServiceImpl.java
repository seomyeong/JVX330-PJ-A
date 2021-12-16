package cafe.pja.signcafe.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.OrderedListDao;
import cafe.pja.signcafe.domain.OrderedList;

public class OrderedListServiceImpl implements OrderedListService {
	private OrderedListDao orderedListDao;
	
	public OrderedListServiceImpl(JdbcTemplate jdbcTemplate) {
		orderedListDao = new OrderedListDao(jdbcTemplate);
	}
	
	//MenuInfo테이블에 주문갯수 update
	@Override
	public void updateMenuCount(OrderedList orderedList) {
		orderedListDao.updateMenuCount(orderedList);
	}

	//MenuInfo테이블에 usingMileage update
	@Override
	public void updateMenuMileage(OrderedList orderedList) {
		orderedListDao.updateMenuMileage(orderedList);
	}

	//Ordered테이블에 insert
	@Override
	public void order(List<OrderedList> orderedList) {
		orderedListDao.updateOrderedTable(orderedList);
	}
}
