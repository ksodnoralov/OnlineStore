package org.skypro.skyshop.article;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    String getName();

    // Метод преобразования объекта в строку //
    default String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}


