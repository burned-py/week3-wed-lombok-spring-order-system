package de.neuefische.hhjava231springordersystem;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ShopServiceTest {

    @Test
    void addOrder() {
        //GIVEN
        OrderRepository orderRepository = new OrderRepository();
        ShopService shopService = new ShopService(orderRepository);
        List<String> productIds = List.of("1");

        //WHEN
        Order actual = shopService.addOrder(productIds);

        //THEN
        Order expected = new Order("34c012ba-8824-4d54-ba37-924d66146043", List.of(new Product("1", "Apple")));
        assertEquals(expected, actual);
    }

    @Test
    void addOrder_whenInvalidId_thenThrowException() {
        //GIVEN
        OrderRepository orderRepository = new OrderRepository();
        ShopService shopService = new ShopService(orderRepository);
        List<String> productIds = List.of("3");

        //WHEN
        try {
            shopService.addOrder(productIds);

        //THEN
            fail();
        }
        catch (NoSuchElementException e) {

        }
    }
}
