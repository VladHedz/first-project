package lesson4;

import java.util.Arrays;

public class ArraysSort {
    public static void main(String[] args) {
        int[] array = {31, 432, 3, 42, 51, 999, -1};

        Arrays.sort(array);

        System.out.println("Результат сортування методом arrays:");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}

