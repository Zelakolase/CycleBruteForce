package lib;

public class Utils {
    public static double log2 = Math.log(2);

    /*
     * returns the result of 2^power using bitshifting
     */
    public static double TwoPow(long power) {
        return (1l << power);
    }

    /*
     * returns x^y using square-and-multiply algorithm
     */
    public static double XPow(double x, int y) {
        int result = 1;
        while (y != 0) {
            if ((y & 1) == 1) result *= x;
            y >>= 1;
            x *= x;
        }
        return (double) result;
    }

    /*
     * Checks if 'd' is an integer and an odd number
     */
    public static boolean isIntandOdd(double d) {
        return (d == (int) d) && (d % 2 != 0);
    }

    /*
     * Finds the distance between two identical long values in a long[]
     * Written by ChatGPT
     */
    public static long findDistance(long[] arr, long value) {
        long index1 = -1;
        long index2 = -1;
        long distance = -1;
    
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                if (index1 == -1) index1 = i;
                else {
                    index2 = i;
                    distance = index2 - index1;
                    break;
                }
            }
        }
        return distance;
    }
}