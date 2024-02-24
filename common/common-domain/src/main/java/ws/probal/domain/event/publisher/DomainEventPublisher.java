package ws.probal.domain.event.publisher;

import ws.probal.domain.event.DomainEvent;

public interface DomainEventPublisher <T extends DomainEvent> {
    void publish(T domainEvent);
}
