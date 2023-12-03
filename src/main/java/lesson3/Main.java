package lesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amountUsd;

        while (true) {
            System.out.print("Введіть суму в доларах: ");
            if (scanner.hasNextDouble()) {
                amountUsd = scanner.nextDouble();
                if (amountUsd >= 0) {
                    break;
                } else {
                    System.out.println("Сумма повинна бути не менше нуля");
                }
            } else {
                System.out.println("Будь ласка використвуйте лише числа");
                scanner.next();
            }
        }

        CurrencyConverter converter = new CurrencyConverter(1.0, 36.55);

        double totalAmount = converter.calculateTotalAmount(amountUsd);

        System.out.printf("Сума до виплати в гривнях: %.2f", totalAmount);
    }
}
