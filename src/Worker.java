import lib.Algo;
import lib.Clock;
import lib.ConfigurationForLimitTest;
import lib.CycleChecker;
import lib.Utils;

public class Worker implements Runnable {
    int NestedSize;
    int q;
    int c;

    public Worker(int q, int c, int NestedSize) {
        this.q = q;
        this.NestedSize = NestedSize;
        this.c = c;
    }

    @Override
    public void run() {
        Clock c = new Clock(NestedSize, q + 1);
        do {
            double K = Algo.LVE(ConfigurationForLimitTest.MaxX, q, this.c, c.Clock);
            for (int k = 0; k <= Math.ceil(K); k++) {
                int[] total = new int[c.Clock.length + 1];
                System.arraycopy(c.Clock, 0, total, 0, c.Clock.length);
                System.arraycopy(new int[] { k }, 0, total, c.Clock.length, 1);
                double X = Algo.tail(q, this.c, total);
                int maxProbableCycleLength = c.Clock.length;
                for(int temp = 0; temp < c.Clock.length; temp++) maxProbableCycleLength += c.Clock[temp];
                if (Utils.isInt(X) && CycleChecker.check(q, this.c , X, maxProbableCycleLength) && X < ConfigurationForLimitTest.MaxX) {
                    System.out.println(q + "," + this.c + "," + X);
                    }
            }
        } while (c.add());
    }
}