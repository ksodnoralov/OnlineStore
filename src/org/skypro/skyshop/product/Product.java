package org.skypro.skyshop.product;

import org.skypro.skyshop.content.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    private String productName;


    public Product (String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Ошибка. Название пустое");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();

    // Реализация методов интерфейса Searchable
    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return productName;
    }

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}
