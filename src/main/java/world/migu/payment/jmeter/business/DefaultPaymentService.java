package world.migu.payment.jmeter.business;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import world.migu.payment.jmeter.dao.UserRepository;
import world.migu.payment.jmeter.data.User;
import world.migu.payment.jmeter.data.dto.PaymentRequest;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultPaymentService implements PaymentService {
	private final UserRepository userRepository;

	@Override
	@Transactional(rollbackOn = EntityNotFoundException.class)
	public void pay(PaymentRequest paymentRequest) {
		User user = userRepository.findById(paymentRequest.userId()).orElseThrow(EntityNotFoundException::new);
		user.setAmount(paymentRequest.amount() + user.getAmount());
	}

	@Override
	@Transactional
	public void bulkSave(Integer count) {
		for (Integer i = 1; i <= count; i++) {
			User user = User.builder().id(i).amount(0.0).build();
			userRepository.save(user);
		}
	}
}
