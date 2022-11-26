package Oldv2;

import lib.Algo;
import lib.ConfigurationForLimitTest;
import lib.CycleChecker;
import lib.Utils;

public class LimitTestLvl1 {
    public static void main(String[] args) {
        double x = ConfigurationForLimitTest.MaxX;
        for(int q = ConfigurationForLimitTest.MinQ;q < ConfigurationForLimitTest.MaxQ;q += 2) {
            for(int a = 0; a < q+1; a++) {
                double B = Algo.LVE(x, q, new int[] {a});
                for(int it = 0; it <= Math.ceil(B); it++) {
                    double X = Algo.tail(q, new int[] {a, it});
                    if(Utils.isInt(X) && CycleChecker.check(q, X)) System.out.println(q+","+X);
                }
            }
        }
    }
}
