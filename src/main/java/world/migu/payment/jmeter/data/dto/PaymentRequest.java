package world.migu.payment.jmeter.data.dto;

import jakarta.validation.constraints.NotNull;

public record PaymentRequest(
	@NotNull(message = "사용자 id는 빈 값일 수 없습니다.")
	Integer userId,
	@NotNull(message = "결제 금액은 빈 값일 수 없습니다.")
	Double amount) {
}
