package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.commands.AddClient;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateClientUseCaseTest {
    @Test
    void createAClient(){
        AddClient command = new AddClient(ClientId.of("678"), new ClientName("Andrés"), new ClientAdress("Calle 34 CC #89-28"), new ClientEmailAdress("andresanchez200319@gmail.com"), new ClientTelephone("3172185125"), new
                Rol("adasdsa"));

        CreateClientUseCase usecase = new CreateClientUseCase();
        Assertions.assertEquals("678", command.ClientId().value());
    }
}
