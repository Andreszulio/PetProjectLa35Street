package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Client;
import co.com.sofka.La35Street.domain.Purchase.commands.AddClient;
import co.com.sofka.La35Street.domain.Purchase.events.AggregateClient;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class CreateClientUseCase extends UseCase<RequestCommand<AddClient>, CancellPurchaseUseCase.Response> {

    @Override
    public void executeUseCase(RequestCommand<AddClient> CreateClientRequestCommand) {
        AddClient command = CreateClientRequestCommand.getCommand();
        Client client = new Client(command.ClientId(), command.ClientName(), command.ClientAdress(), command.ClientEmailAdress(), command.ClientTelephone());
    }
    public static class Response implements UseCase.ResponseValues{

        private Client client;

        public Response(Client client){
            this.client = client;
        }

        public Client getClient(){
            return client;
        }

        public void setClient(Client client){
            this.client = client;
        }
    }
}

