package lesson3;

public class CurrencyConverter {
    private double commission;
    private double exchangeRate;

    public CurrencyConverter(double commission, double exchangeRate) {
        this.commission = commission;
        this.exchangeRate = exchangeRate;
    }

    private double convertUsdToUah(double amountUsd) {
        return amountUsd * exchangeRate;
    }

    private double calculateCommission(double amountUsd) {
        return amountUsd * commission / 100.0;
    }

    public double calculateTotalAmount(double amountUsd) {
        double amountUah = convertUsdToUah(amountUsd);
        double commissionAmount = calculateCommission(amountUah);
        return amountUah - commissionAmount;
    }
}
