import java.util.concurrent.Callable;

public class LoaderC implements Callable<Integer> {
    public int currentWeight;
    LoaderC(int weight) {
        currentWeight = weight;
    }
    @Override
    public Integer call() throws InterruptedException {
        synchronized (Loader.class) {
            Loader.currentWeight += currentWeight;
            if (Loader.currentWeight > 150) {
                System.out.println("вес выше 150кг");
                Thread.sleep(3000);
            }
        }
        return currentWeight;
    }
}
