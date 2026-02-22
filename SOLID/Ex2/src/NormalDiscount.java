public class NormalDiscount implements DiscountRules {
    public double discountAmount(String customerType, double subtotal, int distinctLines) {
        double StandardDiscount = 0.0;
        double StudentLargeDiscount = 10.0;
        double StudentSmallDiscount = 0.0;
        double StudentThreshold = 180.0;
        double StaffLargeDiscount = 15.0;
        double StaffSmallDiscount = 5.0;
        double StaffThreshold = 180.0;
        if ("student".equalsIgnoreCase(customerType)) {
            if (subtotal >= StudentThreshold) return StudentLargeDiscount;
            return StudentSmallDiscount;
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            if (distinctLines >= StaffThreshold) return StaffLargeDiscount;
            return StaffSmallDiscount;
        }
        return StandardDiscount;
    }
}
