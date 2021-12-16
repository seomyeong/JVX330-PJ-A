package cafe.pja.signcafe.service;

import cafe.pja.signcafe.domain.User;

public interface UserService {
	
	//멤버쉽 가입
	public boolean addUser(User user);
	
	//멤버쉽 로그인 - 본인의 가입정보, 마일리지 정보 확인 
	public boolean myPageLogin(User user);
	
	//폰번호로 유저 찾기
	public User userInfoByPhone(User user);
	
	//쿠키로 넘겨온 폰번호로 유저 정보 수정
	public boolean updateUserInfo(User user, String connectUserPhone);
	
	//checkUser.jsp 에서 입력한 폰번호가 디비의 폰번호와 일치하는지 확인
	public boolean checkUserbyPhone(User user);
	
	//등록된 유저 폰번호를 찾아서 마일리지 사용, 유저가 보유한 마일리지보다 큰 값을 사용하면 예외처리
	public boolean calculMileage(String userPhone, double amount);

}
