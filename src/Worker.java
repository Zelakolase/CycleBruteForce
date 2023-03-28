import lib.Algo;
import lib.Clock;
import lib.ConfigurationForLimitTest;
import lib.CycleChecker;
import lib.Utils;

public class Worker implements Runnable {
    int NestedSize;
    int q;

    public Worker(int q, int NestedSize) {
        this.q = q;
        this.NestedSize = NestedSize;
    }

    @Override
    public void run() {
        boolean exists = false;
        Clock c = new Clock(NestedSize, q + 1);
        do {
            double K = Algo.LVE(ConfigurationForLimitTest.MaxX, q, c.Clock);
            for (int k = 0; k <= Math.ceil(K); k++) {
                int[] total = new int[c.Clock.length + 1];
                System.arraycopy(c.Clock, 0, total, 0, c.Clock.length);
                System.arraycopy(new int[] { k }, 0, total, c.Clock.length, 1);
                double X = Algo.tail(q, total);
                if (Utils.isInt(X) && CycleChecker.check(q, X) && X < ConfigurationForLimitTest.MaxX) {
                    exists = true;
                    System.out.println(q + "," + X);
                    }
            }
        } while (c.add());
        if(!exists) System.out.println("No cycles for q="+q);
    }
}