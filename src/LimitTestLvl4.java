public class LimitTestLvl4 {
    public static void main(String[] args) {
        CycleChecker CycleChecker = new CycleChecker();
        double x = ConfigurationForLimitTest.MaxX;
        for(int q = ConfigurationForLimitTest.MinQ; q < ConfigurationForLimitTest.MaxQ;q+=2) {
            for(int a = 0;a < ConfigurationForLimitTest.MIPL; a++) {
                for(int b = 0;b < ConfigurationForLimitTest.MIPL;b++) {
                    for(int c = 0;c < ConfigurationForLimitTest.MIPL;c++) {
                        for(int d = 0;d < ConfigurationForLimitTest.MIPL; d++) {
                            double temp = Utils.TwoPow(a+b+c+d) + (q*Utils.TwoPow(a+b+c)) + (Utils.XPow(q, 2)*Utils.TwoPow(a+b)) + (Utils.TwoPow(a)*Utils.XPow(q, 3)) + Utils.XPow(q, 4);
                            double E = Math.log((temp + (x*Utils.XPow(q, 5)))/x) / Utils.log2;
                            E += -a-b-c-d;
                            for(int e = 0;e <= Math.ceil(E);e++) {
                                double X = (
                                    -Utils.TwoPow(a+b+c+d)
                                    -(Utils.TwoPow(a+b+c)*q)
                                    -(Utils.TwoPow(a+b)*Utils.XPow(q, 2))
                                    -(Utils.TwoPow(a)*Utils.XPow(q, 3))
                                    -Utils.XPow(q, 4)
                                ) / (-Utils.TwoPow(a+b+c+d+e) + Utils.XPow(q, 5));
                                if(Utils.isInt(X) && CycleChecker.check(q, X)) System.out.println(q+","+X);
                            }
                        }
                    }
                }
            }
        }
    }    
}