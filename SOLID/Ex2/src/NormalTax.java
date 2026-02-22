public class NormalTax implements TaxRules {
    public double taxPercent (String customerType) {
        double StudentTax = 5.0;
        double StaffTax = 2.0;
        double StandardTax = 8.0;
        if ("student".equalsIgnoreCase(customerType)) return StudentTax;
        if ("staff".equalsIgnoreCase(customerType)) return StaffTax;
        return StandardTax;
    }
}
