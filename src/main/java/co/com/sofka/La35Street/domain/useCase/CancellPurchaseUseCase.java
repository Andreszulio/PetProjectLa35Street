package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Purchase;
import co.com.sofka.La35Street.domain.Purchase.commands.CancellPurchase;
import co.com.sofka.La35Street.domain.Purchase.values.IsCancelled;
import co.com.sofka.La35Street.repository.IPurchaseRepository;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancellPurchaseUseCase extends UseCase<RequestCommand<CancellPurchase>, CancellPurchaseUseCase.Response >{

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Override
    public void executeUseCase(RequestCommand<CancellPurchase> cancellPurchaseRequestCommand) {
        var command = cancellPurchaseRequestCommand.getCommand();
        emit().onResponse(new Response(command.isCancelled()));
    }
    public static class Response implements UseCase.ResponseValues{

        private IsCancelled isCancelled;

        public Response(IsCancelled isCancelled){
            this.isCancelled = isCancelled;
        }
        public IsCancelled getIsCancelled(){
            return isCancelled;
        }

        public void setIsCancelled(IsCancelled isCancelled) {
            this.isCancelled = isCancelled;
        }
    }
}
