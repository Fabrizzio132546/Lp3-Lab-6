package service;

import java.util.*;

public class DiscountService {
    private final Map<String, Double> codes = new HashMap<>();

    public DiscountService() {
        codes.put("PROMO10", 0.10);
        codes.put("PROMO20", 0.20);
        codes.put("ALUMNO5", 0.05);
    }

    public double applyDiscount(String code, double subtotal) {
        if (code == null) return 0.0;
        Double pct = codes.get(code.toUpperCase());
        if (pct == null) return 0.0;
        return subtotal * pct;
    }

    public Set<String> availableCodes() { return codes.keySet(); }
}

