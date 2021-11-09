package com.example.cat.services;

import com.example.cat.Creator.ProductCreator;
import com.example.cat.domain.Product;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceTests {

    @MockBean
    private ShoppingCartService shoppingCartService;

    @Test
    @Order(1)
    public void checkIfShoppingCartServiceIsNotNull() {
        initMocks(this);

        assertThat(shoppingCartService).isNotNull();
    }

    @Test
    @Order(2)
    public void addProductToCartTests(){
        Map<Product, Integer> cart = new LinkedHashMap<>();
        Product product = ProductCreator.createTestProduct();

        when(shoppingCartService.productsInCart()).thenReturn(cart);

        cart.put(product, 1);

        assertThat(shoppingCartService.productsInCart()).containsKey(product);
    }

    @Test
    @Order(3)
    public void addTwoTheSameProductsToCartTests(){
        Map<Product, Integer> cart = new LinkedHashMap<>();
        Product product = ProductCreator.createTestProduct();
        Product product2 = ProductCreator.createTestProduct();

        when(shoppingCartService.productsInCart()).thenReturn(cart);

        product.setName("Not Bad Trainers");
        product2.setName("Nice Shoes");

        cart.put(product, 1);
        cart.put(product2, 1);

        assertThat(shoppingCartService.productsInCart()).containsKey(product);
        assertThat(shoppingCartService.productsInCart()).containsKey(product2);
    }

    @Test
    @Order(4)
    public void removeProductFromCartTests(){
        Map<Product, Integer> cart = new LinkedHashMap<>();
        Product product = ProductCreator.createTestProduct();

        when(shoppingCartService.productsInCart()).thenReturn(cart);

        cart.put(product, 1);
        assertThat(shoppingCartService.productsInCart()).containsKey(product);

        cart.remove(product);
        assertThat(shoppingCartService.productsInCart()).doesNotContainKey(product);
    }
}

}
