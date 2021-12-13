package cafe.pja.signcafe.test.java;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import cafe.pja.signcafe.dao.MenuInfoDao;

@SpringJUnitConfig(classes = {
		cafe.pja.signcafe.dao.MenuInfoDao.java
		cafe.pja.signcafe.dao.OrderedListDao.java})

public class MenuItemJdbcDaoTest {
	
	@Autowired
	private MenuInfoDao menuItemJdbcDao;
	
	@Test
	void findAll() {
		List<MenuItem> list = menuItemJdbcDao.findAll();
		for(MenuItem item : list) {
			System.out.println(item);
		}
	}
}
