package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.commands.AddProduct;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, CancellPurchaseUseCase.Response> {

    @Autowired
    //private IProductDataRepository iproductDataRepository;

    @Override
    public void executeUseCase(RequestCommand<AddProduct> AddProductRequestCommand) {
        AddProduct command = AddProductRequestCommand.getCommand();
        Product product = new Product(command.ProductId(), command.Brand(), command.ProductName(),command.ProductPrice());
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
