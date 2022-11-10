public class LimitTestLvl6 {
    public static void main(String[] args) {
        double x = ConfigurationForLimitTest.MaxX;
        for (int q = ConfigurationForLimitTest.MinQ; q < ConfigurationForLimitTest.MaxQ; q += 2) {
            for (int a = 0; a < ConfigurationForLimitTest.MIPL; a++) {
                for (int b = 0; b < ConfigurationForLimitTest.MIPL; b++) {
                    for (int c = 0; c < ConfigurationForLimitTest.MIPL; c++) {
                        for (int d = 0; d < ConfigurationForLimitTest.MIPL; d++) {
                            for (int e = 0; e < ConfigurationForLimitTest.MIPL; e++) {
                                for(int f = 0; f < ConfigurationForLimitTest.MIPL; f++) {
                                    double G = Math.log(
                                        (1/x)*(
                                            (Utils.TwoPow(a+b+c+d+e+f))+
                                            (q*Utils.TwoPow(a+b+c+d+e))+
                                            (Utils.XPow(q, 2)*Utils.TwoPow(a+b+c+d))+
                                            (Utils.XPow(q, 3)*Utils.TwoPow(a+b+c))+
                                            (Utils.TwoPow(a+b)*Utils.XPow(q, 4))+
                                            (Utils.XPow(q, 5)*Utils.TwoPow(a))+
                                            (Utils.XPow(q, 6))+
                                            (x*Utils.XPow(q, 7))
                                        )
                                    ) / Utils.log2;
                                    G += -a-b-c-d-e-f;
                                    for(int g = 0;g <= Math.ceil(G);g++) {
                                        double X = -Utils.TwoPow(a+b+c+d+e+f) -
                                        (Utils.TwoPow(a+b+c+d+e)*q)-
                                        (Utils.TwoPow(a+b+c+d)*Utils.XPow(q, 2))-
                                        (Utils.TwoPow(a+b+c)*Utils.XPow(q, 3))-
                                        (Utils.TwoPow(a+b)*Utils.XPow(q, 4)) -
                                        (Utils.XPow(q, 5)*Utils.TwoPow(a)) - Utils.XPow(q, 6);
                                        X = X / (-Utils.TwoPow(a+b+c+d+e+f+g) + Utils.XPow(q, 7));
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
    }