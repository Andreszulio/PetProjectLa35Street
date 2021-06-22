package co.com.sofka.La35Street.domain.Purchase.events;

import co.com.sofka.La35Street.domain.Purchase.values.ClientAdress;
import co.com.sofka.La35Street.domain.Purchase.values.ClientEmailAdress;
import co.com.sofka.La35Street.domain.Purchase.values.ClientName;
import co.com.sofka.La35Street.domain.Purchase.values.ClientTelephone;
import co.com.sofka.domain.generic.DomainEvent;

public class ClientEdited extends DomainEvent {
    private final ClientName clientName;
    private final ClientAdress clientAdress;
    private final ClientEmailAdress clientEmailAdress;
    private final ClientTelephone clientTelephone;

    public ClientEdited(ClientName clientName, ClientAdress clientAdress, ClientEmailAdress clientEmailAdress, ClientTelephone clientTelephone) {
        super("La35Street.Client.Edited");
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.clientEmailAdress = clientEmailAdress;
        this.clientTelephone = clientTelephone;
    }

    public ClientName ClientName() {
        return clientName;
    }

    public ClientAdress ClientAdress() {
        return clientAdress;
    }

    public ClientEmailAdress ClientEmailAdress() {
        return clientEmailAdress;
    }

    public ClientTelephone ClientTelephone() {
        return clientTelephone;
    }
}
