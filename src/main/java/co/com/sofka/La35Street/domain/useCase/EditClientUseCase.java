package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Client;
import co.com.sofka.La35Street.domain.Purchase.commands.EditClient;
import co.com.sofka.La35Street.repository.ClientData;
import co.com.sofka.La35Street.repository.IClientDataRepository;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditClientUseCase extends UseCase<RequestCommand<EditClient>, EditPurchaseUseCase.Response> {

    @Autowired
    private IClientDataRepository iClientDataRepository;

    @Override
    public void executeUseCase(RequestCommand<EditClient> editClientRequestCommand) {
        EditClient command = editClientRequestCommand.getCommand();
        var client = new Client(command.ClientId(),command.ClientName(), command.ClientAdress(), command.ClientEmailAdress(), command.ClientTelephone());

        iClientDataRepository.save(clientTransform(client));

    }

    public ClientData clientTransform(Client client){
        ClientData clientData = new ClientData(client.Id(),client.ClientName().value(),client.ClientAdress().value(),client.ClientEmailAdress().value(),client.ClientTelephone().value());
        return clientData;
    }

    public static class Response implements UseCase.ResponseValues{

        private Client client;

        public Response(Client client){
            this.client = client;
        }

        public Client getClient(){
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }
    }
}
