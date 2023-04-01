import java.util.Arrays;

import lib.Algo;
import lib.Clock;
import lib.ConfigurationForLimitTest;
import lib.Utils;

public class Worker implements Runnable {
    /*
     * Individual thread class
     */

    int level;
    int q;
    int c;

    public Worker(int q, int c, int level) {
        this.q = q;
        this.level = level;
        this.c = c;
    }

    @Override
    public void run() {
        /*
         * Only God knows how does it work.
         */
        Clock c = new Clock(level, q + 1);
        do {
            double K = Algo.LVE(ConfigurationForLimitTest.MaxX, q, this.c, c.Clock);
            for (int k = 0; k <= Math.ceil(K); k++) {
                int[] total = new int[c.Clock.length + 1];
                System.arraycopy(c.Clock, 0, total, 0, c.Clock.length);
                System.arraycopy(new int[] { k }, 0, total, c.Clock.length, 1);
                double X = Algo.tail(q, this.c, total);
                int maxProbableCycleLength = c.Clock.length;
                for (int temp = 0; temp < c.Clock.length; temp++)  maxProbableCycleLength += c.Clock[temp];
                if(Utils.isIntandOdd(X)) CycleChecker(X, maxProbableCycleLength); // Cycle Checker
            }
        } while (c.add());
    }

    private void CycleChecker(double X, int maxProbableCycleLength) {
        long[] results = new long[maxProbableCycleLength]; // The Collatz Sequence
        long temp = (long) X;
        int pointer = 0;
        inner: while (pointer < maxProbableCycleLength) {
            if(temp >= ConfigurationForLimitTest.MaxX) break inner;
            /*
             * The following line calculates the next Collatz value
             */
            temp = (long) (temp % 2 == 0 ? temp / 2l : (q * temp) + c);
            int endPointer = Arrays.binarySearch(results, temp);
            results[pointer] = temp;
            /*
             * If a cycle was detected and it does not have +1 or -1 in the sequence
             */
            if (endPointer >= 0) {
                if(! (Arrays.binarySearch(results, 1) >= 0 || Arrays.binarySearch(results, -1) >= 0)) System.out.println(level+", "+q+", "+c+", "+temp+", "+Utils.findDistance(results, temp));
                break inner;
            }
            pointer++;
        }
    }
}