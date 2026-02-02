import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFoundException;
import org.skypro.skyshop.search.SearchEngine;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Попытка создания продуктов с невалидными данными//
        try {
            SimpleProduct invalid1 = new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании SimpleProduct: " + e.getMessage());
        }

        try {
            SimpleProduct invalid2 = new SimpleProduct("  ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании SimpleProduct: " + e.getMessage());
        }

        try {
            SimpleProduct invalid3 = new SimpleProduct("Товар", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании SimpleProduct: " + e.getMessage());
        }

        try {
            DiscountedProduct invalid4 = new DiscountedProduct("Товар", -100, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании DiscountedProduct: " + e.getMessage());
        }

        try {
            DiscountedProduct invalid5 = new DiscountedProduct("Товар", 100, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании DiscountedProduct: " + e.getMessage());
        }

        try {
            DiscountedProduct invalid6 = new DiscountedProduct("Товар", 100, 110);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании DiscountedProduct: " + e.getMessage());
        }


        // Попытка создания продуктов с валидными данными//
        SimpleProduct one = new SimpleProduct("Простой товар", 100);
        DiscountedProduct two = new DiscountedProduct("Товар со скидкой", 200, 20);
        FixPriceProduct three = new FixPriceProduct("Товар с фиксированной ценой");
        DiscountedProduct four = new DiscountedProduct("Товар со скидкой", 400, 30);
        SimpleProduct five = new SimpleProduct("Простой товар", 500);
        SimpleProduct six = new SimpleProduct("Six", 600);

        //Добавляем товар в корзину//
        ProductBasket basket = new ProductBasket();
        basket.addProduct(one);
        basket.addProduct(two);
        basket.addProduct(three);
        basket.addProduct(four);
        basket.addProduct(five);
        basket.addProduct(six);

        //Печатаем содержимое корзины//
        System.out.println("Содержимое корзины:");
        basket.printBasketInfo();

        //Проверяем наличие по имени//
        System.out.println("Проверка наличия по имени");
        basket.checkProductName("Товар со скидкой");
        basket.checkProductName(six.getProductName());

        //Печать общей стоимости//
        System.out.println("Печать общей стоимости");
        basket.getTotalPrice();

        //очистка корзины//
        System.out.println("Очистка корзины");
        basket.clearBasket();
        basket.printBasketInfo();


        SearchEngine searchEngine = new SearchEngine(10);
        // Добавляем продукты//
        searchEngine.add(one);
        searchEngine.add(two);
        searchEngine.add(three);
        searchEngine.add(four);
        searchEngine.add(five);

        // Создаем статьи
        Article article1 = new Article("Статья о простых товарах",
                "Простые товары не имеют скидок и фиксированных цен.");
        Article article2 = new Article("Все о скидках",
                "Товары со скидкой помогают экономить деньги.");
        Article article3 = new Article("Фиксированные цены",
                "Товары с фиксированной ценой всегда стоят одинаково.");

        // Добавляем статьи в поисковый движок
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        // Сценарий 1: объект найден
        try {
            System.out.println("Поиск 'товар':");
            Searchable bestMatch = searchEngine.findBestMatch("товар");
            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
            System.out.println("Search term: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Сценарий 2: объект с максимальным количеством повторений
        try {
            System.out.println("Поиск 'со скидкой':");
            Searchable bestMatch = searchEngine.findBestMatch("со скидкой");
            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
            System.out.println("Search term: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Сценарий 3: не найден (пустой поиск)
        try {
            System.out.println("Поиск пустой строки:");
            Searchable bestMatch = searchEngine.findBestMatch("");
            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Сценарий 4: не найден (несуществующий запрос)
        try {
            System.out.println("Поиск 'компьютер':");
            Searchable bestMatch = searchEngine.findBestMatch("компьютер");
            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Сценарий 5: поиск слова, которое встречается в статье несколько раз
        try {
            System.out.println("Поиск 'фиксированными':");
            Searchable bestMatch = searchEngine.findBestMatch("фиксированными");
            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
            System.out.println("Search term: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Обычный поиск//
        System.out.println("1. Поиск товара 'Товар со скидкой':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("Товар со скидкой")));

        System.out.println("2. Поиск по слову 'фиксированной':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("фиксированной")));

        System.out.println("3. Поиск статьи 'скидках':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("скидках")));

        System.out.println("4. Поиск по слову 'Six':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("Six")));

        System.out.println("5. Поиск несуществующего 'компьютер':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("компьютер")));

        // Демонстрация метода getStringRepresentation()
        System.out.println("6. Представление объектов:");
        System.out.println("Товар: " + one.getStringRepresentation());
        System.out.println("Статья: " + article1.getStringRepresentation());

        System.out.println("1. Поиск товара 'Товар со скидкой':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("Товар со скидкой")));

        System.out.println("2. Поиск по слову 'фиксированной':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("фиксированной")));

        System.out.println("3. Поиск статьи 'скидках':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("скидках")));

        System.out.println("4. Поиск по слову 'Six':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("Six")));

        System.out.println("5. Поиск несуществующего 'компьютер':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("компьютер")));

        // Демонстрация метода getStringRepresentation()
        System.out.println("6. Представление объектов:");
        System.out.println("Товар: " + one.getStringRepresentation());
        System.out.println("Статья: " + article1.getStringRepresentation());
    }
}
