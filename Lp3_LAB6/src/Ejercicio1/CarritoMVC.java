package menu;
import controller.ShopController;
import modelo.Cart;
import repositorio.ProductRepository;
import service.*;
import view.ConsoleView;

public class CarritoMVC {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();
        Cart cart = new Cart();
        DiscountService discountService = new DiscountService();
        ShippingService shippingService = new ShippingService();
        ConsoleView view = new ConsoleView();
        ShopController controller = new ShopController(repo, cart, discountService, shippingService, view);
        controller.start();
    }
}

