public class InvoiceFormatter {
    // pointless wrapper (smell)
    public static String generate(String invId, StringBuilder lineData,double taxPct, double subtotal, double discount){
        double tax = subtotal * (taxPct / 100.0);
        double total = subtotal + tax - discount;
        
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");
        out.append(lineData);
        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f\n", total));
        return out.toString();
    }
}
