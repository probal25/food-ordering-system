package ws.probal.order.service.domain.ports.outport.message.publisher.payment;

import ws.probal.domain.event.publisher.DomainEventPublisher;
import ws.probal.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
