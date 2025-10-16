package Ejercicio3;

import java.util.List;

public class InventarioVista {

    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("el inventario esta vacio.");
        } else {
            System.out.println("\n===== inventario =====");
            for (Item i : items) {
                System.out.println("- " + i.getNombre() + " (" + i.getTipo() + ") x" + i.getCantidad());
            }
        }
    }

    public void mostrarDetallesItem(Item i) {
        if (i != null) {
            System.out.println("\n=== detalles del item ===");
            System.out.println("nombre: " + i.getNombre());
            System.out.println("cantidad: " + i.getCantidad());
            System.out.println("tipo: " + i.getTipo());
            System.out.println("descripcion: " + i.getDescripcion());
        } else {
            System.out.println("el item no fue encontrado.");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
