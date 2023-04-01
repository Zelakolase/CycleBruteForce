package lib;
import java.util.Arrays;

public class Algo {
    /*
     * Tail Equation
     * int[] vars : all a,b,c,... values
     */
    public static double tail(int q, int c, int[] vars) {
        double result = 0;
        double numerator = 0, denominator = 0;
        if(vars.length == 1) {
            numerator = -1;
        }else {
            int counter = 0;
            for(int i = vars.length; i > 0; i--) {
                numerator -= Utils.TwoPow(sums(Arrays.copyOfRange(vars, 0, i-1))) * Utils.XPow(q, counter) * c;
                counter++;
            }
        }
        int TAll = sums(vars);
        denominator = -Utils.TwoPow(TAll) + Utils.XPow(q, vars.length);
        result = numerator / denominator;
        return result;
    }

    /*
     * returns the sum of all integers in an integer array
     */
    private static int sums(int[] vars) {
        int result = 0;
        for(int v : vars) result += v;
        return result;
    }

    /*
     * Last Variable Equation
     * int[] vars : all a,b,c,... values
     */
    public static double LVE(double x, int q, int c, int[] vars) {
        double numerator = 0;
        int counter = 0;
        for(int i = vars.length+1; i > 0; i--) {
            numerator += Utils.TwoPow(sums(Arrays.copyOfRange(vars, 0, i-1))) * Utils.XPow(q, counter) * c;
            counter += 1;
        }
        numerator += Utils.XPow(q, counter) * x;
        numerator = Math.log(numerator / x) / Utils.log2;
        for(int v : vars) numerator -= v;

        return numerator;
    }
}
