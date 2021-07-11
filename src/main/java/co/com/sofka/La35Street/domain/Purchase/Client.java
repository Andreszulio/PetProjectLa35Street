package co.com.sofka.La35Street.domain.Purchase;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Entity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Client")
public class Client extends Entity<ClientId> {

    private final ClientName clientName;
    private final ClientAdress clientAdress;
    private final ClientEmailAdress clientEmailAdress;
    private final ClientTelephone clientTelephone;
    private final Rol rol;

    public Client(ClientId entityId,ClientName clientName, ClientAdress clientAdress, ClientEmailAdress clientEmailAdress,ClientTelephone clientTelephone, Rol rol){
        super(entityId);
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.clientEmailAdress = clientEmailAdress;
        this.clientTelephone = clientTelephone;
        this.rol = rol;
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

    public Rol rol(){
        return rol;
    }

}
