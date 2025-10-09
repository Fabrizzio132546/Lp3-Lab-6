package Ejercicio1;
import java.util.*;

public class Cart {
    private final Map<Integer, CartItem> items = new LinkedHashMap<>();

    public void addProduct(Product p, int qty) {
        if (items.containsKey(p.getId())) {
            CartItem it = items.get(p.getId());
            it.setQuantity(it.getQuantity() + qty);
        } else {
            items.put(p.getId(), new CartItem(p, qty));
        }
    }

    public void removeProduct(int productId) {
        items.remove(productId);
    }

    public Collection<CartItem> getItems() { return items.values(); }

    public double getSubtotal() {
        return items.values().stream().mapToDouble(CartItem::getTotal).sum();
    }

    public double getTotalWeight() {
        return items.values().stream()
                .mapToDouble(it -> it.getProduct().getWeight() * it.getQuantity())
                .sum();
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public void clear() { items.clear(); }
}


