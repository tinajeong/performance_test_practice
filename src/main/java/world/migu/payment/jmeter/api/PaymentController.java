package world.migu.payment.jmeter.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import world.migu.payment.jmeter.business.PaymentService;
import world.migu.payment.jmeter.data.dto.PaymentRequest;
import world.migu.payment.jmeter.data.dto.UserBulkInsertRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
public class PaymentController {

	private final PaymentService paymentService;

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updatePayment(@RequestBody @Valid PaymentRequest request) {
		if (request.amount() < 0) {
			return ResponseEntity.badRequest().body("유효하지 않은 결제 금액입니다.");
		}

		paymentService.pay(request);
		return ResponseEntity.ok("결제가 성공했습니다.");
	}

	@PutMapping(value = "")
	public ResponseEntity<String> insertBulkUser(@RequestBody @Valid UserBulkInsertRequest userBulkInsertRequest) {
		paymentService.bulkSave(userBulkInsertRequest.count());
		return ResponseEntity.ok("대용량 사용자정보 저장 완료 되었습니다.");
	}
}
