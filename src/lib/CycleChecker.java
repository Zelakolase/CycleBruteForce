package lib;

import java.util.Arrays;

public class CycleChecker {
    public static boolean check(double q, double c, double x, int maxProbableCycleLength) {
        boolean isCycle = false;

        long[] results = new long[maxProbableCycleLength];
        long temp = (long) x;
        int pointer = 0;
        while(pointer < maxProbableCycleLength) {
            temp = (long) (temp%2==0? temp/2 : temp*(q)+c);
            if(Arrays.binarySearch(results, temp) >= 0) {
                isCycle = true;
                if(Arrays.binarySearch(results, 1) >= 0) isCycle = false;
                break;
            }
            results[pointer] = temp;
            pointer++;
        }
        return isCycle;
    }
}
