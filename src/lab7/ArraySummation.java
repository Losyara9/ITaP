public class ArraySummation {
    private static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int result = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ArraySummationRunnable(0, array.length / 2));
        Thread thread2 = new Thread(new ArraySummationRunnable(array.length / 2, array.length));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Сумма элементов массива: " + result);
    }

    static class ArraySummationRunnable implements Runnable {
        private int start;
        private int end;

        ArraySummationRunnable(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            synchronized (ArraySummation.class) {
                result += sum;
            }
        }
    }
}
