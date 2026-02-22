import java.util.*;

public class Calculate {
    public static double subtotal(List<OrderLine> lines, Map<String, MenuItem> menu){
        double subt = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subt += lineTotal;
        }
        return subt;
    }

    public static double taxPercent(TaxRules taxRules, String customerType){
        return taxRules.taxPercent(customerType);
    }

    public static double discount(DiscountRules discountRules, String customerType, double subtotal, int distinctLines){
        return discountRules.discountAmount(customerType, subtotal, distinctLines);
    }
}
