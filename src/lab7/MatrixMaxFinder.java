public class MatrixMaxFinder {
    private static int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    private static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new Thread(new MatrixMaxFinderRunnable(i));
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Наибольший элемент в матрице: " + maxResult);
    }

    static class MatrixMaxFinderRunnable implements Runnable {
        private int row;

        MatrixMaxFinderRunnable(int row) {
            this.row = row;
        }

        public void run() {
            int maxInRow = Integer.MIN_VALUE;
            for (int j = 0; j < matrix[row].length; j++) {
                if (matrix[row][j] > maxInRow) {
                    maxInRow = matrix[row][j];
                }
            }
            synchronized (MatrixMaxFinder.class) {
                if (maxInRow > maxResult) {
                    maxResult = maxInRow;
                }
            }
        }
    }
}
