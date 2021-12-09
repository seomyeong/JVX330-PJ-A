package cafe.pja.signcafe.domain;


public class MenuInfo {
	private long menuNum;		//PK
	private String category;
	private String menuName;
	private double menuPrice;
	private long menuCount;		//한 메뉴가 몇 개 팔렸는지 카운팅
	private double mileageCount;//유저들이 메뉴에 사용한 마일리지값 누적
	private String menuImgPath; //메뉴 이미지 경로지정(?)
	
	public MenuInfo() {}
	
	public MenuInfo(long menuNum, String category, String menuName, double menuPrice, long menuCount,
			double mileageCount, String menuImgPath) {
		super();
		this.menuNum = menuNum;
		this.category = category;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuCount = menuCount;
		this.mileageCount = mileageCount;
		this.menuImgPath = menuImgPath;
	}
	
	public long getMenuNum() {
		return menuNum;
	}
	public void setMenuNum(long menuNum) {
		this.menuNum = menuNum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(double menuPrice) {
		this.menuPrice = menuPrice;
	}
	public long getMenuCount() {
		return menuCount;
	}
	public void setMenuCount(long menuCount) {
		this.menuCount = menuCount;
	}
	public double getMileageCount() {
		return mileageCount;
	}
	public void setMileageCount(double mileageCount) {
		this.mileageCount = mileageCount;
	}
	public String getMenuImgPath() {
		return menuImgPath;
	}
	public void setMenuImgPath(String menuImgPath) {
		this.menuImgPath = menuImgPath;
	}

	@Override
	public String toString() {
		return "MenuInfo [menuNum=" + menuNum + ", category=" + category + ", menuName=" + menuName + ", menuPrice="
				+ menuPrice + ", menuCount=" + menuCount + ", mileageCount=" + mileageCount + ", menuImgPath="
				+ menuImgPath + "]";
	}
	
	
}
