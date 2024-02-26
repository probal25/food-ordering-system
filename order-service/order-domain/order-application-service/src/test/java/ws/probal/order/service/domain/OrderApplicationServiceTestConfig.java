package ws.probal.order.service.domain;

import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ws.probal.order.service.domain.ports.outport.message.publisher.payment.OrderCancelledPaymentRequestMessagePublisher;
import ws.probal.order.service.domain.ports.outport.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import ws.probal.order.service.domain.ports.outport.message.publisher.restaurantapproval.OrderPaidRestaurantRequestMessagePublisher;
import ws.probal.order.service.domain.ports.outport.repository.CustomerRepository;
import ws.probal.order.service.domain.ports.outport.repository.OrderRepository;
import ws.probal.order.service.domain.ports.outport.repository.RestaurantRepository;

@SpringBootApplication(scanBasePackages = "ws.probal.order")
public class OrderApplicationServiceTestConfig {

    @Bean
    public OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher() {
        return Mockito.mock(OrderCreatedPaymentRequestMessagePublisher.class);
    }

    @Bean
    public OrderCancelledPaymentRequestMessagePublisher orderCancelledPaymentRequestMessagePublisher() {
        return Mockito.mock(OrderCancelledPaymentRequestMessagePublisher.class);
    }

    @Bean
    public OrderPaidRestaurantRequestMessagePublisher orderPaidRestaurantRequestMessagePublisher() {
        return Mockito.mock(OrderPaidRestaurantRequestMessagePublisher.class);
    }

    @Bean
    public OrderRepository orderRepository() {
        return Mockito.mock(OrderRepository.class);
    }

    @Bean
    public CustomerRepository customerRepository() {
        return Mockito.mock(CustomerRepository.class);
    }

    @Bean
    public RestaurantRepository restaurantRepository() {
        return Mockito.mock(RestaurantRepository.class);
    }

    @Bean
    public OrderDomainService orderDomainService() {
        return new OrderDomainServiceImpl();
    }
}
