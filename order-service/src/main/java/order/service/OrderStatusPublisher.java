package order.service;

import order.dto.OrderRequestDto;
import order.events.OrderEvent;
import order.events.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class OrderStatusPublisher {

    // Sinks is a publisher which will help to emit the events of type Many<OrderEvent> to kafka topic.
    // It Helps building Sinks.Many sinks that will broadcast multiple signals to one or more Subscriber.
    @Autowired
    private Sinks.Many<OrderEvent> orderSinks;


    public void publishOrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
        // prepare the orderEvent object before publishing it to kafka topic.
        OrderEvent orderEvent = new OrderEvent(orderRequestDto, orderStatus);
        //publish or emit  the events to kafka
        orderSinks.tryEmitNext(orderEvent);
    }
}
