package cafe.pja.signcafe.service;

import cafe.pja.signcafe.domain.User;
import cafe.pja.signcafe.web.command.Info;

public interface AdminService {

	//관리자 로그인
	public boolean adminLogin(User user);
	
	//관리자 매출조회
	public Info allInquiryInfo();

}
