package Ejercicio1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order {
    private final int id;
    private final List<CartItem> items;
    private final double subtotal;
    private final double discount;
    private final double shipping;
    private final double total;
    private final LocalDateTime date;

    public Order(int id, List<CartItem> items, double subtotal, double discount,
                 double shipping, double total, LocalDateTime date) {
        this.id = id;
        this.items = items;
        this.subtotal = subtotal;
        this.discount = discount;
        this.shipping = shipping;
        this.total = total;
        this.date = date;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Orden #%d - %s%n", id, date.format(fmt)));
        for (CartItem ci : items) {
            sb.append(String.format("  %dx %s - S/ %.2f%n",
                    ci.getQuantity(), ci.getProduct().getName(), ci.getTotal()));
        }
        sb.append(String.format("Subtotal: S/ %.2f%n", subtotal));
        sb.append(String.format("Descuento: -S/ %.2f%n", discount));
        sb.append(String.format("Envío: S/ %.2f%n", shipping));
        sb.append(String.format("TOTAL: S/ %.2f%n", total));
        return sb.toString();
    }
}


