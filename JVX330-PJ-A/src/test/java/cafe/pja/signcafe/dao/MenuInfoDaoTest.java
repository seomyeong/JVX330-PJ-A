package cafe.pja.signcafe.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MenuInfoDaoTest {

	@Autowired
	private MenuInfoDao dao;
	
	@Test
	public void allMenu() {
		dao.allMenu().forEach(m-> System.out.println(m));
	}

}
