package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Client;
import co.com.sofka.La35Street.domain.Purchase.commands.EditClient;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;

public class EditClientUseCase extends UseCase<RequestCommand<EditClient>, EditPurchaseUseCase.Response> {

    @Override
    public void executeUseCase(RequestCommand<EditClient> editClientRequestCommand) {
        var command = editClientRequestCommand.getCommand();
        var client = new Client(command.ClientAdress(),command.ClientTelephone());

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
