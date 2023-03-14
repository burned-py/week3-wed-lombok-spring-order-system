package de.neuefische.hhjava231springordersystem;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderController {

    private final ShopService shopService;

    public OrderController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("orders")
    public List<Order> getOrders() {
        return shopService.listOrders();
    }

    @GetMapping("orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return shopService.getOrder(id);
    }

    @PostMapping("orders")
    public Order addOrder(@RequestBody List<String> productIds) {
        return shopService.addOrder(productIds);
    }

}


