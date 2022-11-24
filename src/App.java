import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        System.out.println("q,x");
        ExecutorService ES = Executors.newCachedThreadPool();
        ES.submit(new RunnableWrappers.L0());
        ES.submit(new RunnableWrappers.L1());
        ES.submit(new RunnableWrappers.L2());
        ES.submit(new RunnableWrappers.L3());
        ES.submit(new RunnableWrappers.L4());
        ES.submit(new RunnableWrappers.L5());
        ES.submit(new RunnableWrappers.L6());
        ES.submit(new RunnableWrappers.L7());
        ES.submit(new RunnableWrappers.L8());
        ES.submit(new RunnableWrappers.L9());
        ES.submit(new RunnableWrappers.L10());
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