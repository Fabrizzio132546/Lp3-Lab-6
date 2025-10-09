package Ejercicio1;
import java.time.LocalDateTime;
import java.util.*;

public class ShopController {
    private final ProductRepository repo;
    private final Cart cart;
    private final DiscountService discountService;
    private final ShippingService shippingService;
    private final ConsoleView view;
    private final List<Order> history = new ArrayList<>();
    private int nextOrderId = 1;
    private String appliedCode = null;

    public ShopController(ProductRepository repo, Cart cart, 
                          DiscountService discountService, ShippingService shippingService, 
                          ConsoleView view) {
        this.repo = repo;
        this.cart = cart;
        this.discountService = discountService;
        this.shippingService = shippingService;
        this.view = view;
    }

    public void start() {
        boolean running = true;
        while (running) {
            view.showMenu();
            int opt = view.readInt();
            switch (opt) {
                case 1 -> listarProductos();
                case 2 -> agregarProductoCatalogo();
                case 3 -> agregarProductoAlCarrito();
                case 4 -> verCarrito();
                case 5 -> eliminarProductoDelCarrito();
                case 6 -> aplicarDescuento();
                case 7 -> calcularEnvio();
                case 8 -> realizarCompra();
                case 9 -> verHistorial();
                case 0 -> running = false;
                default -> view.showMessage("Opción inválida.");
            }
        }
        view.showMessage("Gracias por usar la tienda. ¡Adiós!");
    }

    private void listarProductos() { view.showProducts(repo.getAll()); }

    private void agregarProductoCatalogo() {
        String nombre = view.readLine("Nombre producto: ");
        String desc = view.readLine("Descripción: ");
        System.out.println("Precio: ");
        double precio = view.readDouble();
        System.out.println("Peso: ");
        double peso = view.readDouble();
        Product p = repo.addProduct(nombre, desc, precio, peso);
        view.showMessage("Producto agregado: " + p);
    }

    private void agregarProductoAlCarrito() {
        view.showProducts(repo.getAll());
        int id = view.readInt();
        Product p = repo.getById(id);
        if (p == null) { view.showMessage("Producto no encontrado."); return; }
        int q = view.readInt();
        cart.addProduct(p, q);
        view.showMessage("Producto agregado al carrito.");
    }

    private void verCarrito() { view.showCart(cart); }

    private void eliminarProductoDelCarrito() {
        if (cart.isEmpty()) { view.showMessage("Carrito vacío."); return; }
        view.showCart(cart);
        int id = view.readInt();
        cart.removeProduct(id);
        view.showMessage("Producto eliminado si existía.");
    }

    private void aplicarDescuento() {
        view.showMessage("Códigos disponibles: " + discountService.availableCodes());
        String code = view.readLine("Código: ");
        double disc = discountService.applyDiscount(code, cart.getSubtotal());
        if (disc <= 0.0) {
            appliedCode = null;
            view.showMessage("Código inválido o sin efecto.");
        } else {
            appliedCode = code.toUpperCase();
            view.showMessage(String.format("Descuento aplicado: S/ %.2f", disc));
        }
    }

    private void calcularEnvio() {
        double shipping = shippingService.calculateShipping(cart.getSubtotal(), cart.getTotalWeight());
        view.showMessage(String.format("Costo envío: S/ %.2f", shipping));
    }

    private void realizarCompra() {
        if (cart.isEmpty()) { view.showMessage("Carrito vacío."); return; }
        double subtotal = cart.getSubtotal();
        double discount = discountService.applyDiscount(appliedCode, subtotal);
        double shipping = shippingService.calculateShipping(subtotal, cart.getTotalWeight());
        double total = subtotal - discount + shipping;
        List<CartItem> itemsCopy = new ArrayList<>();
        for (CartItem it : cart.getItems()) itemsCopy.add(new CartItem(it.getProduct(), it.getQuantity()));
        Order order = new Order(nextOrderId++, itemsCopy, subtotal, discount, shipping, total, LocalDateTime.now());
        history.add(order);
        cart.clear();
        appliedCode = null;
        view.showMessage("Compra realizada:\n" + order);
    }

    private void verHistorial() { view.showOrderHistory(history); }
}


