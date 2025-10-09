package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items = new ArrayList<>();

    public void agregarItem(Producto p, int cantidad) {
        items.add(new ItemCarrito(p, cantidad));
    }

    public void eliminarItem(int id) {
        items.removeIf(i -> i.getProducto().getId() == id);
    }

    public List<ItemCarrito> getItems() { return items; }

    public double getTotal() {
        return items.stream().mapToDouble(ItemCarrito::getSubtotal).sum();
    }
}

