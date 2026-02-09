package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private Map<String, List<Product>> basket;
    private int count;

    public ProductBasket() {
        this.basket = new HashMap<>();
        this.count = 0;
    }

    // Метод добавления продукта в корзину //
    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getProductName(), k -> new ArrayList<>())
                .add(product);
        count++;
        System.out.println("Товар добавлен: " + product.getProductName());
    }

    // Метод удаления продукта по имени //
    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = basket.remove(name);

        if (removedProducts != null) {
            count -= removedProducts.size();
            return removedProducts;
        }
        return new ArrayList<>();
    }

    // Метод получения стоимости корзины //
    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                total = total + product.getProductPrice();
            }
        }
        System.out.println("Стоимость корзины: " + total);
        return total;
    }

    // Метод печати содержимого корзины //
    public void printBasketInfo() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;

        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Метод проверки по имени  //
    public boolean checkProductName(String productName) {

        if (basket.containsKey(productName)) {
                System.out.println("Товар найден");
                return true;

        }
        System.out.println("Товар не найден");
        return false;
    }

    // Метод очистки корзины //
    public void clearBasket() {
        basket.clear();
        count = 0;
        System.out.println("Корзина пуста");
    }

    // Геттер для количества продуктов //
    public int getCount() {
        return count;
    }
}
