package cafe.pja.signcafe.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.domain.User;

@SpringJUnitConfig(locations = {"dao.xml"})
public class AdminDaoTest {
	@Autowired
	private AdminDao dao;
		
//	@Test
//	public void AllInquiryMenuInfo() {
//		List<MenuInfo> list = dao.allInquiryMenuInfo();
//		assertTrue(list.size() == 11);
//	}
	
	@Test
	public void AllInquiryUserInfo() {
		List<User> userList = dao.AllInquiryUserInfo();
		assertTrue(userList.size() == 7);
//		dao.AllInquiryUserInfo().forEach(m-> System.out.println(m));
	}
}
