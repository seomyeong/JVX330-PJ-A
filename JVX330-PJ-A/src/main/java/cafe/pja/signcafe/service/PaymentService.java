package cafe.pja.signcafe.service;

import cafe.pja.signcafe.web.command.PaymentCommand;

public interface PaymentService {
	
	// 결제한 카드 정보 받아오기
	public void payByCreditCard(PaymentCommand paymentCommand);
}
