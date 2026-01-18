import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        SimpleProduct one = new SimpleProduct("Простой товар", 100);
        DiscountedProduct two = new DiscountedProduct("Товар со скидкой", 200, 20);
        FixPriceProduct three = new FixPriceProduct("Товар с фиксированной ценой");
        DiscountedProduct four = new DiscountedProduct("Товар со скидкой", 400, 30);
        SimpleProduct five = new SimpleProduct("Простой товар", 500);
        SimpleProduct six = new SimpleProduct("Six", 600);

        //Добавляем товар в корзину//
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

    // Создаем поисковый движок
    SearchEngine searchEngine = new SearchEngine(10);

    // Добавляем товары в поисковый движок
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

        System.out.println("\n1. Поиск товара 'Товар со скидкой':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("Товар со скидкой")));

        System.out.println("\n2. Поиск по слову 'фиксированной':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("фиксированной")));

        System.out.println("\n3. Поиск статьи 'скидках':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("скидках")));

        System.out.println("\n4. Поиск по слову 'Six':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("Six")));

        System.out.println("\n5. Поиск несуществующего 'компьютер':");
        System.out.println("Результаты: " + Arrays.toString(searchEngine.search("компьютер")));

    // Демонстрация метода getStringRepresentation()
        System.out.println("\n6. Представление объектов:");
        System.out.println("Товар: " + one.getStringRepresentation());
        System.out.println("Статья: " + article1.getStringRepresentation());
}
}
