package cafe.pja.signcafe.service;

import cafe.pja.signcafe.domain.PaymentHistory;
import cafe.pja.signcafe.web.command.PaymentCommand;

public interface PaymentService {
	
	// PAYMENT_HISTORY 테이블의 결제한 카드 정보
	public void payByCreditCard(PaymentHistory paymentHistory);
	
	// PAYMENT_HISTORY 테이블의 결제날짜
	public String getPayRegDate(int totalPayRegDateNum);
	
	// PAYMENT_HISTORY 테이블의 기본 row count
	public int totalCount();
}
