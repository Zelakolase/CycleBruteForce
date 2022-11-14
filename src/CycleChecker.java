import java.util.Arrays;

public class CycleChecker {
    public boolean check(double q, double x) {
        boolean isCycle = false, whileStopper = false;

        double[] results = new double[101];
        results[0] = x;
        double temp = x;
        int pointer = 1;
        while(!whileStopper || pointer < 100) {
            temp = temp%2==0? temp/2 : temp*(q)+1;
            if(Arrays.binarySearch(results, temp) >=0) {
                whileStopper = true;
                if(!Utils.isInt(Math.log(temp) / Utils.log2) || Arrays.binarySearch(results, 1) < 0) isCycle = true; // Check for non-trivial cycles
            }
            results[pointer] = temp;
            if(pointer < 100) pointer++;
            else break;
        }

        return isCycle;
    }
}
