package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.repository.ClientData;
import co.com.sofka.La35Street.repository.IClientDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientTransformUseCase {

    @Autowired
    private IClientDataRepository iClientDataRepository;

    public Iterable<ClientData> list(){
        return iClientDataRepository.findAll();
    }

    public ClientData listId(String id){
        ClientData clientData = iClientDataRepository.findById(id).orElseThrow();
        return clientData;
    }

}
