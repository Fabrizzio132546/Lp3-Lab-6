package Ejercicio2;

import java.util.Arrays;
import java.util.List;

public class RepositorioProductos {
    private static List<Producto> productos = Arrays.asList(
        new Producto(1, "Laptop", 3500),
        new Producto(2, "Mouse", 50),
        new Producto(3, "Teclado", 120)
    );

    public static List<Producto> obtenerProductos() { return productos; }

    public static Producto buscarPorId(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}

