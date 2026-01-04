import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        Product one = new Product("One", 100);
        Product two = new Product("Two", 200);
        Product three = new Product("Three", 300);
        Product four = new Product("Four", 400);
        Product five = new Product("Five", 500);
        Product six = new Product("Six", 600);

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
        basket.checkProductName(five.getProductName());
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