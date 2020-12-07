package ru.geekbrains.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<Product> cartList;

    @Autowired
    private ProductRepository productRepository;

    public Cart(List<Product> cartList) {
        this.cartList = cartList;
    }

    public List<Product> getCartList() {
        return cartList;
    }

    @PostConstruct
    public void init() {
        cartList = new ArrayList<>();
    }

    public void addProductToCart(int productId) {
        cartList.add(productRepository.getProductById(productId));
    }

    public void deleteProductFromCart(int productInCartId) {
        cartList.remove(productInCartId);
    }

}
