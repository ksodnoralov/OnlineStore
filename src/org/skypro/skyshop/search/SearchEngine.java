package org.skypro.skyshop.search;

import org.skypro.skyshop.content.Searchable;

import java.util.*;

public class SearchEngine {

    private final Set<Searchable> searchables;
    private int count;

    public SearchEngine(int capacity) {
        this.searchables = new HashSet<>();
        this.count = 0;
    }

    // Метод добавления нового объекта для поиска
    public void add (Searchable item) {
        if (item == null) {
            System.out.println("Нельзя добавить null объект");
            return;
        }
        if (searchables.add(item)) {
            count++;
            System.out.println("Добавлен: " + item.getStringRepresentation());
        } else {
            System.out.println("Объект с именем '" + item.getName() + "' уже существует в поисковом движке");
        }
    }

    // Метод поиска
    public Set<Searchable> search(String query) {
        if (query == null || query.trim().isEmpty()) {
            System.out.println("Пустой запрос поиска");
            return new TreeSet<>(createComparator());
        }

        Set<Searchable> results = new TreeSet<>(createComparator());

        for (Searchable item : searchables) {
            String searchTerm = item.getSearchTerm();
            if (searchTerm != null && searchTerm.toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
                }
            }
        System.out.println("По запросу '" + query + "' найдено: " + results.size() + " результатов");
        return results;
        }

     // Метод для создания компаратора
     private Comparator<Searchable> createComparator() {
         return (o1, o2) -> {
             int lengthCompare = Integer.compare(o2.getName().length(), o1.getName().length());

             if (lengthCompare != 0) {
                 return lengthCompare;
             }

             return o1.getName().compareTo(o2.getName());
         };
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



