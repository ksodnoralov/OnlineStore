package org.skypro.skyshop.content;

public interface Searchable {

    // Метод получения термина поиска //
    String getSearchTerm();

    // Метод получения типа контента //
    String getContentType();

    // Метод получения имени объекта //
    String getName();

    // Метод преобразования объекта в строку //
    default String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}
