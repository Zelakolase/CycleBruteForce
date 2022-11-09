import java.util.ArrayList;

public class LimitTestLvl2 {
    private volatile static ArrayList<double[]> results = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("q,x");
        for(int q = 1; q < 5000;q+=2) {
            double x = 10e100 + 1;
            for(int a = 0; a < 20; a++) {
                for(int b = 0; b < 20; b++) {
                    double C = Math.log((1+q)*((Utils.TwoPow(-b) * ((1+q)*(Utils.TwoPow(-a)*(1+q*(x))))) / (x))) / Utils.log2;
                    for(int i = 0;i <= Math.ceil(C);i++) {
                        double X = (Utils.TwoPow(a+b) + Utils.TwoPow(a) * q + Utils.XPow(q, 2)) / (Utils.TwoPow(a+b+i) - Utils.XPow(q, 2));
                        if(X == (int) X) {
                            if(CycleChecker.check(q, X)) results.add(new double[] {q,X});
                        }
                    }
                }
            }
        for(double[] i : results) {
            System.out.println(i[0]+","+i[1]);
        }
        }
    }
}
