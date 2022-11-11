public class LimitTestLvl1 {
    public static void main(String[] args) {
        CycleChecker CycleChecker = new CycleChecker();
        double x = ConfigurationForLimitTest.MaxX;
        for(int q = ConfigurationForLimitTest.MinQ;q < ConfigurationForLimitTest.MaxQ;q += 2) {
            for(int a = 0; a < ConfigurationForLimitTest.MIPL; a++) {
                double B = Math.log(((x * Utils.XPow(q, 2)) + q + Utils.TwoPow(a)) / (x)) / Utils.log2;
                B += -a;
                for(int it = 0; it <= Math.ceil(B); it++) {
                    double X = (-Utils.TwoPow(a) - q) / (-Utils.TwoPow(a+it) + Utils.XPow(q, 2));
                    if(Utils.isInt(X) && CycleChecker.check(q, X)) System.out.println(q+","+X);
                }
            }
        }
    }
}
