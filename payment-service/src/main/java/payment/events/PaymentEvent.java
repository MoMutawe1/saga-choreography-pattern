package payment.events;

import lombok.Data;
import lombok.NoArgsConstructor;
import payment.dto.PaymentRequestDto;

import java.util.Date;
import java.util.UUID;
@NoArgsConstructor
@Data
public class PaymentEvent implements Event{

    // as part of each event I want to generate a random id to trace each payment.
    private UUID eventId=UUID.randomUUID();
    // as part of each event I want to pass the date of that particular event.
    private Date eventDate=new Date();
    private PaymentRequestDto paymentRequestDto;
    private PaymentStatus paymentStatus;

    public PaymentEvent(PaymentRequestDto paymentRequestDto, PaymentStatus paymentStatus) {
        this.paymentRequestDto = paymentRequestDto;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getDate() {
        return eventDate;
    }
}