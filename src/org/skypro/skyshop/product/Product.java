package org.skypro.skyshop.product;

import org.skypro.skyshop.content.Searchable;

public abstract class Product implements Searchable {

    private String productName;


    public Product (String productName) {
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
}
