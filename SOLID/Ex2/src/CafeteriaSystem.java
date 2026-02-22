import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final FileStore store = new FileStore();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines, DiscountRules discountRules, TaxRules taxRules) {
        String invId = "INV-" + (++invoiceSeq);

        StringBuilder line_data = LineData.getLineData(lines, menu);

        double subtotal = Calculate.subtotal(lines, menu);
        double taxPct = Calculate.taxPercent(taxRules,customerType);
        double discount = Calculate.discount(discountRules,customerType, subtotal, lines.size());

        String printable = InvoiceFormatter.generate(invId,line_data,taxPct,subtotal,discount);
        
        store.save(invId, printable);
        Print.printSuccess(printable, invId, store);

        
    }
}
