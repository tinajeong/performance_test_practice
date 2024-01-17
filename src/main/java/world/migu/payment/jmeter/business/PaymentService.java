package world.migu.payment.jmeter.business;

import world.migu.payment.jmeter.data.dto.PaymentRequest;

public interface PaymentService {
	void pay(PaymentRequest paymentRequest);

	void bulkSave(Integer count);
}
