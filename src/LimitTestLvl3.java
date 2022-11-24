import lib.ConfigurationForLimitTest;
import lib.Utils;

public class LimitTestLvl3 {
    public static void main(String[] args) {
        CycleChecker CycleChecker = new CycleChecker();
        double x = ConfigurationForLimitTest.MaxX;
        for(int q = ConfigurationForLimitTest.MinQ; q < ConfigurationForLimitTest.MaxQ;q+=2) {
            for(int a = 0;a < q+1;a++) {
                for(int b = 0;b < q+1;b++) {
                    for(int c = 0;c < q+1;c++) {
                        double D = Algo.LVE(x, q, new int[] {a, b, c});
                        for(int i = 0;i <= Math.ceil(D);i++) {
                            double X = Algo.tail(q, new int[] {a,b,c, i});
                            if(Utils.isInt(X) && CycleChecker.check(q, X)) System.out.println(q+","+X);
                        }
                    }
                }                
            }
        }
    }
}
