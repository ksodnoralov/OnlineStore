package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] basket;
    private int count;

    public ProductBasket() {
        this.basket = new Product[5];
        this.count = 0;
    }

    // Метод добавления продукта в корзину //
    public void addProduct(Product product) {
        if (count >= basket.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        basket[count] = product;
        count++;
    }

    // Метод получения стоимости корзины //
    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total = total + basket[i].getProductPrice();
        }
        System.out.println("Стоимость корзины: " + total);
        return total;
    }

    // Метод печати содержимого корзины //
    public void printBasketInfo() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;

        for (int i = 0; i < count; i++) {
            Product product = basket[i];
            System.out.println(product.toString());
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Метод проверки по имени  //
    public boolean checkProductName(String productName) {
        for (int i = 0; i < count; i++) {
            if (basket[i].getProductName().equals(productName)) {
                System.out.println("Товар найден");
                return true;
            }
        }
        System.out.println("Товар не найден");
        return false;
    }

    // Метод очистки корзины //
    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            basket[i] = null;
        }
        count = 0;
        System.out.println("Корзина пуста");
    }
    

}
