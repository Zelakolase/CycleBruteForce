
public class LimitTestLvl2 {
    public static void main(String[] args) {
        CycleChecker CycleChecker = new CycleChecker();
        double x = ConfigurationForLimitTest.MaxX;
        for(int q = ConfigurationForLimitTest.MinQ; q < ConfigurationForLimitTest.MaxQ;q+=2) {
            for(int a = 0; a < ConfigurationForLimitTest.MIPL; a++) {
                for(int b = 0; b < ConfigurationForLimitTest.MIPL; b++) {
                    double C = (Math.log((
                        (x*Utils.XPow(q, 3)) +
                        (Utils.XPow(q, 2)) +
                        (Utils.TwoPow(a) * q) +
                        (Utils.TwoPow(a+b))
                    ) / (x))) / Utils.log2;
                    C += -a-b;
                    for(int i = 0;i <= Math.ceil(C);i++) {
                        double X = (
                            -Utils.TwoPow(a+b) - 
                            (Utils.TwoPow(a) * q) -
                            Utils.XPow(q, 2)
                        ) / (-Utils.TwoPow(a+b+i) + Utils.XPow(q, 3));
                        if(Utils.isInt(X) && CycleChecker.check(q, X)) System.out.println(q+","+X);
                    }
                }
            }
        }
    }
}
