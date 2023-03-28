package lib;

import java.util.Arrays;

public class CycleChecker {
    public static boolean check(double q, double x) {
        boolean isCycle = false;

        long[] results = new long[150];
        long temp = (long) x;
        int pointer = 0;
        while(pointer < 150) {
            temp = (long) (temp%2==0? temp/2 : temp*(q)+1);
            if(Arrays.binarySearch(results, temp) >= 0) {
                isCycle = true;
                break;
            }
            results[pointer] = temp;
            pointer++;
        }
        return isCycle;
    }
}
