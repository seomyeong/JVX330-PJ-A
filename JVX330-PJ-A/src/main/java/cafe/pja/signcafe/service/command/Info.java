package cafe.pja.signcafe.service.command;

import java.util.List;

import cafe.pja.signcafe.domain.MenuInfo;
import cafe.pja.signcafe.domain.OrderedList;
import cafe.pja.signcafe.domain.User;

public class Info {
	private List<MenuInfo> allMenuInfo;
	private List<User> allUserInfo;
	private List<OrderedList> allOrderedListInfo;
	
	public Info(List<MenuInfo> allMenuInfo, List<User> allUserInfo, List<OrderedList> allOrderedListInfo) {
		super();
		this.allMenuInfo = allMenuInfo;
		this.allUserInfo = allUserInfo;
		this.allOrderedListInfo = allOrderedListInfo;
	}
	
	public List<MenuInfo> getAllMenuInfo() {
		return allMenuInfo;
	}
	public void setAllMenuInfo(List<MenuInfo> allMenuInfo) {
		this.allMenuInfo = allMenuInfo;
	}
	public List<User> getAllUserInfo() {
		return allUserInfo;
	}
	public void setAllUserInfo(List<User> allUserInfo) {
		this.allUserInfo = allUserInfo;
	}
	public List<OrderedList> getAllOrderedListInfo() {
		return allOrderedListInfo;
	}
	public void setAllOrderedListInfo(List<OrderedList> allOrderedListInfo) {
		this.allOrderedListInfo = allOrderedListInfo;
	}

	@Override
	public String toString() {
		return "Info [allMenuInfo=" + allMenuInfo + ", allUserInfo=" + allUserInfo + ", allOrderedListInfo="
				+ allOrderedListInfo + "]";
	}	
	
}
