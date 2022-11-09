
public class LimitTestLvl2 {
    public static void main(String[] args) {
        double x = 10e100 + 1;
        System.out.println("q,x");
        for(int q = 3; q < 5001;q+=2) {
            for(int a = 0; a < 30; a++) {
                for(int b = 0; b < 30; b++) {
                    double C = Math.log((1+q)*((Utils.TwoPow(-b) * ((1+q)*(Utils.TwoPow(-a)*(1+q*(x))))) / (x))) / Utils.log2;
                    for(int i = 0;i <= Math.ceil(C);i++) {
                        double X = (Utils.TwoPow(a+b) + Utils.TwoPow(a) * q + Utils.XPow(q, 2)) / (Utils.TwoPow(a+b+i) - Utils.XPow(q, 2));
                        if(X == (int) X) if(CycleChecker.check(q, X)) System.out.println("For q="+q+", x="+X);
                    }
                }
            }
        }
    }
}
