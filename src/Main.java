import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

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
    }
}