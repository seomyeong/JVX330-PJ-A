package cafe.pja.signcafe.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.MenuInfoDao;
import cafe.pja.signcafe.domain.MenuInfo;

public class MenuServiceImpl {
	private MenuInfoDao menuInfoDao;
	
	public MenuServiceImpl(JdbcTemplate jdbcTemplate) {
		menuInfoDao = new MenuInfoDao(jdbcTemplate);
	}
	
	//전체메뉴 조회
	public List<MenuInfo> allMenu(){
		List<MenuInfo> menu = menuInfoDao.allMenu();
		return menu;
	}	
}
