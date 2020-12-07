package ru.geekbrains.spring.repository;

import ru.geekbrains.spring.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void initProducts() {
        products = new ArrayList<>();
        products.add(new Product(0, "Intel Celeron", 2000));
        products.add(new Product(1, "Intel Pentium", 4000));
        products.add(new Product(2, "Intel Core i3 10100f", 7000));
        products.add(new Product(3, "Intel Core i5 10400f", 13000));
        products.add(new Product(4, "Intel Core i7 10700f", 26000));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProductById(int productId) {
        products.remove(productId);
    }

    public Product getProductById(int productId) {
        return products.get(productId);
    }
}
