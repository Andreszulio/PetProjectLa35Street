package co.com.sofka.La35Street.controller;

import co.com.sofka.La35Street.domain.Purchase.Client;
import co.com.sofka.La35Street.domain.Purchase.commands.AddClient;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.La35Street.domain.useCase.*;
import co.com.sofka.La35Street.repository.ClientData;
import co.com.sofka.La35Street.repository.PurchaseData;
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
    private ClientTransformUseCase clientTransformUseCase;

    @PostMapping(value = "api/saveClient/{clientId}/{clientName}/{clientAddress}/{clientEmailAddress}/{clientTelephone}/{rol}")
    public String save(@PathVariable("clientId")String clientId,
                       @PathVariable("clientName")String clientName,
                       @PathVariable("clientAddress")String clientAddress,
                       @PathVariable("clientEmailAddress")String clientEmailAddress,
                       @PathVariable("clientTelephone")String clientTelephone,
                       @PathVariable("rol") String rol){
        AddClient command = new AddClient(ClientId.of(clientId),new ClientName(clientName),new ClientAdress(clientAddress),new ClientEmailAdress(clientEmailAddress),new ClientTelephone(clientTelephone), new Rol(rol));

        CreateClientUseCase.Response clientCreated = executedUseCase(command);

        String string = "{"
                + "\"clientId\":" + "\"" + clientCreated.getClient().identity().value() + "\"" + ","
                + "\"clientName\":" + "\"" + clientCreated.getClient().ClientName().value()+ "\"" + ","
                + "\"clientAdress\":" + "\"" + clientCreated.getClient().ClientAdress().value()+ "\"" + ","
                + "\"clientEmailAdress\":" + "\"" + clientCreated.getClient().ClientEmailAdress().value()+ "\"" + ","
                + "\"clientTelephone\":" + "\"" + clientCreated.getClient().ClientTelephone().value()+ "\"" + ","
                + "\"rol\":" + "\"" + clientCreated.getClient().rol().value()+ "\""
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

    @GetMapping(value = "api/findClient")
    public String listClient(){
        Iterable<ClientData> clients = clientTransformUseCase.list();
        String string = "{";
        for (ClientData client: clients){
            string = string + "{"
                    + "\"clientId\":" + "\"" + client.Id() + "\"" + ","
                    + "\"clientName\":" + "\"" + client.ClientName()+ "\"" + ","
                    + "\"clientEmail\":" + "\"" + client.ClientEmailAdress() + "\"" + ","
                    + "\"clientTelephone\":" + "\"" + client.ClientTelephone()+ "\"" + ","
                    + "\"clientAddress\":"+ "\"" + client.ClientAdress() + "\"" + ","
                    + "\"rol\":" + "\"" + client.Rol()+ "\""
                    + "}"+", \n  \n"+"\t";
        }
        string = string + "}";
        return  string;
    }

    @GetMapping(value = "api/findClient/{id}")
    public String listIdClient(@PathVariable("id") String id){
        ClientData client = clientTransformUseCase.listId(id);
        String string = "{"
                + "\"clientId\":" + "\"" + client.Id() + "\"" + ","
                + "\"clientName\":" + "\"" + client.ClientName()+ "\"" + ","
                + "\"clientEmail\":" + "\"" + client.ClientEmailAdress() + "\"" + ","
                + "\"clientTelephone\":" + "\"" + client.ClientTelephone()+ "\"" + ","
                + "\"clientAddress\":"+ "\"" + client.ClientAdress() + "\"" + ","
                + "\"rol\":" + "\"" + client.Rol()+ "\""
                + "}";
        return string;
    }

}
