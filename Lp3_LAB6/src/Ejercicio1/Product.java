package modelo;

public class Product {
    private final int id;
    private final String name;
    private final String description;
    private final double price;
    private final double weight;

    public Product(int id, String name, String description, double price, double weight) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public double getWeight() { return weight; }

    @Override
    public String toString() {
        return String.format("[%d] %s - %s | Precio: S/ %.2f | Peso: %.2fkg", 
                              id, name, description, price, weight);
    }
}

