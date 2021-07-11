package co.com.sofka.La35Street.controller;

import co.com.sofka.La35Street.domain.Purchase.commands.AddProduct;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.La35Street.domain.useCase.AddProductUseCase;
import co.com.sofka.La35Street.domain.useCase.ProductTransformUseCase;
import co.com.sofka.La35Street.repository.ProductData;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AddProductController {

    @Autowired
    private AddProductUseCase addProductUseCase;

    @Autowired
    private ProductTransformUseCase productTransformUseCase;

    @PostMapping(value = "api/saveProduct/{productId}/{brand}/{productPrice}/{productName}/{purchaseId}")
    public String save(@PathVariable("productId") String productId,
                       @PathVariable("brand") String brand,
                       @PathVariable("productPrice") Integer productPrice,
                       @PathVariable("productName") String productName,
                       @PathVariable("purchaseId") String purchaseId,
                       @RequestBody String image) {
        AddProduct command = new AddProduct(ProductId.of(productId), new Brand(brand), new ProductPrice(productPrice), new ProductName(productName), PurchaseId.of(purchaseId), new Image(image));
        System.out.println(image);
        AddProductUseCase.Response productAdded = executedUseCase(command);

        String string = "{"
                + "\"productId\":" + "\"" + productAdded.getProduct().identity().value() + "\"" + ","
                + "\"brand\":" + "\"" + productAdded.getProduct().Brand().value() + "\"" + ","
                + "\"productPrice\":" + "\"" + productAdded.getProduct().productPrice().value() + "\"" + ","
                + "\"productName\":" + "\"" + productAdded.getProduct().ProductName().value()+ "\"" + ","
                + "\"purchaseId\":" + "\"" + productAdded.getProduct().PurchaseId().value()+ "\"" + ","
                + "\"image\":"+ "\"" + productAdded.getProduct().image().value() + "\""
                + "}";
        return string;
    }

    private AddProductUseCase.Response executedUseCase(AddProduct command){
        AddProductUseCase.Response events = UseCaseHandler.getInstance()
                .syncExecutor(addProductUseCase, new RequestCommand<>(command))
                .orElseThrow();
        AddProductUseCase.Response ProductAdded = events;
        return ProductAdded;
    }

    @GetMapping(value = "api/findProduct")
    public String listProduct(){
        Iterable<ProductData> products = productTransformUseCase.list();
        String string = "{";
        for (ProductData product: products){
            string = string + "{"
                    + "\"productId\":" + "\"" + product.Id()+ "\"" + ","
                    + "\"productName\":" + "\"" + product.ProductName()+ "\"" + ","
                    + "\"brand\":" + "\"" + product.Brand() + "\"" + ","
                    + "\"productPrice\":" + "\"" + product.ProductPrice()+ "\"" + ","
                    + "\"purchaseId\":"+ "\"" + product.PurchaseId() + "\""+ ","
                    + "\"image\":"+ "\"" + product.Image() + "\""
                    + "}"+", \n  \n"+"\t";
        }
        string = string + "}";
        return  string;
    }

    @GetMapping(value = "api/findProduct/{id}")
    public String listIdProduct(@PathVariable("id") String id){
        ProductData product = productTransformUseCase.listId(id);
        String string = "{"
                + "\"productId\":" + "\"" + product.Id() + "\"" + ","
                + "\"productName\":" + "\"" + product.ProductName()+ "\"" + ","
                + "\"brand\":" + "\"" + product.Brand() + "\"" + ","
                + "\"productPrice\":" + "\"" + product.ProductPrice()+ "\"" + ","
                + "\"purchaseId\":"+ "\"" + product.PurchaseId() + "\""
                + "\"image\":"+ "\"" + product.Image() + "\""
                + "}";
        return string;
    }

}
