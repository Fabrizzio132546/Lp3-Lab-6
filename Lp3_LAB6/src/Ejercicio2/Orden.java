package model;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    private Usuario usuario;
    private List<ItemCarrito> items;
    private double total;

    public Orden(Usuario usuario, List<ItemCarrito> items, double total) {
        this.usuario = usuario;
        this.items = new ArrayList<>(items);
        this.total = total;
    }

    public Usuario getUsuario() { return usuario; }
    public double getTotal() { return total; }
    public List<ItemCarrito> getItems() { return items; }
}
