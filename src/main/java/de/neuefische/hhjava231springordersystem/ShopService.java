package de.neuefische.hhjava231springordersystem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class ShopService {

    private ProductRepository productRepository;
    private OrderRepository orderRepository = new OrderRepository();

    public ShopService() {
        productRepository = new ProductRepository();
    }

    public List<Product> listProducts() {
        return productRepository.list();
    }

    public Product getProduct(String id) {
        return productRepository.get(id);
    }

    public List<Order> listOrders() {
        return orderRepository.list();
    }

    public Order getOrder(String id) {
        return orderRepository.get(id);
    }

    public Order addOrder(List<String> productIds) {
        List<Product> allProducts = new ArrayList<>();

        for (String productId : productIds) {
            Product product = productRepository.get(productId);

            if (product == null) {
                throw new NoSuchElementException("Product with Id: " + productId + " not found!");
            }

            allProducts.add(product);
        }

        Order order = new Order(UUID.randomUUID().toString(), allProducts);
        return orderRepository.add(order);
    }
}
