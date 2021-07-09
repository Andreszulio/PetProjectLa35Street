package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.repository.IProductDataRepository;
import co.com.sofka.La35Street.repository.IPurchaseDataRepository;
import co.com.sofka.La35Street.repository.ProductData;
import co.com.sofka.La35Street.repository.PurchaseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTransformUseCase {

    @Autowired
    private PurchaseTransformUseCase purchaseTransformUseCase;

    @Autowired
    private IProductDataRepository iProductDataRepository;

    @Autowired
    private IPurchaseDataRepository iPurchaseDataRepository;

    public Iterable<ProductData> findByPurchaseId(String id){
        return iProductDataRepository.findByPurchaseId(id);
    }

    public Iterable<ProductData> list(){
        return iProductDataRepository.findAll();
    }

    public ProductData listId(String id) {
        ProductData productData = iProductDataRepository.findById(id).orElseThrow();
        return productData;
    }

    public String delete(String id){
        try {
            iProductDataRepository.deleteById(id);
            return "Se ha borrado con éxito el producto de tu compra";
        }catch (Exception e){
            return "No se ha borrado con éxito el producto de tu compra";
        }
    }
    public void findProducts(String id){
        ProductData productData = iProductDataRepository.findById(id).orElseThrow();
        PurchaseData purchaseData = purchaseTransformUseCase.listId(productData.PurchaseId());
        List<ProductData> products = purchaseData.Product();

        for (ProductData temp: products){
            if (temp.Id().equals(id)){
                deleteProductOfPurchase(purchaseData, temp, products);
            }
        }
    }
    public void deleteProductOfPurchase(PurchaseData purchaseData, ProductData temp, List<ProductData> products){
        products.remove(temp);
        purchaseData.Product(products);
        iPurchaseDataRepository.save(purchaseData);
    }
}
