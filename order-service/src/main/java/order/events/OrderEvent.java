package order.events;

import lombok.Data;
import lombok.NoArgsConstructor;
import order.dto.OrderRequestDto;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class OrderEvent implements Event{

    // as part of each event I want to generate a random id to trace each order.
    private UUID eventId=UUID.randomUUID();
    // as part of each event I want to pass the date of that particular event.
    private Date eventDate=new Date();
    private OrderRequestDto orderRequestDto;
    private OrderStatus orderStatus;

    public OrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
        this.orderRequestDto = orderRequestDto;
        this.orderStatus = orderStatus;
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