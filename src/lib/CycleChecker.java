package lib;

import java.util.Arrays;

public class CycleChecker {
    public static boolean check(double q, double x) {
        if(x == 1 || x == -1) return false;
        boolean isCycle = false;

        long[] results = new long[100];
        long temp = (long) x;
        int pointer = 0;
        while(pointer < 100) {
            temp = (long) (temp%2==0? temp/2 : temp*(q)+1);
            if(temp == 1 || temp == -1) break;
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
