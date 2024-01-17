package world.migu.payment.jmeter.data.dto;

import jakarta.validation.constraints.NotNull;

public record UserBulkInsertRequest(
	@NotNull
	Integer count) {
}
