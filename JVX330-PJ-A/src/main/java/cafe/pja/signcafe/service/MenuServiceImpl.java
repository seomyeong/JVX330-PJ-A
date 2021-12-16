package cafe.pja.signcafe.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.MenuInfoDao;
import cafe.pja.signcafe.domain.MenuInfo;

public class MenuServiceImpl implements MenuService{
	private MenuInfoDao menuInfoDao;
	
	public MenuServiceImpl(JdbcTemplate jdbcTemplate) {
		menuInfoDao = new MenuInfoDao(jdbcTemplate);
	}
	
	//전체메뉴 조회
	public List<MenuInfo> allMenu(){
		List<MenuInfo> menu = menuInfoDao.allMenu();
		return menu;
	}
	
	public String findCategory(String menuName) {
		return menuInfoDao.findCategoryByName(menuName);
	}
	
	public long findMenuNum(String menuName) {
		return menuInfoDao.findMenuNumByName(menuName);
	}
	
	// 영수증 출력할때 수량이랑 팔린가격 업데이트
	public void updateMenuInfoCount(String menuName, int menuCount, double UsingMileage) {
		MenuInfo menuInfo = menuInfoDao.findMenuInfoByName(menuName);
		
		long resultMenuCount = menuInfo.getMenuCount() + menuCount;
		double resultMileageCount = menuInfo.getMileageCount() + UsingMileage;
		
		menuInfoDao.updateMenuInfoCount(menuName, resultMenuCount, resultMileageCount);
		
	}
}
