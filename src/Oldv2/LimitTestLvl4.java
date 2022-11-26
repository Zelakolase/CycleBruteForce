package Oldv2;

import lib.Algo;
import lib.ConfigurationForLimitTest;
import lib.CycleChecker;
import lib.Utils;

public class LimitTestLvl4 {
    public static void main(String[] args) {
        double x = ConfigurationForLimitTest.MaxX;
        for(int q = ConfigurationForLimitTest.MinQ; q < ConfigurationForLimitTest.MaxQ;q+=2) {
            for(int a = 0;a < q+1; a++) {
                for(int b = 0;b < q+1;b++) {
                    for(int c = 0;c < q+1;c++) {
                        for(int d = 0;d < q+1; d++) {
                            double E = Algo.LVE(x, q, new int[] {a, b, c, d});
                            for(int e = 0;e <= Math.ceil(E);e++) {
                                double X = Algo.tail(q, new int[] {a,b,c,d,e});
                                if(Utils.isInt(X) && CycleChecker.check(q, X)) System.out.println(q+","+X);
                            }
                        }
                    }
                }
            }
        }
    }    
}