public class LimitTestLvl4 {
    public static void main(String[] args) {
        double x = 10e100 + 1;
        System.out.println("q,x");
        for(int q = 3; q < 5001;q+=2) {
            for(int a = 0;a < 30; a++) {
                for(int b = 0;b < 30;b++) {
                    for(int c = 0;c < 30;c++) {
                        for(int d = 0;d < 30; d++) {
                            double temp = Utils.TwoPow(a+b+c+d) + (q*Utils.TwoPow(a+b+c)) + (Utils.XPow(q, 2)*Utils.TwoPow(a+b)) + (Utils.TwoPow(a)*Utils.XPow(q, 3)) + Utils.XPow(q, 4);
                            double E = Math.log((temp + (x*Utils.XPow(q, 5)))/x) / Utils.log2;
                            E += -a-b-c-d;
                            for(int e = 0;e <= Math.ceil(E);e++) {
                                double X = temp / (Utils.TwoPow(a+b+c+d+e) - Utils.XPow(q, 5));
                                if(X == (int) X) if(CycleChecker.check(q, X)) System.out.println("For q="+q+", x="+X);
                            }
                        }
                    }
                }
            }
        }
    }    
}