package ru.geekbrains.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> cartList;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getCartList() {
        return cartList;
    }

    @PostConstruct
    public void init() {
        cartList = new ArrayList<>();
    }

    public void addProductToCart(int productId) {
        cartList.add(productRepository.getProductById(productId));
        cartList.removeAll(Collections.singleton(null));
    }

    public void deleteProductFromCart(int productInCartId) {
        cartList.remove(productRepository.getProductById(productInCartId));
        cartList.removeAll(Collections.singleton(null));
    }

}
