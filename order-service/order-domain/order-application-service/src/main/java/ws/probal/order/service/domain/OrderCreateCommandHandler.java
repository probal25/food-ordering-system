package ws.probal.order.service.domain;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ws.probal.order.service.domain.dto.create.CreateOrderCommand;
import ws.probal.order.service.domain.dto.create.CreateOrderResponse;
import ws.probal.order.service.domain.event.OrderCreatedEvent;
import ws.probal.order.service.domain.mapper.OrderDataMapper;
import ws.probal.order.service.domain.ports.outport.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderCreateHelper orderCreateHelper;
    private final OrderDataMapper orderDataMapper;
    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;

    public OrderCreateCommandHandler(OrderCreateHelper orderCreateHelper,
                                     OrderDataMapper orderDataMapper,
                                     OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher) {
        this.orderCreateHelper = orderCreateHelper;
        this.orderDataMapper = orderDataMapper;
        this.orderCreatedPaymentRequestMessagePublisher = orderCreatedPaymentRequestMessagePublisher;
    }

    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent);
        return orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.getOrder());
    }
}
