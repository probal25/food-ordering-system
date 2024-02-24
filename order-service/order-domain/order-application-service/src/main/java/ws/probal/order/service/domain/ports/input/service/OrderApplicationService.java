package ws.probal.order.service.domain.ports.input.service;

import jakarta.validation.Valid;
import ws.probal.order.service.domain.dto.create.CreateOrderCommand;
import ws.probal.order.service.domain.dto.create.CreateOrderResponse;
import ws.probal.order.service.domain.dto.track.TrackOrderQuery;
import ws.probal.order.service.domain.dto.track.TrackOrderResponse;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
