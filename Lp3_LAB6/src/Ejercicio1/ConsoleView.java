package view;

import modelo.*;
import java.util.*;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n=== TIENDA MVC - MENÚ ===");
        System.out.println("1. Listar productos");
        System.out.println("2. Agregar producto al catálogo (admin)");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Ver carrito");
        System.out.println("5. Eliminar producto del carrito");
        System.out.println("6. Aplicar código de descuento");
        System.out.println("7. Calcular envío");
        System.out.println("8. Realizar compra");
        System.out.println("9. Ver historial");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public int readInt() {
        try { return Integer.parseInt(scanner.nextLine().trim()); }
        catch (Exception e) { return -1; }
    }

    public double readDouble() {
        try { return Double.parseDouble(scanner.nextLine().trim()); }
        catch (Exception e) { return -1; }
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public void showMessage(String msg) { System.out.println(msg); }

    public void showProducts(Collection<Product> products) {
        System.out.println("\n--- Productos disponibles ---");
        for (Product p : products) System.out.println(p);
    }

    public void showCart(Cart c) {
        System.out.println("\n--- Carrito ---");
        if (c.isEmpty()) { System.out.println("Carrito vacío."); return; }
        for (CartItem it : c.getItems()) {
            System.out.printf("%dx - %s | Unit: S/ %.2f | Total: S/ %.2f%n",
                    it.getQuantity(), it.getProduct().getName(),
                    it.getProduct().getPrice(), it.getTotal());
        }
        System.out.printf("Subtotal: S/ %.2f%n", c.getSubtotal());
    }

    public void showOrderHistory(List<Order> history) {
        System.out.println("\n=== Historial de Compras ===");
        if (history.isEmpty()) { System.out.println("No hay órdenes previas."); return; }
        for (Order o : history) System.out.println(o);
    }
}

