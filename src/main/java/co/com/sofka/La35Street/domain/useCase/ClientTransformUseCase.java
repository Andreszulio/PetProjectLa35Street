package co.com.sofka.La35Street.domain.useCase;


import co.com.sofka.La35Street.domain.Purchase.Client;
import co.com.sofka.La35Street.repository.ClientData;
import co.com.sofka.La35Street.repository.IClientDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientTransformUseCase {

    @Autowired
    private IClientDataRepository iClientDataRepository;

    public ClientData clientTransform(Client client){
        ClientData clientData = new ClientData(client.Id(),client.ClientName().value(),client.ClientAdress().value(),client.ClientEmailAdress().value(),client.ClientTelephone().value());
        return clientData;
    }

    public Iterable<ClientData> list(){
        return iClientDataRepository.findAll();
    }

    public ClientData listId(String id){
        return iClientDataRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public String delete(String id){
        try {
            iClientDataRepository.deleteById(id);
            return "Se ha borrado con éxito";
        }catch (Exception e){
            return "No se ha borrado con éxito";
        }
    }

}
