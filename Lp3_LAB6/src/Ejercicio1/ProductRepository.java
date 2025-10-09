package Ejercicio1;
import java.util.*;

public class ProductRepository {
    private final Map<Integer, Product> products = new LinkedHashMap<>();
    private int nextId = 1;

    public ProductRepository() {
        addProduct("Auriculares Bluetooth", "Sonido estéreo, 20h batería", 120.00, 0.2);
        addProduct("Teclado mecánico", "Switches azules, retroiluminación", 250.50, 1.2);
        addProduct("Mouse óptico", "8000 DPI adjustable", 85.75, 0.15);
        addProduct("Monitor 24\"", "Full HD, 75Hz", 700.00, 4.5);
    }

    public Product addProduct(String name, String description, double price, double weight) {
        Product p = new Product(nextId++, name, description, price, weight);
        products.put(p.getId(), p);
        return p;
    }

    public Product getById(int id) { return products.get(id); }

    public Collection<Product> getAll() { return products.values(); }
}


