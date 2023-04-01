package lib;

import java.util.Arrays;

public class Clock {
    /*
     * A multivariate clock
     */

    public int[] Clock;
    int UpperBoundary = 0;

    public Clock(int Length, int UB) {
        UpperBoundary = UB;
        Clock = new int[Length];
        Arrays.fill(Clock, 0);
    }

    /*
     * Every add() increases the multivariate clock by 1 (one tick)
     */
    public boolean add() {
        int tempIndex = 0; 
        boolean done = false;
        while(!done) {
            if(Clock[tempIndex] == UpperBoundary) {
                if(tempIndex < Clock.length-1) tempIndex++;
                else break;
            }else {
                Clock[tempIndex] += 1;
                Arrays.fill(Clock, 0, tempIndex, 0);
                done = true;
            }
        }

        return done;
    }
}