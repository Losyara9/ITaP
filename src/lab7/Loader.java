import java.util.concurrent.*;

public class Loader {
    static int currentWeight;
    public static void main(String[] args) {
        int[] weight = new int[]{30, 60, 20, 50, 50, 70};
        ExecutorService service = Executors.newFixedThreadPool(3);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(service);
        for (int i = 0; i < weight.length - 2; i += 3) {
            if (currentWeight >= 150) {
                try {
                    System.out.println("идет разгрузка");
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                currentWeight = 0;
            }
            completionService.submit(new LoaderC(weight[i]));
            completionService.submit(new LoaderC(weight[i + 1]));
            completionService.submit(new LoaderC(weight[i + 2]));
            try {
                Future<Integer> res1 = completionService.take();
                System.out.println("Товар " + res1.get() + " кг загружен");
                Future<Integer> res2 = completionService.take();
                System.out.println("Товар  " + res2.get() + " кг загружен");
                Future<Integer> res3 = completionService.take();
                System.out.println("Товар  " + res3.get() + " кг загружен");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        service.shutdown();
        System.out.println("товары разгружены");
    }
}
