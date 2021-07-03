package co.com.sofka.La35Street.controller;

import co.com.sofka.La35Street.domain.Purchase.Client;
import co.com.sofka.La35Street.domain.Purchase.commands.AddClient;
import co.com.sofka.La35Street.domain.Purchase.commands.EditClient;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.La35Street.domain.useCase.*;
import co.com.sofka.La35Street.repository.ClientData;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CreateClientController {

    @Autowired
    private CreateClientUseCase createClientUseCase;

    @Autowired
    private EditClientUseCase editClientUseCase;

    @Autowired
    private ClientTransformUseCase clientTransformUseCase;

    @PostMapping(value = "api/save/{clientId}/{clientName}/{clientAdress}/{clientEmailAdress}/{clientTelephone}")
    public String save(@PathVariable("clientId")String clientId,
                       @PathVariable("clientName")String clientName,
                       @PathVariable("clientAdress")String clientAdress,
                       @PathVariable("clientEmailAdress")String clientEmailAdress,
                       @PathVariable("clientTelephone")String clientTelephone){
        Client client = new Client(ClientId.of(clientId),new ClientName(clientName),new ClientAdress(clientAdress),new ClientEmailAdress(clientEmailAdress),new ClientTelephone(clientTelephone));

        AddClient command = new AddClient(ClientId.of(clientId),new ClientName(clientName),new ClientAdress(clientAdress),new ClientEmailAdress(clientEmailAdress),new ClientTelephone(clientTelephone));

        CreateClientUseCase.Response clientCreated = executedUseCase(command);

        String string = "{"
                + "\"clientId\":" + "\"" + clientCreated.getClient().Id() + "\"" + ","
                + "\"clientName\":" + "\"" + clientCreated.getClient().ClientName().value()+ "\"" + ","
                + "\"clientAdress\":" + "\"" + clientCreated.getClient().ClientAdress().value()+ "\"" + ","
                + "\"clientEmailAdress\":" + "\"" + clientCreated.getClient().ClientEmailAdress().value()+ "\"" + ","
                + "\"clientTelephone\":" + "\"" + clientCreated.getClient().ClientTelephone().value()+ "\"" + ","
                +"}";

        return string;
    }

    private CreateClientUseCase.Response executedUseCase(AddClient command){
        CreateClientUseCase.Response events = UseCaseHandler.getInstance()
                .syncExecutor(createClientUseCase, new RequestCommand<>(command))
                .orElseThrow();
        CreateClientUseCase.Response ClientCreated = events;
        return ClientCreated;
    }

    @PutMapping(value = "api/edit/{clientId}/{clientName}/{clientAdress}/{clientEmailAdress}/{clientTelephone}")
    public String edit(@PathVariable("clientId")String clientId,
                       @PathVariable("clientName")String clientName,
                       @PathVariable("clientAdress")String clientAdress,
                       @PathVariable("clientEmailAdress")String clientEmailAdress,
                       @PathVariable("clientTelephone")String clientTelephone){
        Client client = new Client(ClientId.of(clientId),new ClientName(clientName),new ClientAdress(clientAdress),new ClientEmailAdress(clientEmailAdress),new ClientTelephone(clientTelephone));

        EditClient command = new EditClient(ClientId.of(clientId),new ClientName(clientName),new ClientAdress(clientAdress),new ClientEmailAdress(clientEmailAdress),new ClientTelephone(clientTelephone));

        EditClientUseCase.Response clientEdited = executedClientEditedUseCase(command);

        String string = "{"
                + "\"clientId\":" + "\"" + clientEdited.getClient().Id() + "\"" + ","
                + "\"clientName\":" + "\"" + clientEdited.getClient().ClientName().value()+ "\"" + ","
                + "\"clientAdress\":" + "\"" + clientEdited.getClient().ClientAdress().value()+ "\"" + ","
                + "\"clientEmailAdress\":" + "\"" + clientEdited.getClient().ClientEmailAdress().value()+ "\"" + ","
                + "\"clientTelephone\":" + "\"" + clientEdited.getClient().ClientTelephone().value()+ "\"" + ","
                +"}";

        return string;
    }

    private EditClientUseCase.Response executedClientEditedUseCase(EditClient command){
        EditClientUseCase.Response events = UseCaseHandler.getInstance()
                .syncExecutor(editClientUseCase, new RequestCommand<>(command))
                .orElseThrow();
        EditClientUseCase.Response ClientEdited = events;
        return ClientEdited;
    }

    @GetMapping(value = "api/findClient")
    public Iterable<ClientData> list(){
        return clientTransformUseCase.list();
    }

    @GetMapping(value = "api/findClient/{clientId}")
    public ClientData listId(@PathVariable("clientId") String id){
        return clientTransformUseCase.listId(id);
    }

    @DeleteMapping(value = "api/delete/{clientId}")
    public String delete(@PathVariable("clientId") String id){
        return clientTransformUseCase.delete(id);
    }

}
