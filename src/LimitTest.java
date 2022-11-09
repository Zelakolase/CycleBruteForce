public class LimitTest {
    public static void main(String[] args) {
        System.out.println("q,x");
        double x = 10e100 + 1;
        for(int q = 1;q < 5000;q += 2) {
            double A = Math.log((x*(q)+1)/(x)) / Utils.log2;
            for(int i = 0;i <= Math.ceil(A); i++) {
                double X = 1 / (Utils.TwoPow(i) - q);
                if(X == (int) X && CycleChecker.check(q, X)) System.out.println(q+","+X);
            }
        }
    }
}
