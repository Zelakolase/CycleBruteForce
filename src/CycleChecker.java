import java.util.ArrayList;

public class CycleChecker {
    public static boolean check(double q, double x) {
        ArrayList<Double> nums = new ArrayList<>() {{
            add(x);
        }};
        boolean check = false;
        double prev = x;
        int Size = 0;
        while(Size < 200 || !check) {
            prev = prev%2==0? prev/2 : (q*(prev))+1;
            if(nums.contains(prev)) {
                check = true;
            }else {
                nums.add(prev);
            }
            Size++;
        }

        return check;
    }
}
