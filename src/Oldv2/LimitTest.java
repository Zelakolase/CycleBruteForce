package Oldv2;
import lib.Algo;
import lib.ConfigurationForLimitTest;
import lib.Utils;

public class LimitTest {
    public static void main(String[] args) {
        CycleChecker CycleChecker = new CycleChecker();
        double x = ConfigurationForLimitTest.MaxX;
        for(int q = ConfigurationForLimitTest.MinQ;q < ConfigurationForLimitTest.MaxQ;q += 2) {
            double A = Algo.LVE(x, q, new int[] {});
            for(int i = 0;i <= Math.ceil(A); i++) {
                double X = Algo.tail(q, new int[] {i});
                if(Utils.isInt(X) && CycleChecker.check(q, X)) System.out.println(q+","+X);
            }
        }
    }
}
