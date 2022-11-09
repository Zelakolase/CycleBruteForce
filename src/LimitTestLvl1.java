public class LimitTestLvl1 {
    public static void main(String[] args) {
        double x = 2e100 + 1;
        for(int q = 1;q < 20;q += 2) {
            for(int a = 1; a < 20; a++) {
                double B = Math.log(((x * Utils.XPow(q, 2)) + q + Utils.TwoPow(a)) / (x)) / Utils.log2;
                B += -a;
                for(int it = 0; it < Math.ceil(B); it++) {
                    double X = (-Utils.TwoPow(a) - q) / (-Utils.TwoPow(a+it) + Utils.XPow(q, 2));
                    if((int) X == X) System.out.println("For q="+q+", x="+X);
                }
            }
        }
    }
}
