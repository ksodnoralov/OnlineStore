package org.skypro.skyshop.search;

import org.skypro.skyshop.content.Searchable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    private final List<Searchable> searchables;
    private int count;

    public SearchEngine(int capacity) {
        this.searchables = new LinkedList<>();
        this.count = 0;
    }

    // Метод добавления нового объекта для поиска
    public void add (Searchable item) {
        if (item == null) {
            System.out.println("Нельзя добавить null объект");
            return;
        }
        searchables.add(item);
        count++;
        System.out.println("Добавлен: " + item.getStringRepresentation());
    }

    // Метод поиска
    public Map<String, Searchable> search(String query) {
        if (query == null || query.trim().isEmpty()) {
            System.out.println("Пустой запрос поиска");
            return new TreeMap<>();
        }

        Map<String, Searchable> results = new TreeMap<>();

        for (Searchable item : searchables) {
            String searchTerm = item.getSearchTerm();
            if (searchTerm != null && searchTerm.toLowerCase().contains(query.toLowerCase())) {
                results.put(item.getName(), item);
                }
            }
        System.out.println("По запросу '" + query + "' найдено: " + results.size() + " результатов");
        return results;
        }


    // Метод для получения количества добавленных элементов
    public int getCount() {

        return searchables.size();
    }

    // Метод для поиска наиболее подходящего объекта
    public Searchable findBestMatch(String search) throws BestResultNotFoundException {
        if (search == null || search.trim().isEmpty()) {
            throw new BestResultNotFoundException(search);
        }

        Searchable bestMatch = null;
        int maxCount = 0;
        String searchLower = search.toLowerCase();

        for (Searchable item : searchables) {
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



