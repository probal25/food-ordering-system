package ws.probal.order.service.domain.ports.outport.message.publisher.payment;

import ws.probal.domain.event.publisher.DomainEventPublisher;
import ws.probal.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
