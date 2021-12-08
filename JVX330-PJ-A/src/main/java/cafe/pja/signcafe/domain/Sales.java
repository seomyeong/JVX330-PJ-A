package cafe.pja.signcafe.domain;
/*
 * Sales 클래스 용도 : 
 * user가 주문한 품목 저장시키는 테이블 (필요하지 않을 수도 있음)
 */
public class Sales {
	private long salesNum; // PK
	private long salesByCartNum; // FK?
	private String sales_menuName; 
	private double sales_menuPrice;
	private long sales_menuCount; //누적수량
	private double sales_totalPrice; //누적매출
}
