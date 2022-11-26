package Oldv2;

import lib.Algo;
import lib.ConfigurationForLimitTest;
import lib.CycleChecker;
import lib.Utils;

public class LimitTestLvl2 {
    public static void main(String[] args) {
        double x = ConfigurationForLimitTest.MaxX;
        for(int q = ConfigurationForLimitTest.MinQ; q < ConfigurationForLimitTest.MaxQ;q+=2) {
            for(int a = 0; a < q+1; a++) {
                for(int b = 0; b < q+1; b++) {
                    double C = Algo.LVE(x, q, new int[] {a,b});
                    for(int i = 0;i <= Math.ceil(C);i++) {
                        double X = Algo.tail(q, new int[] {a,b,i});
                        if(Utils.isInt(X) && CycleChecker.check(q, X)) {
                            System.out.println(q+","+X);
                        }
                    }
                }
            }
        }
    }
}
