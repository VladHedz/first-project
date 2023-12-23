import java.util.Objects;
import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменник не може бути рівний 0.");
        }

        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private void simplify() {
        int gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Fraction other = (Fraction) obj;

        return this.numerator * other.denominator == this.denominator * other.numerator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fraction fraction1 = readFraction(scanner, "перший");

        Fraction fraction2 = readFraction(scanner, "другий");

        boolean result = fraction1.equals(fraction2);
        System.out.println("Результат порівняння: " + result);
    }

    private static Fraction readFraction(Scanner scanner, String order) {
        boolean isValidInput = false;
        Fraction result = null;

        do {
            try {
                System.out.println("Введіть " + order + " дріб у форматі 'чисельник/знаменник':");
                String input = scanner.nextLine();
                String[] parts = input.split("/");

                if (parts.length != 2) {
                    throw new IllegalArgumentException("Введіть дріб у правильному форматі.");
                }

                int numerator = Integer.parseInt(parts[0]);
                int denominator = Integer.parseInt(parts[1]);

                if (denominator <= 0) {
                    throw new IllegalArgumentException("Знаменник повинен бути більше 0.");
                }

                result = new Fraction(numerator, denominator);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Помилка: Введіть цілі числа для чисельника та знаменника.");
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        } while (!isValidInput);

        return result;
    }
}