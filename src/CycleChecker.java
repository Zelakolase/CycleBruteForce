import java.util.Arrays;

public class CycleChecker {
    public boolean check(double q, double x) {
        boolean isCycle = false, whileStopper = false;

        double[] results = new double[201];
        results[0] = x;
        double temp = x;
        int pointer = 1;
        while(!whileStopper || pointer < 200) {
            temp = temp%2==0? temp/2 : temp*(q)+1;
            if(Arrays.binarySearch(results, temp) >=0) {
                whileStopper = true;
                if(Arrays.binarySearch(results, 1) < 0) isCycle = true; // Check for non-trivial cycles
            }
            results[pointer] = temp;
            if(pointer < 200) pointer++;
            else break;
        }

        return isCycle;
    }
}
