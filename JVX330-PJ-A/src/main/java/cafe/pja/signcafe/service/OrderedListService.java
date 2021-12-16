package cafe.pja.signcafe.service;

import java.util.List;

import cafe.pja.signcafe.domain.OrderedList;

public interface OrderedListService {

	// MenuInfo테이블에 주문갯수 update
	public void updateMenuCount(OrderedList orderedList);

	// MenuInfo테이블에 usingMileage update
	public void updateMenuMileage(OrderedList orderedList);
	
	//
	public void order(List<OrderedList> orderedList);

}
