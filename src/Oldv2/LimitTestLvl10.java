package Oldv2;

import lib.Algo;
import lib.ConfigurationForLimitTest;
import lib.CycleChecker;
import lib.Utils;

public class LimitTestLvl10 {
    public static void main(String[] args) {
        double x = ConfigurationForLimitTest.MaxX;
        for (int q = ConfigurationForLimitTest.MinQ; q < ConfigurationForLimitTest.MaxQ; q += 2) {
            for (int a = 0; a < q + 1; a++) {
                for (int b = 0; b < q + 1; b++) {
                    for (int c = 0; c < q + 1; c++) {
                        for (int d = 0; d < q + 1; d++) {
                            for (int e = 0; e < q + 1; e++) {
                                for (int f = 0; f < q + 1; f++) {
                                    for (int g = 0; g < q + 1; g++) {
                                        for (int h = 0; h < q + 1; h++) {
                                            for (int i = 0; i < q + 1; i++) {
                                                for (int j = 0; j < q + 1; j++) {
                                                    double K = Algo.LVE(x, q,
                                                            new int[] { a, b, c, d, e, f, g, h, i, j });
                                                    for (int k = 0; k <= Math.ceil(K); k++) {
                                                        double X = Algo.tail(q,
                                                                new int[] { a, b, c, d, e, f, g, h, i, j, k });
                                                        if (Utils.isInt(X) && CycleChecker.check(q, X))
                                                            System.out.println(q + "," + X);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
