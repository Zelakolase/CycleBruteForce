import java.util.Arrays;

public class Equation {
    public static double solve(double q, double x, double[] iterators) {
        double result = 0;
        double body = 0;
        boolean onetime = true;
        for(int i = iterators.length+1; i > 1; i--) {
            if(onetime) {
                body += x * Utils.XPow(q, i);
                onetime = false;
            }
            else body += Utils.XPow(q, i);
        }
        body += q * Utils.TwoPow((long) iterators[0]);
        
        double temp = 0;
        for(int i = 1;i < iterators.length;i++) {
            temp += Utils.TwoPow((long) sumArr(Arrays.copyOfRange(iterators, 0, i+1)));
  
        }

        body += temp;
        body /= x;

        result = Math.log(body) / Utils.log2;
        
        for(int i = 0;i < iterators.length;i++) {
            result -= iterators[i];
        }

        return result;
    }
    private static double sumArr(double[] arr) {
        double out = 0;
        for(double t : arr) {
            out += t;
        }
        return out;
    }
}
