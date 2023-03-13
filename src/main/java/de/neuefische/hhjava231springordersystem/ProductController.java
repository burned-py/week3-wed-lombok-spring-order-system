package de.neuefische.hhjava231springordersystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductController {
    private ShopService shopService = new ShopService();

    @GetMapping("products")
    public List<Product> getProducts() {
        return shopService.listProducts();
    }

    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable String id) {
        return shopService.getProduct(id);
    }

}
