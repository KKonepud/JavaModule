package JavaModule;

public class ReplaceOddWithZero {

    // Потік для обробки одного рядка масиву:
    // замінює непарні елементи нулями
    static class RowProcessor extends Thread {
        private final int[][] matrix;
        private final int row;

        RowProcessor(int[][] matrix, int row) {
            this.matrix = matrix;
            this.row = row;
        }

        @Override
        public void run() {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] % 2 != 0) {
                    matrix[row][col] = 0;
                }
            }
            System.out.println("Потік " + row + " завершив обробку рядка " + row);
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.printf("%4d", row[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
            {1,  2,  3,  4,  5},
            {6,  7,  8,  9,  10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
        };

        System.out.println("До обробки:");
        printMatrix(matrix);

        // Запускаємо окремий потік для кожного рядка
        Thread[] threads = new Thread[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new RowProcessor(matrix, i);
            threads[i].start();
        }

        // Чекаємо завершення всіх потоків
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\nПісля обробки (непарні замінені на 0):");
        printMatrix(matrix);
    }
}
