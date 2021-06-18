package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Client;
import co.com.sofka.La35Street.domain.Purchase.commands.AddClient;
import co.com.sofka.La35Street.domain.Purchase.events.AggregateClient;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class CreateClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddClient> CreateClientRequestCommand) {
        var command = CreateClientRequestCommand.getCommand();
        var client = new Client(command.ClientId(), command.ClientName(), command.ClientAdress(), command.ClientEmailAdress(), command.ClientTelephone());
        List<DomainEvent> events = new ArrayList<>();
        events.add(new AggregateClient(command.ClientId(), command.ClientName(), command.ClientAdress(), command.ClientEmailAdress(), command.ClientTelephone()));
        emit().onResponse(new ResponseEvents(events));
    }
}
