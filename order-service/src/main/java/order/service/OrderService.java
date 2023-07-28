package order.service;

import order.dto.OrderRequestDto;
import order.entity.PurchaseOrder;
import order.events.OrderStatus;
import order.mapper.ConvertDtoToEntity;
import order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusPublisher orderStatusPublisher;

    @Autowired
    private ConvertDtoToEntity mapper;


    // here we're persisting order objects into database, then immediately we're publishing an event into
    // order event kafka topic, and this should be done in a single transaction.
    @Transactional
    public PurchaseOrder createOrder(OrderRequestDto orderRequestDto) {
        PurchaseOrder order = orderRepository.save(mapper.convertDtoToEntity(orderRequestDto));
        orderRequestDto.setOrderId(order.getId());
        //produce kafka event with status ORDER_CREATED
        orderStatusPublisher.publishOrderEvent(orderRequestDto, OrderStatus.ORDER_CREATED);
        return order;
    }

    public List<PurchaseOrder> getAllOrders(){
        return orderRepository.findAll();
    }
}
