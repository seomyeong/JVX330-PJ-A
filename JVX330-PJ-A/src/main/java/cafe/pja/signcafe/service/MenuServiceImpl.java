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
	
	//메뉴테이블 불러오기
	public List<MenuInfo> allMenu(){
		List<MenuInfo> menu = menuInfoDao.AllMenu();
		return menu;
	}
}
