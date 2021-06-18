package co.com.sofka.La35Street.domain.Purchase.events;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class AggregateClient extends DomainEvent {
    private final ClientId clientId;
    private final ClientName clientName;

    public AggregateClient(ClientId clientId, ClientName clientName, ClientAdress clientAdress, ClientEmailAdress clientEmailAdress,ClientTelephone clientTelephone){
        super("La35Street.Client.Aggregated");
        this.clientId = clientId;
        this.clientName = clientName;
        aggregateRootId();
    }

    public ClientId ClientId() {
        return clientId;
    }

    public ClientName ClientName() {
        return clientName;
    }
}
