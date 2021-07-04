package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.commands.AddProduct;
import co.com.sofka.La35Street.repository.IProductDataRepository;
import co.com.sofka.La35Street.repository.ProductData;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, AddProductUseCase.Response> {

    @Autowired
    private IProductDataRepository iproductDataRepository;

    @Override
    public void executeUseCase(RequestCommand<AddProduct> AddProductRequestCommand) {
        AddProduct command = AddProductRequestCommand.getCommand();
        Product product = new Product(command.ProductId(), command.Brand(), command.ProductName(),command.ProductPrice(),command.PurchaseId());

        iproductDataRepository.save(productTransform(product));
        emit().onResponse(new Response(product));

    }

    public ProductData productTransform(Product product){
        ProductData productData = new ProductData(product.Id(),product.Brand().value(),product.ProductName().value(),product.productPrice().value(),product.PurchaseId().value());
        return productData;
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
