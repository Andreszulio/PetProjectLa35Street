package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.repository.IPurchaseDataRepository;
import co.com.sofka.La35Street.repository.ProductData;
import co.com.sofka.La35Street.repository.PurchaseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseTransformUseCase {

    @Autowired
    private IPurchaseDataRepository iPurchaseDataRepository;

    @Autowired
    private ProductTransformUseCase productTransformUseCase;

    @Autowired
    private PurchaseTransformUseCase purchaseTransformUseCase;

    public Iterable<PurchaseData> list(){
        return iPurchaseDataRepository.findAll();
    }

    public PurchaseData listId(String id){
        PurchaseData purchaseData = iPurchaseDataRepository.findById(id).orElseThrow();
        return purchaseData;
    }

    public String delete(String id){
        try {
            Iterable<ProductData> productData = productTransformUseCase.findByPurchaseId(id);
            productTransformUseCase.delete(productData);
            iPurchaseDataRepository.deleteById(id);
            return "Se ha borrado con éxito tu compra";
        }catch (Exception e){
            return "No se ha borrado con éxito tu compra";
        }

    }

}
