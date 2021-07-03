package co.com.sofka.La35Street.domain.useCase;


import co.com.sofka.La35Street.domain.Purchase.Purchase;
import co.com.sofka.La35Street.repository.IPurchaseDataRepository;
import co.com.sofka.La35Street.repository.PurchaseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseTransformUseCase {

    @Autowired
    private IPurchaseDataRepository iPurchaseDataRepository;

    public PurchaseData purchaseTransform(Purchase purchase){
        PurchaseData purchaseData = new PurchaseData(purchase.Id(),purchase.PurchasePrice().value(),purchase.PurchaseDate().value(),purchase.ClientId().value(),purchase.Product(),purchase.Cancelled().value());
        return purchaseData;
    }

    public Iterable<PurchaseData> list(){
        return iPurchaseDataRepository.findAll();
    }

    public PurchaseData listId(String id){
        return iPurchaseDataRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public String delete(String id){

        try {
            iPurchaseDataRepository.deleteById(id);
            return "Se ha borrado con éxito";
        }catch (Exception e){
            return "No se ha borrado con éxito";
        }

    }

}
