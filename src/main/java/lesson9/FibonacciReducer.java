package lesson9;

import java.util.stream.Stream;

public class FibonacciReducer {

    public static void main(String[] args) {
        int n = 9;

        long fibonacciNumber = calculateFibonacci(n);
        System.out.println("Fibonacci(" + n + ") = " + fibonacciNumber);
    }

    public static long calculateFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The Fibonacci number must be non-negative");
        }

        return Stream.iterate(new long[]{0, 1}, fib -> new long[]{fib[1], fib[0] + fib[1]})
                .limit(n + 1)
                .reduce((first, second) -> second)
                .orElseThrow()[1];
    }
}