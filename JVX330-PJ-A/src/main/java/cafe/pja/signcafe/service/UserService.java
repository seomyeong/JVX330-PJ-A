package cafe.pja.signcafe.service;

import cafe.pja.signcafe.domain.User;

public interface UserService {
	
	//멤버쉽 가입
	public void addUser(User user);
	
	
	//마이페이지 조회 (phone과 passWd로 유효성 검사) - 본인의 가입정보, 마일리지 정보 확인 
	public void myPageLogin(String phone, String passWd); //마이페이지 진입(로그인)
	
	//마일리지 적립 ( phone으로 유효성 검사)
	public void login(String phone); //마일리지 적립을 위한 로그인 
	
	
	//마이페이지 정보수정을 위한 회원정보 출력
	public User modifyMyPage(User user);
	

}
