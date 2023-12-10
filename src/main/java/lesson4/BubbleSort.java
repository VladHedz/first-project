package lesson4;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {31, 432, 3, 42, 51, 999, -1};

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("Результат сортування методом бульбашки:");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}

