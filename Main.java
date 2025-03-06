
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int n = sc.nextInt();
        int[][] array = new int[n][n]; // Создаем двумерный массив

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt(); // Читаем элементы массива
            }
        }

        sortArray(array); // Сортируем побочную диагональ
        System.out.println("Массив после сортировки побочной диагонали:");
        printArray(array); // Выводим отсортированный массив
    }

    public static void sortArray(int[][] array) {
        int n = array.length;

        // Собираем элементы побочной диагонали в массив
        int[] diagonal = new int[n];
        for (int i = 0; i < n; i++) {
            diagonal[i] = array[i][n - 1 - i];
        }

        // Сортировка методом расчёски
        combSort(diagonal);

        // Возвращаем отсортированные элементы на побочную диагональ
        for (int i = 0; i < n; i++) {
            array[i][n - 1 - i] = diagonal[i];
        }
    }

    // Метод сортировки расчёской
    public static void combSort(int[] arr) {
        int gap = arr.length;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            // Уменьшаем значение gap
            gap = (gap * 10) / 13;
            if (gap < 1) {
                gap = 1;
            }

            swapped = false;

            // Сравниваем элементы с текущим gap
            for (int i = 0; i + gap < arr.length; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}
