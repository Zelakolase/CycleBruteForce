import java.util.ArrayList;

public class CycleChecker {
    public static boolean check(double q, double x) {
        if(x<0) return false;
        ArrayList<Double> nums = new ArrayList<>() {{
            add(x);
        }};
        boolean check = false;
        double prev = x;
        int Size = 0;
        while(Size < 10 || !check) {
            prev = prev%2==0? prev/2 : (q*(prev))+1;
            if(nums.contains(prev)) {
                check = true;
            }else {
                nums.add(prev);
            }
            Size++;
        }
        if(nums.contains(1d) || nums.contains(-1d)) check = false;

        return check;
    }
}
