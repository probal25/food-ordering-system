package ws.probal.order.service.domain;

import ws.probal.order.service.domain.entity.Order;
import ws.probal.order.service.domain.entity.Restaurant;
import ws.probal.order.service.domain.event.OrderCancelledEvent;
import ws.probal.order.service.domain.event.OrderCreatedEvent;
import ws.probal.order.service.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
