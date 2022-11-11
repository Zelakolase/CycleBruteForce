public class LimitTest {
    public static void main(String[] args) {
        CycleChecker CycleChecker = new CycleChecker();
        double x = ConfigurationForLimitTest.MaxX;
        for(int q = ConfigurationForLimitTest.MinQ;q < ConfigurationForLimitTest.MaxQ;q += 2) {
            double A = Math.log((x*(q)+1)/(x)) / Utils.log2;
            for(int i = 0;i <= Math.ceil(A); i++) {
                double X = 1 / (Utils.TwoPow(i) - q);
                if(Utils.isInt(X) && CycleChecker.check(q, X)) System.out.println(q+","+X);
            }
        }
    }
}
