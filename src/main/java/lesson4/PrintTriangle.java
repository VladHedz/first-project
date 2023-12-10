package lesson4;

public class PrintTriangle {
    public static void main(String[] args) {
        int n = 13;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            int a = 1;
            while (a <= 2 * i - 1) {
                System.out.print("*");
                a++;
            }
            System.out.println();
        }
    }
}


