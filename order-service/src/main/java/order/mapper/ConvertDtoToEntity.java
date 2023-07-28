package order.mapper;

import order.dto.OrderRequestDto;
import order.entity.PurchaseOrder;
import order.events.OrderStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConvertDtoToEntity {

    @Bean
    public PurchaseOrder convertDtoToEntity(OrderRequestDto dto) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setProductId(dto.getProductId());
        purchaseOrder.setUserId(dto.getUserId());
        purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);
        purchaseOrder.setPrice(dto.getAmount());
        return purchaseOrder;
    }
}
