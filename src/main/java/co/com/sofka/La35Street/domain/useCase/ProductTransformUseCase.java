package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.repository.IProductDataRepository;
import co.com.sofka.La35Street.repository.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTransformUseCase {

    @Autowired
    private IProductDataRepository iProductDataRepository;

    public ProductData productTransform(Product product){
        ProductData productData = new ProductData(product.Id(),product.Brand().value(),product.ProductName().value(),product.productPrice().value());
        return productData;
    }

    public Iterable<ProductData> list(){
        return iProductDataRepository.findAll();
    }

    public ProductData listId(String id){
        return iProductDataRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public String delete(String id){
        try {
            iProductDataRepository.deleteById(id);
            return "Se ha borrado con éxito";
        }catch (Exception e){
            return "No se ha borrado con éxito";
        }
    }

}
