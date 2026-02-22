public interface DiscountRules {
    public double discountAmount(String customerType, double subtotal, int distinctLines);
}
