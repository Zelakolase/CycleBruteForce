import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lib.ConfigurationForLimitTest;

public class App {
    /*
     * Main Instance
     */
    public static void main(String[] args) {
        System.out.println("Level, Q, C, X, CycleLength");
        int MinLevel = 0; // Inclusive
        int MaxLevel = 10; // Exclusive
        /*
         * Avoid Context Switching
         */
        ExecutorService ES = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        /*
         * Looping through all 'q' values from Minimum (inclusive) to Maximum (exclusive), 
         * odd 'q' values only.
         */
        for (int q = ConfigurationForLimitTest.MinQ; q < ConfigurationForLimitTest.MaxQ; q+=2) {
            /*
             * Looping through all loop levels/complexities from Minimum (inclusive) to Maxiumum (exclusive)
             */
            for (int level = MinLevel; level < MaxLevel; level++) {
                /*
                 * Looping through all 'c' values from Minimum (inclusive) to Maximum (exclusive), 
                 * odd 'c' values only.
                 */
                for(int c = ConfigurationForLimitTest.MinC; c < ConfigurationForLimitTest.MaxC; c+=2) {
                    Worker w = new Worker(q, c, level);
                    ES.submit(w);
                }
            }
        }
        SoftShutdown(ES);
    }

    /*
     * Shut downs the thread pool after 20 days or when all tasks are finished, which is earlier.
     */
    public static void SoftShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(480, TimeUnit.HOURS)) threadPool.shutdownNow();
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
