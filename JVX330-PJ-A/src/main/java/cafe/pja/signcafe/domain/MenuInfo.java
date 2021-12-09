package cafe.pja.signcafe.domain;


public class MenuInfo {
	private long menuNum;		//PK
	private String category;
	private String menuName;
	private double menuPrice;
	private long menuCount;		//한 메뉴가 몇 개 팔렸는지 카운팅
	private double mileageCount;//유저들이 메뉴에 사용한 마일리지값 누적
	private String menuImgPath; //메뉴 이미지 경로지정(?)
}
