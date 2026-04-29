package JavaModule;

public class SortArray {

    // Сортування вставками: проходимо по масиву,
    // кожен елемент "вставляємо" на правильне місце зліва
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Зсуваємо елементи, що більші за key, вправо
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {100, 83, 1, 0, 35, -10, 58};

        System.out.print("До сортування:   ");
        printArray(numbers);

        insertionSort(numbers);

        System.out.print("Після сортування: ");
        printArray(numbers);
    }
}
