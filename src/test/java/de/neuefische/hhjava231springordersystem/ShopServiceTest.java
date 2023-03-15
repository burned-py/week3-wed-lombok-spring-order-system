package de.neuefische.hhjava231springordersystem;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class ShopServiceTest {

    OrderRepository orderRepository = mock(OrderRepository.class);
    ProductRepository productRepository = mock(ProductRepository.class);
    IdService idService = mock(IdService.class);
    ShopService shopService = new ShopService(productRepository, orderRepository, idService);

    @Test
    void addOrder() {
        //GIVEN
        List<String> productIds = List.of("1");

        when(productRepository.get("1"))
                .thenReturn(new Product("1", "Apple"));
        when(orderRepository.add(new Order("randomId", List.of(new Product("1", "Apple")))))
                .thenReturn(new Order("randomId", List.of(new Product("1", "Apple"))));
        when(idService.generateId())
                .thenReturn("randomId");

        //WHEN
        Order actual = shopService.addOrder(productIds);

        //THEN
        Order expected = new Order("randomId", List.of(new Product("1", "Apple")));


        verify(productRepository).get("1");
        verify(orderRepository).add(new Order("randomId", List.of(new Product("1", "Apple"))));
        verify(idService).generateId();
        assertEquals(expected, actual);
    }

    @Test
    void addOrder_whenInvalidId_thenThrowException() {
        //GIVEN
        when(productRepository.get("3"))
                .thenReturn(null);

        List<String> productIds = List.of("3");

        //WHEN
        try {
            shopService.addOrder(productIds);

        //THEN
            fail();
        }
        catch (NoSuchElementException e) {

        }
        verify(productRepository).get("3");
    }

    @Test
    void listProducts() {
        //GIVEN
        List<Product> products = List.of(new Product("1", "Apple"));
        when(productRepository.list()).thenReturn(products);

        //WHEN

        List<Product> actual = shopService.listProducts();

        //THEN
        List<Product> expected = List.of(new Product("1", "Apple"));

        verify(productRepository).list();
        assertEquals(expected, actual);
    }
}
