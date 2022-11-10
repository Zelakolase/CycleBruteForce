public class LimitTestLvl5 {
    public static void main(String[] args) {
        double x = ConfigurationForLimitTest.MaxX;
        for (int q = ConfigurationForLimitTest.MinQ; q < ConfigurationForLimitTest.MaxQ; q += 2) {
            for (int a = 0; a < ConfigurationForLimitTest.MIPL; a++) {
                for (int b = 0; b < ConfigurationForLimitTest.MIPL; b++) {
                    for (int c = 0; c < ConfigurationForLimitTest.MIPL; c++) {
                        for (int d = 0; d < ConfigurationForLimitTest.MIPL; d++) {
                            for (int e = 0; e < ConfigurationForLimitTest.MIPL; e++) {
                                double F = Math.log(
                                    (1/x)*(
                                        Utils.TwoPow(a+b+c+d+e)+
                                        (q*Utils.TwoPow(a+b+c+d))+
                                        (Utils.XPow(q, 2)*Utils.TwoPow(a+b+c))+
                                        (Utils.TwoPow(a+b)*Utils.XPow(q, 3))+
                                        (Utils.TwoPow(a)*Utils.XPow(q, 5))+
                                        Utils.XPow(q, 5)+
                                        (Utils.XPow(q, 6)*x)
                                    )
                                ) / Utils.log2;
                                F += -a-b-c-d-e;
                                for(int f = 0;f <= Math.ceil(F);f++) {
                                    double X = -Utils.TwoPow(a+b+c+d+e) +
                                    (-Utils.TwoPow(a+b+c+d)*q)+
                                    (-Utils.TwoPow(a+b+c)*Utils.XPow(q, 2))+
                                    (-Utils.TwoPow(a+b)*Utils.XPow(q, 3))+
                                    (-Utils.TwoPow(a)*Utils.XPow(q, 4)) - Utils.XPow(q, 5);
                                    X = X / (-Utils.TwoPow(a+b+c+d+e+f) + Utils.XPow(q, 6));
                                    if(Utils.isInt(X) && CycleChecker.check(q, X)) System.out.println(q+","+X);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
