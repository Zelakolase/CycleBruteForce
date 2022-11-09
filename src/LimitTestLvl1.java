public class LimitTestLvl1 {
    public static void main(String[] args) {
        System.out.println("q,x");
        double x = 10e100 + 1;
        for(int q = 3;q < 5001;q += 2) {
            for(int a = 0; a < 30; a++) {
                double B = Math.log(((x * Utils.XPow(q, 2)) + q + Utils.TwoPow(a)) / (x)) / Utils.log2;
                B += -a;
                for(int it = 0; it <= Math.ceil(B); it++) {
                    double X = (-Utils.TwoPow(a) - q) / (-Utils.TwoPow(a+it) + Utils.XPow(q, 2));
                    if((int) X == X) if(CycleChecker.check(q, X)) System.out.println("For q="+q+", x="+X);
                }
            }
        }
    }
}
