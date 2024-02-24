package ws.probal.order.service.domain.ports.outport.repository;

import ws.probal.order.service.domain.entity.Order;
import ws.probal.order.service.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findByTrackingId(TrackingId trackingId);
}
