package payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {

    // autogenerated value through the system to trace the order.
    private Integer orderId;
    // based on that user id we need to find what's the exact amount available in the
    // user balance table, so we can validate the request based on it.
    private Integer userId;
    private Integer amount;

}