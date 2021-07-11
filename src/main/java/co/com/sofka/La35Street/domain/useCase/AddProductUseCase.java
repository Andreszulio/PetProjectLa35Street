package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.commands.AddProduct;
import co.com.sofka.La35Street.domain.Purchase.values.PurchasePrice;
import co.com.sofka.La35Street.repository.IProductDataRepository;
import co.com.sofka.La35Street.repository.IPurchaseDataRepository;
import co.com.sofka.La35Street.repository.ProductData;
import co.com.sofka.La35Street.repository.PurchaseData;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, AddProductUseCase.Response> {

    @Autowired
    private IProductDataRepository iproductDataRepository;

    @Autowired
    private IPurchaseDataRepository iPurchaseDataRepository;

    @Autowired
    private PurchaseTransformUseCase purchaseTransformUseCase;

    @Override
    public void executeUseCase(RequestCommand<AddProduct> AddProductRequestCommand) {

        AddProduct command = AddProductRequestCommand.getCommand();

        Product product = new Product(command.ProductId(), command.Brand(), command.ProductName(),command.ProductPrice(),command.PurchaseId(),command.image());

        modifyPurchase(command.PurchaseId().value(),product);

        iproductDataRepository.save(productTransform(product));
        emit().onResponse(new Response(product));

    }
    public void modifyPurchase(String id, Product product){
        PurchaseData purchaseData = findPurchaseData(id);

        List<ProductData> ProductList = purchaseData.Product();

        ProductList.add(productTransform(product));

        purchaseData.Product(ProductList);

        Integer price = purchaseData.PurchasePrice();
        price = price+product.productPrice().value();
        purchaseData.PurchasePrice(price);

        iPurchaseDataRepository.save(purchaseData);
    }

    public ProductData productTransform(Product product){
        ProductData productData = new ProductData(product.identity().value(),product.Brand().value(),product.ProductName().value(),product.productPrice().value(),product.PurchaseId().value(),product.image().value());
        return productData;
    }

    public PurchaseData findPurchaseData(String id){
        return purchaseTransformUseCase.listId(id);
    }

    public static class Response implements UseCase.ResponseValues{

        private Product product;

        public Response (Product product){
            this.product = product;
        }

        public Product getProduct(){
            return product;
        }

        public void setProduct(Product product){
            this.product = product;
        }

    }
}
