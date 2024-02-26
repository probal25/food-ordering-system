package ws.probal.order.service.domain.mapper;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ws.probal.domain.valueobject.CustomerId;
import ws.probal.domain.valueobject.Money;
import ws.probal.domain.valueobject.ProductId;
import ws.probal.domain.valueobject.RestaurantId;
import ws.probal.order.service.domain.dto.create.CreateOrderCommand;
import ws.probal.order.service.domain.dto.create.CreateOrderResponse;
import ws.probal.order.service.domain.dto.create.OrderAddress;
import ws.probal.order.service.domain.dto.track.TrackOrderResponse;
import ws.probal.order.service.domain.entity.Order;
import ws.probal.order.service.domain.entity.OrderItem;
import ws.probal.order.service.domain.entity.Product;
import ws.probal.order.service.domain.entity.Restaurant;
import ws.probal.order.service.domain.valueobject.StreetAddress;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {
    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand) {
        return Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream().map(orderItem ->
                    new Product(new ProductId(orderItem.getProductId()))
                ).collect(Collectors.toList()))
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemsEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message) {
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message(message)
                .build();
    }

    public TrackOrderResponse orderToTrackOrderResponse(Order order) {
        return TrackOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .failureMessages(order.getFailureMessages())
                .build();
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
        return new StreetAddress(
                UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getPostalCode(),
                orderAddress.getCity()
        );
    }

    private List<OrderItem> orderItemsToOrderItemsEntities(@NotNull List<ws.probal.order.service.domain.dto.create.OrderItem> items) {
        return items.stream()
                .map(orderItem -> OrderItem.builder()
                        .product(new Product(new ProductId(orderItem.getProductId())))
                        .price(new Money(orderItem.getPrice()))
                        .quantity(orderItem.getQuantity())
                        .subTotal(new Money(orderItem.getSubTotal()))
                        .build()).collect(Collectors.toList());
    }
}
