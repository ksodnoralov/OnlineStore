package org.skypro.skyshop.search;

import org.skypro.skyshop.content.Searchable;

public class SearchEngine {

    private final Searchable[] searchables;
    private int count;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.count = 0;
    }

    // Метод добавления нового объекта для поиска
    public void add (Searchable item) {
        if (item == null) {
            System.out.println("Нельзя добавить null объект");
            return;
        }

        if (count >= searchables.length) {
            System.out.println("Поисковый движок заполнен");
            return;
        }

        searchables[count] = item;
        count++;
        System.out.println("Добавлен: " + item.getStringRepresentation());
    }

    // Метод поиска
    public Searchable[] search(String query) {
        if (query == null || query.trim().isEmpty()) {
            System.out.println("Пустой запрос поиска");
            return new Searchable[0];
        }

        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        for (int i = 0; i < count; i++) {
            Searchable item = searchables[i];

            // Пропускаем null элементы
            if (item == null) {
                continue;
            }

            // Ищем в search term
            String searchTerm = item.getSearchTerm();
            if (searchTerm != null && searchTerm.toLowerCase().contains(query.toLowerCase())) {
                results[foundCount] = item;
                foundCount++;

                // Нашли 5 результатов - прекращаем поиск
                if (foundCount >= 5) {
                    break;
                }
            }
        }

        System.out.println("По запросу '" + query + "' найдено: " + foundCount + " результатов");
        return results;
    }

    // Метод для получения количества добавленных элементов
    public int getCount() {
        return count;
    }

    // Метод для поиска наиболее подходящего объекта
    public Searchable findBestMatch(String search) throws BestResultNotFoundException {
        if (search == null || search.trim().isEmpty()) {
            throw new BestResultNotFoundException(search);
        }

        Searchable bestMatch = null;
        int maxCount = 0;
        String searchLower = search.toLowerCase();

        for (int i = 0; i < count; i++) {
            Searchable item = searchables[i];
            if (item == null) {
                continue;
            }

            String searchTerm = item.getSearchTerm();
            if (searchTerm != null) {
                String termLower = searchTerm.toLowerCase();
                int countMatches = countSubstringOccurrences(termLower, searchLower);

                if (countMatches > maxCount) {
                    maxCount = countMatches;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFoundException(search);
        }

        return bestMatch;
    }

    //Вспомогательный метод
    private int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }

}



