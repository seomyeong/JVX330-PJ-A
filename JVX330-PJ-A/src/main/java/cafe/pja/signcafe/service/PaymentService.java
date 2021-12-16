package cafe.pja.signcafe.service;

import cafe.pja.signcafe.domain.PaymentHistory;
import cafe.pja.signcafe.web.command.PaymentCommand;

public interface PaymentService {
	
	// 결제한 카드 정보
	public void payByCreditCard(PaymentHistory paymentHistory);
	
	// 결제날짜 받아오기
	public String getPayRegDate(int totalPayRegDateNum);
	
	// PAYMENT_HISTORY테이블 기본컬럼값 count
	public int totalCount();
}
