import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lib.ConfigurationForLimitTest;

public class App {
    public static void main(String[] args) {
        int MinLevel = 0; // Inclusive
        int MaxLevel = 100; // Exclusive
        ExecutorService ES = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println("For qx+c");
        System.out.println("q, c, x");
        for (int q = ConfigurationForLimitTest.MinQ; q < ConfigurationForLimitTest.MaxQ; q+=2) {
            for (int i = MinLevel; i < MaxLevel; i++) {
                for(int c = ConfigurationForLimitTest.MinC; c < ConfigurationForLimitTest.MaxC; c+=2) {
                Worker w = new Worker(q, c, i);
                ES.submit(w);
                }
            }
        }
        atAS(ES);
    }

    public static void atAS(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(480, TimeUnit.HOURS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
