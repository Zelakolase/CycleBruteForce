import java.util.ArrayList;

public class Worker implements Runnable {
    private int q;
    private int MaxX;
    private int MIPL;
    private ArrayList<Integer> results = new ArrayList<>();

    public Worker(int q, int maxX, int mIPL) {
        this.q = q;
        this.MIPL = mIPL;
        this.MaxX = maxX;
    }

    @Override
    public void run() {
        for (int x = 3; x < MaxX; x += 2) {
            if (check(x)) {
                for (int a = 0; a < MIPL; a++) {
                    double X_0 = (q * (x) + 1) / (Utils.TwoPow(a));
                    if (X_0 == x && !results.contains(x))
                        results.add(x);

                    for (int b = 0; b < MIPL; b++) {
                        double X_1 = (q * (X_0) + 1) / (Utils.TwoPow(b));
                        if (X_1 == x && !results.contains(x))
                            results.add(x);

                        for (int c = 0; c < MIPL; c++) {
                            double X_2 = (q * (X_1) + 1) / (Utils.TwoPow(c));
                            if (X_2 == x && !results.contains(x))
                                results.add(x);

                            for (int d = 0; d < MIPL; d++) {
                                double X_3 = (q * (X_2) + 1) / (Utils.TwoPow(d));
                                if (X_3 == x && !results.contains(x))
                                    results.add(x);

                                for (int e = 0; e < MIPL; e++) {
                                    double X_4 = (q * (X_3) + 1) / (Utils.TwoPow(e));
                                    if (X_4 == x && !results.contains(x))
                                        results.add(x);
                                }
                            }
                        }
                    }
                }
            }
        }
        if(results.size()>0) {
            for(Integer r : results) System.out.println(q+","+r);
        }
    }

    public boolean check(double x) {
        return !Utils.isInt(Math.log(x * q + 1) / Utils.log2);
    }
}
