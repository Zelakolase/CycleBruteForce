public class LimitTestLvl3 {
    public static void main(String[] args) {
        double x = 10e100 + 1;
        System.out.println("q,x");
        for(int q = 3; q < 5001;q+=2) {
            for(int a = 0;a < 30;a++) {
                for(int b = 0;b < 30;b++) {
                    for(int c = 0;c < 30;c++) {
                        double D = Math.log((Utils.TwoPow(a+b+c) + Utils.TwoPow(a+b)*q + Utils.TwoPow(a)*Utils.XPow(q, 2) + Utils.XPow(q, 3) + Utils.XPow(q, 4)*x) / (x)) / Utils.log2;
                        D += -a-b-c;
                        for(int i = 0;i <= Math.ceil(D);i++) {
                            double X = (-Utils.TwoPow(a+b+c) - q*Utils.TwoPow(a+b) - Utils.TwoPow(a)*Utils.XPow(q, 2) - Utils.XPow(q, 3)) / (-Utils.TwoPow(a+b+c+i) + Utils.XPow(q, 4));
                            if(X == (int) X) if(CycleChecker.check(q, X)) System.out.println("For q="+q+", x="+X);
                        }
                    }
                }                
            }
        }
    }
}
