package org.skypro.skyshop.search;

public class BestResultNotFoundException extends Exception {
    public BestResultNotFoundException(String searchQuery) {
        super("Не найден результат для запроса - " + searchQuery);
    }
}
