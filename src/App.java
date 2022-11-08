import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    static int MaxQ = 10_000_000;
    static int MaxX = 5_000_000;
    static int MIPL = 20; // Optimal depth, do NOT edit

    public static void main(String[] args) throws Exception {
        System.out.println("q,cycle");
        ExecutorService ES = Executors.newFixedThreadPool(10);
        for (int i = 1; i < MaxQ; i += 2) { // Odd 'q's only!
            if(
                !Utils.isInt(Math.log(i+1) / Utils.log2)
            ) {
                Worker W = new Worker(i, MaxX, MIPL);
                ES.execute(W);
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
