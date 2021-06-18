package co.com.sofka.La35Street.domain.Purchase.commands;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Command;

public class AddClient implements Command {
    private final ClientId clientId;
    private final ClientName clientName;
    private final ClientAdress clientAdress;
    private final ClientEmailAdress clientEmailAdress;
    private final ClientTelephone clientTelephone;

    public AddClient(ClientId clientId, ClientName clientName, ClientAdress clientAdress, ClientEmailAdress clientEmailAdress,ClientTelephone clientTelephone){
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.clientEmailAdress = clientEmailAdress;
        this.clientTelephone = clientTelephone;
    }

    public ClientId ClientId() {
        return clientId;
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
