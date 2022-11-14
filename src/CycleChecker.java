import java.util.ArrayList;

public class CycleChecker {
    public boolean check(double q, double x) {
        if((double)(x/q) > 10000) return false;
        boolean isCycle = false;

        ArrayList<Long> results = new ArrayList<>();
        long temp = (long) x;
        int pointer = 0;
        while(pointer < 100) {
            temp = (long) (temp%2==0? temp/2 : temp*(q)+1);
            if(results.contains(temp)) {
                if(!results.contains(1l)) isCycle = true; // Check for non-trivial cycles
                break;
            }
            results.add(temp);
            pointer++;
        }

        return isCycle;
    }
}
