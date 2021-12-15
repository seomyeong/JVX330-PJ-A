package cafe.pja.signcafe.data;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import cafe.pja.signcafe.dao.PaymentDao;
import cafe.pja.signcafe.service.AdminServiceImpl;
import cafe.pja.signcafe.service.MenuServiceImpl;
import cafe.pja.signcafe.service.OrderedListServiceImpl;
import cafe.pja.signcafe.service.PaymentServiceImpl;
import cafe.pja.signcafe.service.UserServiceImpl;

@Configuration
public class DataSourceConfig {
	@Bean
	public DataSource dataSource() {
		DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		ds.setUrl("jdbc:derby://localhost:1527/jvx330a");
		ds.setUsername("jvx330a");
		ds.setPassword("jvx330a");

		ds.setInitialSize(2); // 초기에 2개 만들어라
		ds.setMaxActive(10); // 최대 10까지 만들어라 디폴트 100개
		ds.setMaxIdle(10); // 안적어주면 디폴드값은 100개
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public UserServiceImpl userServiceImpl() {
		return new UserServiceImpl(jdbcTemplate());
	}
	
	@Bean
	public AdminServiceImpl adminServiceImpl() {
		return new AdminServiceImpl(jdbcTemplate());
	}
	
	@Bean
	public MenuServiceImpl menuServiceImpl() {
		return new MenuServiceImpl(jdbcTemplate());
	}
	
	@Bean
	public PaymentServiceImpl paymentServiceImpl() {
		return new PaymentServiceImpl(jdbcTemplate());
	}
	
	@Bean
	public OrderedListServiceImpl orderedListServiceImpl() {
		return new OrderedListServiceImpl(jdbcTemplate());
	}
	
}
