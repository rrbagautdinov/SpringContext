package ru.geekbrains.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.repository.Cart;

import java.util.Scanner;

@Component
public class CartController {
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    private Cart cart;

    public void cartControllerLogic() {
        while (true) {
            System.out.println("Введите команду для управления корзиной:");
            String in = scanner.nextLine();
            switch (in) {
                case "add":
                    System.out.println("Введите идентификатор товара для добавления в корзину");
                    String valueAdd = scanner.nextLine();
                    cart.addProductToCart(Integer.parseInt(valueAdd));
                    System.out.println("Ваша корзина:" + "\n" + cart.getCartList() + "\n");
                    break;
                case "delete":
                    System.out.println("Введите идентификатор товара для удаления из корзины");
                    String valueDelete = scanner.nextLine();
                    cart.deleteProductFromCart(Integer.parseInt(valueDelete));
                    System.out.println("Ваша корзина:" + "\n" + cart.getCartList()+ "\n");
                    break;
                case "exit":
                    scanner.close();
                    return;
            }
        }
    }
}
