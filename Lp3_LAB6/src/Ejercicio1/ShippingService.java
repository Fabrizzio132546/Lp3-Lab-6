package Ejercicio1;

public class ShippingService {
    public double calculateShipping(double subtotal, double totalWeight) {
        if (subtotal >= 1000.0) return 0.0;
        double base = 15.0;
        double weightSurcharge = Math.ceil(totalWeight) * 3.0;
        return base + weightSurcharge;
    }
}


