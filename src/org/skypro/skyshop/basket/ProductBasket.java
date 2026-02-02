package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private List<Product> basket;
    private int count;

    public ProductBasket() {
        this.basket = new LinkedList<>();
        this.count = 0;
    }

    // Метод добавления продукта в корзину //
    public void addProduct(Product product) {
        basket.add(product);
        count++;
        System.out.println("Товар добавлен: " + product.getProductName());
    }

    // Метод удаления продукта по имени //
    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new LinkedList<>();

        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
                count--;
            }
        }
        return removedProducts;
    }

    // Метод получения стоимости корзины //
    public int getTotalPrice() {
        int total = 0;
        for (Product product : basket) {
            total = total + product.getProductPrice();
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

        for (Product product : basket) {
            System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Метод проверки по имени  //
    public boolean checkProductName(String productName) {
        for (Product product : basket) {
            if (product.getProductName().equals(productName)) {
                System.out.println("Товар найден");
                return true;
            }
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
        return basket.size();
    }

}
