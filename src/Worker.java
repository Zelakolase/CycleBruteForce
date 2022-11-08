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
            double X = Math.log((q * x + 1) / x) / Utils.log2;
            if (check(X, x) && !results.contains(x)) results.add(x);

            for (int a = 0; a < MIPL; a++) {
                double B = Math.log((x * Utils.XPow(q, 2) + q + Utils.TwoPow(a)) / x) / Utils.log2;
                B -= a;
                if (check(B, x) && !results.contains(x)) results.add(x);

                for(int b = 0; b < MIPL; b++) {
                    double C = Equation.solve(b, X, new double[] {a,b});
                    if(check(C, x) && !results.contains(x)) results.add(x);
                    
                    for(int c = 0;c < MIPL; c++) {
                        double D = Equation.solve(b, X, new double[] {a,b,c});
                        if(check(D, x) && !results.contains(x)) results.add(x);

                        for (int d = 0;d < MIPL; d++) {
                            double E = Equation.solve(b, X, new double[] {a,b,c,d});
                            if(check(E, x) && !results.contains(x)) results.add(x);

                            for(int e = 0;e < MIPL; e++) {
                                double F = Equation.solve(b, X, new double[] {a,b,c,d,e});
                                if(check(F, x) && !results.contains(x)) results.add(x);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("For q=" + q + ": " + results);
    }

    public boolean check(double d, double x) {
        return d == (int) d && d >= 0 && !Utils.isInt(Math.log(x * q + 1) / Utils.log2);
    }
}
