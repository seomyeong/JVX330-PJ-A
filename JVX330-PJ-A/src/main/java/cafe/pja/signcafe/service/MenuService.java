package cafe.pja.signcafe.service;

import java.util.List;

import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.domain.OrderedList;
import cafe.pja.signcafe.domain.User;

public interface MenuService {
	//DB의 전체메뉴 불러오기
	public List<MenuInfo> allMenu();
	
	//메뉴이름으로 카테고리 찾기
	public String findCategory(String menuName);
	
	//메뉴이름으로 기본키 찾기
	public long findMenuNum(String menuName);
	
	//영수증 출력할때 수량이랑 팔린가격 업데이트
	public void updateMenuInfoCount(String menuName, int menuCount, double UsingMileage);
	
	
}
