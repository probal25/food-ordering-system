package ws.probal.order.service.domain.ports.outport.message.publisher.restaurantapproval;

import ws.probal.domain.event.publisher.DomainEventPublisher;
import ws.probal.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
